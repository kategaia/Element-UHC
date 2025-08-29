package com.elementuhc;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

import java.util.HashMap;
import java.util.Map;

public class Scoreboard implements Listener {

    private final JavaPlugin plugin;
    private int gameTime = 0;
    private final Map<Player, Integer> kills = new HashMap<>();
    private BukkitTask task;
    private boolean runnig = false;

    public Scoreboard(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void start() {
        if(runnig) return;

        task = new BukkitRunnable() {
            @Override
            public void run(){
                gameTime ++;
                updateScoreboards();
            }
        }.runTaskTimer(plugin, 20L, 20L); // équivaut à chaque seconde

        runnig = true;

    }

    public void stop() {
        if (task != null) {
            task.cancel();
            task = null;
        }

        runnig = false;

    }

    public void setupPlayer(Player player) {

        kills.put(player, 0);
        updateScoreboard(player);

    }

    private void updateScoreboards() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            updateScoreboard(player);
        }
    }

    private void updateScoreboard(Player player) {

        Scoreboard board = (Scoreboard) Bukkit.getScoreboardManager().getNewScoreboard();

        Objective objective = ((org.bukkit.scoreboard.Scoreboard) board).registerNewObjective("uhc", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§a§lUHC");

        int hours = gameTime/3600;
        int minutes = (gameTime% 3600) /60;
        int seconds = gameTime % 60;
        String formatedTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);

        long alivePlayers = Bukkit.getOnlinePlayers().stream()
                .filter(p -> p.getGameMode() != GameMode.SPECTATOR)
                .count();

        Score time = objective.getScore("§7Temps: §f" + formatedTime);
        time.setScore(3);

        int Countkill = kills.getOrDefault(player, 0);
        Score killsScore = objective.getScore("§7Kills: §f" + Countkill);
        killsScore.setScore(2);

        Score alive = objective.getScore("§7 Joueur en vie: §f" + alivePlayers);
        alive.setScore(1);

        player.setScoreboard((org.bukkit.scoreboard.Scoreboard) board);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player victim = event.getEntity();
        Player killer = victim.getKiller();
        if(killer != null && killer != victim) {
            kills.put(killer, kills.getOrDefault(killer, 0) +1);
        }
    }

}
