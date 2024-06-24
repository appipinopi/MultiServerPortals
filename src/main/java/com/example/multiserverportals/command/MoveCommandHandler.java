package com.example.multiserverportals.command;

import com.example.multiserverportals.MultiServerPortals;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MoveCommandHandler extends CommandProcessor {

    public MoveCommandHandler(MultiServerPortals plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2) {
            return false;
        }

        String serverName = args[0];
        String playerName = args[1];
        Player player = plugin.getServer().getPlayer(playerName);

        if (player == null) {
            sender.sendMessage("Player not found.");
            return true;
        }

        // プレイヤー移動ロジックをここに記述
        String message = plugin.getConfig().getString("default-settings.move-message")
                .replace("%server%", serverName)
                .replace("%player%", playerName);
        sender.sendMessage(message);
        return true;
    }
}
