package com.example.multiserverportals.command;

import com.example.multiserverportals.MultiServerPortals;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public abstract class CommandProcessor implements CommandExecutor {
    protected MultiServerPortals plugin;

    public CommandProcessor(MultiServerPortals plugin) {
        this.plugin = plugin;
    }

    @Override
    public abstract boolean onCommand(CommandSender sender, Command command, String label, String[] args);
}
