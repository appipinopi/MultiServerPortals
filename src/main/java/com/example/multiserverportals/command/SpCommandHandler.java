package com.example.multiserverportals.command;

import com.example.multiserverportals.MultiServerPortals;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class SpCommandHandler extends CommandProcessor {

    public SpCommandHandler(MultiServerPortals plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 3) {
            sender.sendMessage("Usage: /sp <server name> <i|item|x|xp|ar|armor|e|enderchest|g|go|w|whitelist> <true|false>");
            return false;
        }

        String serverName = args[0];
        String option = args[1];
        boolean enabled = Boolean.parseBoolean(args[2]);
        
        // Logic to enable/disable specific options on the server
        sender.sendMessage("Setting " + option + " on server " + serverName + " to " + enabled);

        return true;
    }
}
