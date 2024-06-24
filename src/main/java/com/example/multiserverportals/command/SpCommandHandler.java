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
        if (args.length < 3) {
            return false;
        }

        String ipAddress = args[0];
        int port = Integer.parseInt(args[1]);
        String serverName = args[2];

        // 新しいサーバーを登録するロジックをここに記述
        sender.sendMessage(plugin.getConfig().getString("default-settings.cos-register-message")
                .replace("%ip%", ipAddress)
                .replace("%port%", String.valueOf(port))
                .replace("%server%", serverName));
        return true;
    }
}
