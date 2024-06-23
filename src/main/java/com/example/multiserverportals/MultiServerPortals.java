package com.example.multiserverportals;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MultiServerPortals extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        // プラグインの有効化時の処理
        getLogger().info("MultiServerPortals has been enabled.");
        // コマンドの登録
        getCommand("move").setExecutor(this);
        getCommand("sp").setExecutor(this);
        getCommand("cos").setExecutor(this);
    }

    @Override
    public void onDisable() {
        // プラグインの無効化時の処理
        getLogger().info("MultiServerPortals has been disabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // コマンド実行時の処理
        if (command.getName().equalsIgnoreCase("move")) {
            return handleMoveCommand(sender, args);
        } else if (command.getName().equalsIgnoreCase("sp")) {
            return handleSpCommand(sender, args);
        } else if (command.getName().equalsIgnoreCase("cos")) {
            return handleCosCommand(sender, args);
        }
        return false;
    }

    private boolean handleMoveCommand(CommandSender sender, String[] args) {
        // /move コマンドの処理
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can execute this command.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length < 1) {
            player.sendMessage("Usage: /move <server name>");
            return true;
        }

        String serverName = args[0];

        // プレイヤーを指定したサーバーに移動する処理を実装する

        return true;
    }

    private boolean handleSpCommand(CommandSender sender, String[] args) {
        // /sp コマンドの処理
        // サーバー名、オプション、値を取得して設定を変更する処理を実装する
        return true;
    }

    private boolean handleCosCommand(CommandSender sender, String[] args) {
        // /cos コマンドの処理
        // 新しいサーバーを登録する処理を実装する
        return true;
    }
}
