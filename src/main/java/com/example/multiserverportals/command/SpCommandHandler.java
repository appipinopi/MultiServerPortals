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
            return false;
        }

        String serverName = args[0];
        String option = args[1];
        boolean enable = Boolean.parseBoolean(args[2]);

        // 転送オプションの有効/無効ロジックをここに記述
        String key = "transfer-options." + serverName + "." + option;
        plugin.getConfig().set(key, enable);
        plugin.saveConfig();

        String messageKey = enable ? "default-settings.sp-enable-message" : "default-settings.sp-disable-message";
        sender.sendMessage(plugin.getConfig().getString(messageKey)
                .replace("%option%", option)
                .replace("%from%", serverName)
                .replace("%to%", serverName));
        return true;
    }
}
