package com.example.multiserverportals;

import org.bukkit.plugin.java.JavaPlugin;

public class PaperMain extends JavaPlugin {

    private static PaperMain instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("MultiServerPortals for PaperMC has been enabled.");

        // Register command handlers
        getCommand("move").setExecutor(new MoveCommandHandler(this));
        getCommand("sp").setExecutor(new SpCommandHandler(this));
        getCommand("cos").setExecutor(new CosCommandHandler(this));

        // Any additional setup or initialization
        // Example: register event listeners
        // getServer().getPluginManager().registerEvents(new MyListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("MultiServerPortals for PaperMC has been disabled.");
    }

    public static PaperMain getInstance() {
        return instance;
    }
}
