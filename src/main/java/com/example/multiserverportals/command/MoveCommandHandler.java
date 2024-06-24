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
            sender.sendMessage("Usage: /move <server name> <username>");
            return false;
        }

        String serverName = args[0];
        String playerName = args[1];
        
        Player player = plugin.getServer().getPlayer(playerName);
        if (player != null) {
            // Move player to the specified server logic
            // This requires integration with BungeeCord
            sender.sendMessage("Moving player " + playerName + " to server " + serverName);
        } else {
            sender.sendMessage("Player " + playerName + " not found.");
        }

        return true;
    }
}
