package com.example.multiserverportals.command;

import com.example.multiserverportals.MultiServerPortals;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MoveCommandHandler implements CommandExecutor {
    private final MultiServerPortals plugin;

    public MoveCommandHandler(MultiServerPortals plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be run by a player.");
            return true;
        }

        if (args.length < 2) {
            return false;
        }

        String serverName = args[0];
        String playerName = args[1];

        // プレイヤーを指定されたサーバーに移動するロジックをここに記述
        sender.sendMessage(plugin.getConfig().getString("default-settings.move-message")
                .replace("%player%", playerName)
                .replace("%server%", serverName));
        return true;
    }
}
