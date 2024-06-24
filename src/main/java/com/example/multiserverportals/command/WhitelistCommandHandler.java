package com.example.multiserverportals.command;

import com.example.multiserverportals.MultiServerPortals;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WhitelistCommandHandler extends CommandProcessor {

    public WhitelistCommandHandler(MultiServerPortals plugin) {
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 3) {
            return false;
        }

        String roadName = args[0];
        String playerName = args[1];
        boolean allow = Boolean.parseBoolean(args[2]);

        // ホワイトリストのロジックをここに記述
        String key = "whitelist." + roadName + "." + playerName;
        plugin.getConfig().set(key, allow);
        plugin.saveConfig();

        String messageKey = allow ? "default-settings.whitelist-add-message" : "default-settings.whitelist-remove-message";
        sender.sendMessage(plugin.getConfig().getString(messageKey)
                .replace("%road%", roadName)
                .replace("%player%", playerName));
        return true;
    }
}
