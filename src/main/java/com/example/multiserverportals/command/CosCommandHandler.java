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
            return false;
        }

        String ip = args[0];
        String port = args[1];
        String serverName = args[2];
        String roadName = args[3];

        // サーバー登録ロジックをここに記述
        String message = plugin.getConfig().getString("default-settings.cos-register-message")
                .replace("%server%", serverName)
                .replace("%ip%", ip)
                .replace("%port%", port)
                .replace("%road%", roadName);
        sender.sendMessage(message);
        return true;
    }
}
