package com.example.multiserverportals;

import org.bukkit.plugin.java.JavaPlugin;
import com.example.multiserverportals.command.CosCommandHandler;
import com.example.multiserverportals.command.MoveCommandHandler;
import com.example.multiserverportals.command.SpCommandHandler;
import com.example.multiserverportals.command.WhitelistCommandHandler;

public class PaperMain extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig(); // Load config.yml if it doesn't exist
        getLogger().info("MultiServerPortals for PaperMC has been enabled.");
        getCommand("move").setExecutor(new MoveCommandHandler(this));
        getCommand("sp").setExecutor(new SpCommandHandler(this));
        getCommand("cos").setExecutor(new CosCommandHandler(this));
        getCommand("wh").setExecutor(new WhitelistCommandHandler(this));
        getCommand("whitelist").setExecutor(new WhitelistCommandHandler(this));
        getCommand("savarproperties").setExecutor(new SpCommandHandler(this)); // Alias for /sp
        getCommand("connectingservers").setExecutor(new CosCommandHandler(this)); // Alias for /cos
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("MultiServerPortals for PaperMC has been disabled.");
    }
}
