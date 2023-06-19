package me.vlink102.hypixelskyblock.listeners;

import me.vlink102.hypixelskyblock.HypixelSkyblock;
import me.vlink102.hypixelskyblock.player.SBPlayer;
import me.vlink102.hypixelskyblock.player.SBPlayerManager;
import me.vlink102.hypixelskyblock.util.SBUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.HashMap;
import java.util.UUID;

public class Damage implements Listener {
    private final HypixelSkyblock plugin;

    public Damage(HypixelSkyblock plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player bukkitPlayer = (Player) event.getEntity();

        SBPlayerManager playerManager = plugin.getPlayerUtils();
        HashMap<UUID, SBPlayer> playerMap = playerManager.getPlayerMap();
        if (!playerMap.containsKey(bukkitPlayer.getUniqueId())) return;
        double damage = event.getDamage();
        event.setDamage(0);

        SBPlayer player = playerMap.get(bukkitPlayer.getUniqueId());

        if (event instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent entityEvent = (EntityDamageByEntityEvent) event;


        } else {
            switch (event.getCause()) {
                case CONTACT: // Cactus
                    playerManager.damagePlayer(player, new SBUtils.Damage(SBUtils.DamageType.NORMAL, damage * 5));
                    break;
                case ENTITY_ATTACK:
                    break;
                case PROJECTILE:
                    break;
                case SUFFOCATION:
                    break;
                case FALL:
                    break;
                case FIRE:
                    break;
                case FIRE_TICK:
                    break;
                case MELTING:
                    break;
                case LAVA:
                    break;
                case DROWNING:
                    break;
                case BLOCK_EXPLOSION:
                    break;
                case ENTITY_EXPLOSION:
                    break;
                case VOID:
                    break;
                case LIGHTNING:
                    break;
                case SUICIDE:
                    break;
                case STARVATION:
                    break;
                case POISON:
                    break;
                case MAGIC:
                    break;
                case WITHER:
                    break;
                case FALLING_BLOCK:
                    break;
                case THORNS:
                    break;
                case CUSTOM:
                    break;
            }
        }
    }
}
