package me.vlink102.hypixelskyblock.player;

import de.Herbystar.TTA.TTA_Methods;
import me.vlink102.hypixelskyblock.HypixelSkyblock;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.StringJoiner;
import java.util.UUID;

public class SBPlayerManager implements Listener {
    private final HashMap<UUID, SBPlayer> PLAYER_MAP;

    public SBPlayerManager(HypixelSkyblock plugin) {
        this.PLAYER_MAP = new HashMap<>();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, this::updatePlayers, 0, 1);
    }

    public void updatePlayers() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (PLAYER_MAP.containsKey(player.getUniqueId())) {
                updatePlayer(PLAYER_MAP.get(player.getUniqueId()));
            } else {
                System.out.println("Tried to update unregistered player: " + player.getUniqueId());
            }
        }
    }

    public HashMap<UUID, SBPlayer> getPlayerMap() {
        return PLAYER_MAP;
    }

    public void addPlayer(Player player) {
        if (PLAYER_MAP.containsKey(player.getUniqueId())) {
            System.out.println("Already registered player: " + player.getUniqueId());
            return;
        }
        PLAYER_MAP.put(player.getUniqueId(), new SBPlayer(player));
    }

    public void resetPlayer(Player player) {
        PLAYER_MAP.put(player.getUniqueId(), new SBPlayer(player));
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!PLAYER_MAP.containsKey(player.getUniqueId())) {
            PLAYER_MAP.put(player.getUniqueId(), new SBPlayer(player));
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&aWelcome! &b" + player.getName() + "&e to Lowpixel Groundblock"));
        }
    }

    public double calculateEffectiveHealth(SBPlayer player) {
        return player.getHealth().getValue() * (player.getDefense().getValue() / 100 + 1);
    }

    public double calculateFinalAbilityDamage(SBPlayer player) {
        double baseAbilityDamage = 0; // TODO
        double intelligence = player.getIntelligence().getValue();
        double abilityScaling = 0; // TODO
        double abilityDamageStat = player.getAbilityDamage().getValue();
        return 0; // TODO
    }

    public double calculateHalfHearts(SBPlayer player) {
        double playerHealth = player.getMaxHealth().getValue();
        if (playerHealth < 125) {
            return 10;
        }
        if (playerHealth < 165) {
            return 11;
        }
        if (playerHealth < 230) {
            return 12;
        }
        if (playerHealth < 300) {
            return 13;
        }
        if (playerHealth < 400) {
            return 14;
        }
        if (playerHealth < 650) {
            return 16;
        }
        if (playerHealth < 800) {
            return 17;
        }
        if (playerHealth < 1000) {
            return 18;
        }
        if (playerHealth < 1250) {
            return 19;
        }
        return 20;
    }

    public void sendActionBar(SBPlayer player, String text) {
        TTA_Methods.sendActionBar(player.getPlayerBind(), ChatColor.translateAlternateColorCodes('&', text));
    }

    public void manageActionBar(SBPlayer player) {
        StringJoiner actionBarContent = new StringJoiner("      ");
        actionBarContent.add("&c" + player.getHealth().getRoundedValue() + "/" + player.getMaxHealth().getRoundedValue() + "❤");
        if (player.getDefense().getValue() != 0) {
            actionBarContent.add("&a" + player.getDefense().getRoundedValue() + "❈ Defense");
            // TODO Location change
        }
        actionBarContent.add("&b" + player.getMana().getRoundedValue() + "/" + player.getIntelligence().getRoundedValue() + "✎ Mana");
        sendActionBar(player, actionBarContent.toString());
    }

    public void updatePlayer(SBPlayer player) {
        manageActionBar(player);
    }
}
