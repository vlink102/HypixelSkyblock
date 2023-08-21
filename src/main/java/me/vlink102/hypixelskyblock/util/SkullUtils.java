package me.vlink102.hypixelskyblock.util;/*
 * Copyright (c) 2023. JEFF Media GbR / mfnalex et al.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.lang.reflect.Field;
import java.util.UUID;
import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;
import org.bukkit.block.Skull;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Skull / Player head related methods
 */
@UtilityClass
public class SkullUtils {

    /**
     * Sets the texture of a placed head to the skin of the given UUID
     *
     * @throws IllegalArgumentException when the block is not a head
    public static void setHeadTexture(@NotNull final Block block, @NotNull final UUID uuid) {
        checkIfIsSkull(block);
        final OfflinePlayer player = Bukkit.getOfflinePlayer(uuid);
        setHeadTexture(block, player);
    }
     */

    private static void checkIfIsSkull(@NotNull final Block block) throws IllegalArgumentException {
        if (!(block.getState() instanceof Skull)) {
            throw new IllegalArgumentException("BlockState is not a Skull but " + block.getState().getClass().getSimpleName());
        }
    }

    /**
     * Sets the texture of a placed head to the skin of the given OfflinePlayer
     *
     * @throws IllegalArgumentException when the block is not a skullx
    public static void setHeadTexture(@NotNull final Block block, @NotNull final OfflinePlayer player) {
        checkIfIsSkull(block);
        final Skull state = (Skull) block.getState();
        state.setOwningPlayer(player);
        state.update();
    }
    */

    /**
     * @throws IllegalArgumentException when the block is not a skull
     * @nms
     * @deprecated see {@link #setHeadTexture(Block, String)}
    @Deprecated
    public static void setBase64Texture(@NotNull final Block block, @NotNull final String base64) {
        setHeadTexture(block, base64);
    }
     */

    /**
     * Sets the texture of a placed head to the given base64 skin
     *
     * @throws IllegalArgumentException when the block is not a skull
     * @nms
    public static void setHeadTexture(@NotNull final Block block, @NotNull final String base64) {
        final GameProfile profile = new GameProfile(UUID.randomUUID(), "");
        profile.getProperties().put("textures", new Property("textures", base64));
        setHeadTexture(block, profile);
    }
     */

    /**
     * Sets the texture of a placed head to the skin of the given GameProfile
     *
     * @throws IllegalArgumentException when the block is not a skull
     * @nms
    public static void setHeadTexture(@NotNull final Block block, @NotNull final GameProfile gameProfile) {
        checkIfIsSkull(block);
        JeffLib.getNMSHandler().setHeadTexture(block, gameProfile);
    }
     */

    /**
     * Gets a head with the skin of the given UUID
    public static ItemStack getHead(@NotNull final UUID uuid) {
        final OfflinePlayer player = Bukkit.getOfflinePlayer(uuid);
        return getHead(player);
    }
     */

    /**
     * Gets a head with the skin of the given OfflinePlayer
    public static ItemStack getHead(@NotNull final OfflinePlayer player) {
        final ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        final SkullMeta meta = (SkullMeta) head.getItemMeta();
        assert meta != null;
        meta.setOwningPlayer(player);
        head.setItemMeta(meta);
        return head;
    }
     */

    /**
     * Gets a head with the given base64 skin
     */
    public static ItemStack getHead(@NotNull final String base64) {
        final ItemStack head = new ItemStack(Material.SKULL_ITEM);
        @SuppressWarnings("TypeMayBeWeakened") final SkullMeta meta = (SkullMeta) head.getItemMeta();
        final GameProfile gameProfile = new GameProfile(UUID.randomUUID(), "");
        gameProfile.getProperties().put("textures", new Property("textures", base64));
        final Field profileField;
        assert meta != null;
        try {
            profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, gameProfile);
            head.setItemMeta(meta);
        } catch (final NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return head;
    }

    /**
     * Gets the base64 skin of the given SkullMeta
     */
    @Nullable
    public static String getBase64Texture(@NotNull final SkullMeta skullMeta) {
        try {
            final Field profileField = skullMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            final GameProfile profile = (GameProfile) profileField.get(skullMeta);
            return profile.getProperties().get("textures").stream().findFirst().get().getValue();
        } catch (final Throwable t) {
            return null;
        }
    }

}