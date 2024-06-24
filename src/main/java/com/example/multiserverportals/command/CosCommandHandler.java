package com.example.multiserverportals.command;

import com.example.multiserverportals.MultiServerPortals;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CosCommandHandler extends CommandProcessor {

    public CosCommandHandler(MultiServerPortals plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 4) {
            sender.sendMessage("Usage: /cos <IP address> <port> <server name> <road name>");
            return false;
        }

        String ipAddress = args[0];
        String port = args[1];
        String serverName = args[2];
        String roadName = args[3];

        // Logic to register the new server
        sender.sendMessage("Registering server " + serverName + " with IP " + ipAddress + ":" + port + " and road name " + roadName);

        return true;
    }
}
