package me.vlink102.hypixelskyblock;

import javafx.scene.effect.Glow;
import lombok.Getter;
import mc.obliviate.inventory.InventoryAPI;
import me.vlink102.hypixelskyblock.commands.EnchantCommand;
import me.vlink102.hypixelskyblock.commands.GetItem;
import me.vlink102.hypixelskyblock.enchantments.*;
import me.vlink102.hypixelskyblock.enchantments.boots.DepthStrider;
import me.vlink102.hypixelskyblock.enchantments.boots.FeatherFalling;
import me.vlink102.hypixelskyblock.enchantments.boots.FrostWalker;
import me.vlink102.hypixelskyblock.enchantments.boots.SugarRush;
import me.vlink102.hypixelskyblock.enchantments.bow.*;
import me.vlink102.hypixelskyblock.enchantments.chestplate.CounterStrike;
import me.vlink102.hypixelskyblock.enchantments.chestplate.Reflection;
import me.vlink102.hypixelskyblock.enchantments.chestplate.TrueProtection;
import me.vlink102.hypixelskyblock.enchantments.equipment.Cayenne;
import me.vlink102.hypixelskyblock.enchantments.equipment.GreenThumb;
import me.vlink102.hypixelskyblock.enchantments.equipment.Prosperity;
import me.vlink102.hypixelskyblock.enchantments.fishing.*;
import me.vlink102.hypixelskyblock.enchantments.helmet.AquaAffinity;
import me.vlink102.hypixelskyblock.enchantments.helmet.BigBrain;
import me.vlink102.hypixelskyblock.enchantments.helmet.Hecatomb;
import me.vlink102.hypixelskyblock.enchantments.helmet.Transylvanian;
import me.vlink102.hypixelskyblock.enchantments.leggings.SmartyPants;
import me.vlink102.hypixelskyblock.enchantments.necklace.Quantum;
import me.vlink102.hypixelskyblock.enchantments.sword.*;
import me.vlink102.hypixelskyblock.enchantments.tools.*;
import me.vlink102.hypixelskyblock.enchantments.tools.turbo.*;
import me.vlink102.hypixelskyblock.enchantments.ultimate.*;
import me.vlink102.hypixelskyblock.gui.Anvil;
import me.vlink102.hypixelskyblock.items.Recombobulator;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.items.bookmodifiers.books.*;
import me.vlink102.hypixelskyblock.listeners.Damage;
import me.vlink102.hypixelskyblock.listeners.ItemDrop;
import me.vlink102.hypixelskyblock.player.SBPlayer;
import me.vlink102.hypixelskyblock.player.SBPlayerManager;
import me.vlink102.hypixelskyblock.util.EnchantGlint;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import javax.sound.midi.Receiver;
import java.lang.reflect.Field;
import java.util.HashMap;

public final class HypixelSkyblock extends JavaPlugin implements CommandExecutor {

    @Getter private SBPlayerManager playerUtils;
    @Getter private static final HashMap<Long, SBEnchantment> ENCHANTMENTS = new HashMap<>();
    @Getter private static final HashMap<String, SBItem> ITEMS = new HashMap<>();

