package com.elementuhc;

import org.bukkit.plugin.java.JavaPlugin;
import com.elementuhc.mode.FFA;
import com.elementuhc.mode.To2;
import com.elementuhc.mode.Strategique;

public class Main extends JavaPlugin{
    @Override
    public void onEnable(){

        getServer().getPluginManager().registerEvents(new Mdjselect(this), this);

        getLogger().info("Plugin Element UHC Activé !");
    }

    @Override
    public void onDisable(){
        getLogger().info("Plugin Element UHC Activé !");
    }


    public void loadFFA() {
        getServer().getPluginManager().registerEvents(new FFA(), this);
        getLogger().info("Mode FFA chargé !");
    }

    public void loadTo2() {
        getServer().getPluginManager().registerEvents(new To2(), this);
        getLogger().info("Mode To2 chargé !");
    }

    public void loadStrategique() {
        getServer().getPluginManager().registerEvents(new Strategique(), this);
        getLogger().info("Mode Stratégique chargé !");
    }




}
