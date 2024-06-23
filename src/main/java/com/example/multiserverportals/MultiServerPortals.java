package com.example.multiserverportals;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MultiServerPortals extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        // プラグインが有効になったときの処理
        getLogger().info("MultiServerPortals has been enabled!");
        
        // コマンドの登録
        getCommand("move").setExecutor(this);
        getCommand("sp").setExecutor(this);
        getCommand("savarproperties").setExecutor(this);
        getCommand("cos").setExecutor(this);
        getCommand("connectingservers").setExecutor(this);
    }

    @Override
    public void onDisable() {
        // プラグインが無効になったときの処理
        getLogger().info("MultiServerPortals has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("このコマンドはプレイヤーのみ実行可能です。");
            return true;
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("move")) {
            if (args.length < 2) {
                player.sendMessage("Usage: /move <server name> <username>");
                return true;
            }
            String serverName = args[0];
            String username = args[1];

            // TODO: 指定されたサーバーにプレイヤーを移動する処理を実装する

            player.sendMessage("プレイヤーを " + serverName + " に移動しました。");
            return true;
        }

        if (command.getName().equalsIgnoreCase("sp") || command.getName().equalsIgnoreCase("savarproperties")) {
            if (args.length < 3) {
                player.sendMessage("Usage: /sp <server name> <i|item|x|xp|ar|armor|e|enderchest|g|go> <true|false>");
                return true;
            }
            String serverName = args[0];
            String option = args[1];
            boolean enable = Boolean.parseBoolean(args[2]);

            // TODO: 特定のサーバーのアイテム、XP、防具、エンダーチェストの内容の転送を有効または無効にする処理を実装する

            player.sendMessage("サーバー " + serverName + " の " + option + " を " + (enable ? "有効" : "無効") + " にしました。");
            return true;
        }

        if (command.getName().equalsIgnoreCase("cos") || command.getName().equalsIgnoreCase("connectingservers")) {
            if (args.length < 3) {
                player.sendMessage("Usage: /cos <IP address> <port> <server name>");
                return true;
            }
            String ipAddress = args[0];
            int port = Integer.parseInt(args[1]);
            String serverName = args[2];

            // TODO: 新しいサーバーを登録する処理を実装する

            player.sendMessage("新しいサーバー " + serverName + " を登録しました。");
            return true;
        }

        return false;
    }
}
