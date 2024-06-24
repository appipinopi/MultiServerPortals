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
        boolean enable = Boolean.parseBoolean(args[2]);

        Player player = plugin.getServer().getPlayer(playerName);

        if (player == null) {
            sender.sendMessage("Player not found.");
            return true;
        }

        // ホワイトリストの有効/無効ロジックをここに記述
        String key = "whitelist." + roadName + "." + playerName;
        plugin.getConfig().set(key, enable);
        plugin.saveConfig();

        String messageKey = enable ? "default-settings.whitelist-enable-message" : "default-settings.whitelist-disable-message";
        sender.sendMessage(plugin.getConfig().getString(messageKey)
                .replace("%player%", playerName)
                .replace("%road%", roadName));
        return true;
    }
}
