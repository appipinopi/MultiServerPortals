package com.example.multiserverportals;

import org.bukkit.plugin.java.JavaPlugin;
import com.example.multiserverportals.command.CosCommandHandler;
import com.example.multiserverportals.command.MoveCommandHandler;
import com.example.multiserverportals.command.SpCommandHandler;

public class SpigotMain extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic specific to Spigot
        saveDefaultConfig(); // Load config.yml if it doesn't exist
        getLogger().info("MultiServerPortals for Spigot has been enabled.");
        getCommand("move").setExecutor(new MoveCommandHandler(this));
        getCommand("sp").setExecutor(new SpCommandHandler(this));
        getCommand("cos").setExecutor(new CosCommandHandler(this));
        getCommand("savarproperties").setExecutor(new SpCommandHandler(this)); // Alias for /sp
        getCommand("connectingservers").setExecutor(new CosCommandHandler(this)); // Alias for /cos
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic specific to Spigot
        getLogger().info("MultiServerPortals for Spigot has been disabled.");
    }
}
