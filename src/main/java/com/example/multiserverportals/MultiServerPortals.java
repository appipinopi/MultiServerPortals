package com.example.multiserverportals;

import com.example.multiserverportals.command.CosCommandHandler;
import com.example.multiserverportals.command.MoveCommandHandler;
import com.example.multiserverportals.command.SpCommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class MultiServerPortals extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("MultiServerPortals has been enabled.");
        getCommand("move").setExecutor(new MoveCommandHandler(this));
        getCommand("sp").setExecutor(new SpCommandHandler(this));
        getCommand("savarproperties").setExecutor(new SpCommandHandler(this));
        getCommand("cos").setExecutor(new CosCommandHandler(this));
        getCommand("connectingservers").setExecutor(new CosCommandHandler(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("MultiServerPortals has been disabled.");
    }
}
