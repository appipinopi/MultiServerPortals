package com.example.multiserverportals;

import org.bukkit.plugin.java.JavaPlugin;

public class SpigotMain extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("SpigotMain has been enabled!");

        // Spigot向けの特別な設定や初期化処理があればここに記述する
    }

    @Override
    public void onDisable() {
        getLogger().info("SpigotMain has been disabled!");

        // プラグインが無効になったときの後処理があればここに記述する
    }
}
