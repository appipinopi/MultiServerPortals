package com.example.multiserverportals;

import org.bukkit.plugin.java.JavaPlugin;

public class SpigotMain extends JavaPlugin {

    private static SpigotMain instance;

    @Override
    public void onEnable() {
        instance = this;

        // Register commands
        getCommand("move").setExecutor(new MoveCommandHandler(instance));
        getCommand("sp").setExecutor(new SpCommandHandler(instance));
        getCommand("cos").setExecutor(new CosCommandHandler(instance));

        // Plugin startup logic
        getLogger().info("MultiServerPortals has been enabled.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("MultiServerPortals has been disabled.");
    }

    public static SpigotMain getInstance() {
        return instance;
    }
}
