package com.example.multiserverportals;

import org.bukkit.plugin.java.JavaPlugin;

public class PaperMain extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("PaperMain has been enabled!");

        // PaperMC向けの特別な設定や初期化処理があればここに記述する
    }

    @Override
    public void onDisable() {
        getLogger().info("PaperMain has been disabled!");

        // プラグインが無効になったときの後処理があればここに記述する
    }
}
