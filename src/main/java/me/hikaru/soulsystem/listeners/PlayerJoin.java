package me.hikaru.soulsystem.listeners;

import me.hikaru.soulsystem.SoulSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    public final SoulSystem plugin;
    public PlayerJoin(SoulSystem plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        int defaultSouls = plugin.getConfig().getInt("default-souls");
        String firstJoin = plugin.getLang(player, "first-join");

        if (!player.hasPlayedBefore()){
            plugin.setSouls(player, defaultSouls);
            player.sendMessage(firstJoin);
        }




    }



}
