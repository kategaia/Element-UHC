package com.elementuhc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.plugin.java.JavaPlugin;

public class UHCScoreboard {

    private Scoreboard board;
    private Objective objective;
    private JavaPlugin plugin; // référence à ton plugin pour le scheduler

    private int timeSeconds = 0; // compteur du temps écoulé

    public UHCScoreboard(JavaPlugin plugin) {
        this.plugin = plugin;

        // Création du scoreboard
        board = Bukkit.getScoreboardManager().getNewScoreboard();
        objective = board.registerNewObjective("uhc", "dummy");
        objective.setDisplayName(ChatColor.RED + "UHC Game");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        // Score initial
        updateScores();

        // Appliquer le scoreboard à tous les joueurs en ligne
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.setScoreboard(board);
        }

        // Démarrer le timer
        startTimer();
    }

    // Met à jour tous les scores du scoreboard
    public void updateScores() {
        // Supprimer les scores précédents pour éviter le doublon
        board.getEntries().forEach(board::resetScores);

        // Nombre de joueurs
        Score playersScore = objective.getScore(ChatColor.YELLOW + "Players: " + Bukkit.getOnlinePlayers().size());
        playersScore.setScore(2);

        // Timer format mm:ss
        int minutes = timeSeconds / 60;
        int seconds = timeSeconds % 60;
        String timeFormatted = String.format("%02d:%02d", minutes, seconds);
        Score timeScore = objective.getScore(ChatColor.GREEN + "Time: " + timeFormatted);
        timeScore.setScore(1);

        // Exemple de kills (à adapter)
        Score killsScore = objective.getScore(ChatColor.AQUA + "Kills: 0");
        killsScore.setScore(0);
    }

    // Démarre un timer toutes les secondes
    private void startTimer() {
        new BukkitRunnable() {
            @Override
            public void run() {
                timeSeconds++;
                updateScores();
            }
        }.runTaskTimer(plugin, 20L, 20L); // 20 ticks = 1 seconde
    }

    // Méthode pour mettre à jour le scoreboard d’un joueur spécifique
    public void setPlayerScoreboard(Player player) {
        player.setScoreboard(board);
    }

    // Exemple pour mettre à jour le nombre de kills
    public void setKills(Player player, int kills) {
        // Supprimer l’ancien score kills
        board.resetScores(ChatColor.AQUA + "Kills: 0");
        Score killsScore = objective.getScore(ChatColor.AQUA + "Kills: " + kills);
        killsScore.setScore(0);
    }
}
