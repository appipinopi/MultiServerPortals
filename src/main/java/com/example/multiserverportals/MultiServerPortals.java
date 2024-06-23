package com.example.multiserverportals;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MultiServerPortals extends JavaPlugin implements CommandExecutor {

    private static MultiServerPortals instance;

    public static MultiServerPortals getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("MultiServerPortals has been enabled.");

        // コマンドの登録
        getCommand("move").setExecutor(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("MultiServerPortals has been disabled.");
        // クリーンアップや後片付けが必要な場合はここで行う
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can execute this command.");
            return true;
        }

        Player player = (Player) sender;

        // /move コマンドの処理
        if (command.getName().equalsIgnoreCase("move")) {
            if (args.length < 1) {
                player.sendMessage("Usage: /move <server name>");
                return true;
            }

            String serverName = args[0];

            // プレイヤーを指定されたサーバーに移動する
            movePlayerToServer(player, serverName);

            player.sendMessage("You are being moved to server: " + serverName);
            return true;
        }

        return false;
    }

    private void movePlayerToServer(Player player, String serverName) {
        // BungeeCordを使用してプレイヤーを他のサーバーに移動する
        // BungeeCordでは、プレイヤーを別のサーバーに移動させるためにプラグインメッセージを使用する
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(serverName);

        player.sendPluginMessage(this, "BungeeCord", out.toByteArray());
    }
}
