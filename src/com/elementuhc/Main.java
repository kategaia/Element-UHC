package com.elementuhc;

import org.bukkit.plugin.java.JavaPlugin;
import com.elementuhc.mode.FFA;
import com.elementuhc.mode.To2;
import com.elementuhc.mode.Strategique;

public class Main extends JavaPlugin{

    private RoleManager roleManager;

    private KillRewardManager killRewardManager;

    @Override
    public void onEnable(){

        roleManager = new RoleManager();

        killRewardManager = new KillRewardManager(roleManager);

        Mdjselect mdjselect = new Mdjselect(this);

        getServer().getPluginManager().registerEvents(new Mdjselect(this), this);

        getCommand("start").setExecutor(new CmdStart(this));
        getCommand("mdj").setExecutor(new CmdMdj(mdjselect));

        getLogger().info("Plugin Element UHC Activé !");
    }

    @Override
    public void onDisable(){
        getLogger().info("Plugin Element UHC Désactivé !");
    }


    public void loadFFA() {
        getServer().getPluginManager().registerEvents(new FFA(roleManager, killRewardManager), this);
        getLogger().info("Mode FFA chargé !");
    }

    public void loadTo2() {
        getServer().getPluginManager().registerEvents(new To2(roleManager), this);
        getLogger().info("Mode To2 chargé !");
    }

    public void loadStrategique() {
        getServer().getPluginManager().registerEvents(new Strategique(roleManager), this);
        getLogger().info("Mode Stratégique chargé !");
    }

    public RoleManager getRoleManager(){
        return roleManager;
    }

    public enum GameModeType{
        NONE,
        FFA,
        TO2,
        STRATEGIQUE
    }

    private GameModeType currentMode = GameModeType.NONE;

    public void setCurrentMode(GameModeType mode) {
        this.currentMode = mode;
    }

    public GameModeType getCurrentMode() {
        return  this.currentMode;
    }




}
