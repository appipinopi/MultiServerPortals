package com.example.multiserverportals;

import org.bukkit.plugin.java.JavaPlugin;
import com.example.multiserverportals.command.CosCommandHandler;
import com.example.multiserverportals.command.MoveCommandHandler;
import com.example.multiserverportals.command.SpCommandHandler;
import com.example.multiserverportals.command.WhitelistCommandHandler;

public class PaperMain extends JavaPlugin {

    @Override
    public void onEnable() {
        // プラグイン起動ロジック
        saveDefaultConfig(); // config.ymlが存在しない場合はロードする
        getLogger().info("MultiServerPortals for PaperMC has been enabled.");
        getCommand("move").setExecutor(new MoveCommandHandler(this));
        getCommand("sp").setExecutor(new SpCommandHandler(this));
        getCommand("cos").setExecutor(new CosCommandHandler(this));
        getCommand("wh").setExecutor(new WhitelistCommandHandler(this));
        getCommand("whitelist").setExecutor(new WhitelistCommandHandler(this));
        getCommand("savarproperties").setExecutor(new SpCommandHandler(this)); // /spのエイリアス
        getCommand("connectingservers").setExecutor(new CosCommandHandler(this)); // /cosのエイリアス
    }

    @Override
    public void onDisable() {
        // プラグイン停止ロジック
        getLogger().info("MultiServerPortals for PaperMC has been disabled.");
    }
}

