package me.vlink102.hypixelskyblock.commands;

import me.vlink102.hypixelskyblock.HypixelSkyblock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetItem implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.isOp() && sender instanceof Player) {
            Player bukkitPlayer = (Player) sender;

            if (args.length == 1) {
                bukkitPlayer.getInventory().addItem(HypixelSkyblock.getITEMS().get(args[0]).toItemStack());
                return true;
            }
        }
        return true;
    }
}