    @Override
    public void onEnable() {
        System.out.println("Loading Lowpixel Groundblock...");
        this.playerUtils = new SBPlayerManager(this);
        registerGlow();
        Bukkit.getServer().getPluginManager().registerEvents(new Damage(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(playerUtils, this);
        Bukkit.getServer().getPluginManager().registerEvents(new ItemDrop(this), this);
        Bukkit.getServer().getPluginCommand("sbenchant").setExecutor(new EnchantCommand(this));
        Bukkit.getServer().getPluginCommand("sbget").setExecutor(new GetItem());
        registerEnchantments();
        registerItems();
        new InventoryAPI(this).init();
        Bukkit.getServer().getPluginCommand("sb").setExecutor(this);
        for (Player player : Bukkit.getOnlinePlayers()) {
            playerUtils.addPlayer(player);
        }
        System.out.println("Plugin Successfully Enabled!");
    }

    public void registerItems() {
        new ArtOfPeace().registerItem();
        new ArtOfWar().registerItem();
        new FumingPotato().registerItem();
        new HotPotato().registerItem();
        new JalapenoBook().registerItem();
        new Recombobulator().registerItem();
    }

    public void registerEnchantments() {
        new DepthStrider(0);
        new FeatherFalling(0);
        new FrostWalker(0);
        new SugarRush(0);
        new Chance(0);
        new DragonTracer(0);
        new Flame(0);
        new InfiniteQuiver(0);
        new Overload(0);
        new Piercing(0);
        new Power(0);
        new Punch(0);
        new Snipe(0);
        new CounterStrike(0);
        new Reflection(0);
        new TrueProtection(0);
        new Cayenne(0);
        new GreenThumb(0);
        new Prosperity(0);
        new Angler(0);
        new Blessing(0);
        new Caster(0);
        new Charm(0);
        new Corruption(0);
        new Expertise(0);
        new Frail(0);
        new LuckOfTheSea(0);
        new Lure(0);
        new Magnet(0);
        new Piscary(0);
        new SpikedHook(0);
        new AquaAffinity(0);
        new BigBrain(0);
        new Hecatomb(0);
        new Transylvanian(0);
        new SmartyPants(0);
        new Quantum(0);
        new BaneOfArthropods(0);
        new Champion(0);
        new Cleave(0);
        new Critical(0);
        new EnderSlayer(0);
        new Execute(0);
        new FireAspect(0);
        new FirstStrike(0);
        new GiantKiller(0);
        new Knockback(0);
        new Lethality(0);
        new LifeSteal(0);
        new Luck(0);
        new ManaSteal(0);
        new Prosecute(0);
        new Scavenger(0);
        new Sharpness(0);
        new Smite(0);
        new Syphon(0);
        new ThunderBolt(0);
        new ThunderLord(0);
        new TitanKiller(0);
        new TripleStrike(0);
        new Vampirism(0);
        new Venomous(0);
        new TurboCacti(0);
        new TurboCane(0);
        new TurboCarrot(0);
        new TurboCocoa(0);
        new TurboMelon(0);
        new TurboMushroom(0);
        new TurboPotato(0);
        new TurboPumpkin(0);
        new TurboWart(0);
        new TurboWheat(0);
        new Compact(0);
        new Cultivating(0);
        new Delicate(0);
        new Efficiency(0);
        new Fortune(0);
        new Harvesting(0);
        new Pristine(0);
        new Rainbow(0);
        new Replenish(0);
        new SilkTouch(0);
        new SmeltingTouch(0);
        new Sunder(0);
        new Bank(0);
        new BobbinTime(0);
        new Chimera(0);
        new Combo(0);
        new Duplex(0);
        new FatalTempo(0);
        new Flash(0);
        new HabaneroTactics(0);
        new Inferno(0);
        new LastStand(0);
        new Legion(0);
        new NoPainNoGain(0);
        new OneForAll(0);
        new Rend(0);
        new SoulEater(0);
        new Swarm(0);
        new TheOne(0);
        new UltimateJerry(0);
        new UltimateWise(0);
        new Wisdom(0);
        new BlastProtection(0);
        new Cubism(0);
        new DivineGift(0);
        new DragonHunter(0);
        new Experience(0);
        new FerociousMana(0);
        new FireProtection(0);
        new Growth(0);
        new HardenedMana(0);
        new Impaling(0);
        new Looting(0);
        new ManaVampire(0);
        new ProjectileProtection(0);
        new Protection(0);
        new Rejuvenate(0);
        new Respiration(0);
        new Respite(0);
        new Smoldering(0);
        new StrongMana(0);
        new Tabasco(0);
        new Thorns(0);
        new Vicious(0);
    }

    public void registerGlow() {
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            EnchantGlint glow = new EnchantGlint(70);
            Enchantment.registerEnchantment(glow);
        }
        catch (IllegalArgumentException ignored){
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            SBPlayer player = playerUtils.getByUUID(((Player) sender).getUniqueId());
            if (args.length == 0) {
                new Anvil(player).open();
            }
            return true;
        }
        return false;
    }
}
