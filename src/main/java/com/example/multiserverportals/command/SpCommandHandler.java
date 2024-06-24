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
        if (args.length < 4) {
            return false;
        }

        String serverNameFrom = args[0];
        String serverNameTo = args[1];
        String option = args[2];
        boolean enable = Boolean.parseBoolean(args[3]);

        // 特定のサーバーのオプションの転送を有効または無効にするロジックをここに記述
        String messageKey = enable ? "default-settings.sp-enable-message" : "default-settings.sp-disable-message";
        sender.sendMessage(plugin.getConfig().getString(messageKey)
                .replace("%from%", serverNameFrom)
                .replace("%to%", serverNameTo)
                .replace("%option%", option));
        return true;
    }
}
