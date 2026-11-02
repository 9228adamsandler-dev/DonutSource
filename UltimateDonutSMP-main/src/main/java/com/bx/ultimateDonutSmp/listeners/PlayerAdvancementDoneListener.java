package com.bx.ultimateDonutSmp.listeners;

import com.bx.ultimateDonutSmp.UltimateDonutSmp;
import com.bx.ultimateDonutSmp.models.PlayerData;
import com.bx.ultimateDonutSmp.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.world.WorldLoadEvent;

public class PlayerAdvancementDoneListener implements Listener {

    private final UltimateDonutSmp plugin;

    public PlayerAdvancementDoneListener(UltimateDonutSmp plugin) {
        this.plugin = plugin;
        disableVanillaAnnouncements();
    }

    private void disableVanillaAnnouncements() {
        for (World world : Bukkit.getWorlds()) {
            setAnnounceAdvancements(world, false);
        }
    }

    @EventHandler
    public void onWorldLoad(WorldLoadEvent event) {
        setAnnounceAdvancements(event.getWorld(), false);
    }

    @SuppressWarnings("unchecked")
    private void setAnnounceAdvancements(World world, boolean value) {
        if (world == null) {
            return;
        }
        try {
            GameRule<Boolean> rule = (GameRule<Boolean>) GameRule.getByName("announceAdvancements");
            if (rule != null) {
                world.setGameRule(rule, value);
            }
        } catch (Throwable ignored) {
        }
    }

    @EventHandler
    public void onAdvancementDone(PlayerAdvancementDoneEvent event) {
        // Achievement / advancement chat announcements disabled globally.
        // Vanilla announceAdvancements gamerule is already forced off in disableVanillaAnnouncements().
    }

    private boolean shouldReceiveAdvancement(Player receiver) {
        PlayerData receiverData = plugin.getPlayerDataManager().get(receiver);
        if (receiverData == null) {
            return true;
        }
        return receiverData.isAdvancementMessagesEnabled();
    }
}
