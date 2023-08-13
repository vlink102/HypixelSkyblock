package me.vlink102.hypixelskyblock.commands;

import de.tr7zw.nbtapi.NBTItem;
import me.vlink102.hypixelskyblock.HypixelSkyblock;
import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.player.SBPlayer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EnchantCommand implements CommandExecutor {
    private final HypixelSkyblock plugin;

    public EnchantCommand(HypixelSkyblock plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.isOp() && sender instanceof Player) {
            Player bukkitPlayer = (Player) sender;
            if (args.length < 2) {
                bukkitPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cPlease specify an enchantment ID and level."));
                return true;
            }
            long enchantmentID = Long.parseLong(args[0]);
            ItemStack stack = bukkitPlayer.getInventory().getItemInHand();
            if (stack == null) {
                bukkitPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cPlease hold an item to enchant it."));
                return true;
            }
            int enchantmentLevel = Integer.parseInt(args[1]);
            NBTItem nbtItem = new NBTItem(stack);
            try {
                JSONObject enchants = (JSONObject) new JSONParser().parse(nbtItem.getString("sb_enchantments"));
                enchants.put(String.valueOf(enchantmentID), enchantmentLevel);
                nbtItem.setString("sb_enchantments", enchants.toString());
                int slot = bukkitPlayer.getInventory().getHeldItemSlot();
                SBItem item = SBItem.fromNBTItem(nbtItem);
                bukkitPlayer.getInventory().setItem(slot, item.toItemStack());
                bukkitPlayer.updateInventory();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
}
