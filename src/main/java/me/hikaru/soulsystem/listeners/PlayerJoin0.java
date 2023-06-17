/*package me.hikaru.soulsystem.listeners;

import me.hikaru.soulsystem.SoulSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin0 implements Listener {

    public final SoulSystem plugin;

    public PlayerJoin0(SoulSystem plugin) {
        this.plugin = plugin;
    }



    @EventHandler
    public void onJoin(PlayerJoinEvent event, Player player){
        int defaultSouls = plugin.getConfig().getInt("default-souls");

        if (!player.hasPlayedBefore()){
            plugin.setSouls(player, defaultSouls);
        }


    }




}*/
