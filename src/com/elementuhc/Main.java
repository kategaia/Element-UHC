package com.elementuhc;

import org.bukkit.plugin.java.JavaPlugin;
import com.elementuhc.mode.FFA;
import com.elementuhc.mode.To2;
import com.elementuhc.mode.Strategique;

public class Main extends JavaPlugin{

    private RoleManager roleManager;

    @Override
    public void onEnable(){

        roleManager = new RoleManager();

        getServer().getPluginManager().registerEvents(new Mdjselect(this), this);

        getLogger().info("Plugin Element UHC Activé !");
    }

    @Override
    public void onDisable(){
        getLogger().info("Plugin Element UHC Désactivé !");
    }


    public void loadFFA() {
        getServer().getPluginManager().registerEvents(new FFA(roleManager), this);
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




}
