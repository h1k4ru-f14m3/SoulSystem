package me.hikaru.soulsystem.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import me.hikaru.soulsystem.SoulSystem;
import net.Indyuce.mmoitems.MMOItems;
import net.Indyuce.mmoitems.MMOUtils;
import net.Indyuce.mmoitems.api.MMOItemsAPI;
import net.Indyuce.mmoitems.api.Type;
import net.Indyuce.mmoitems.api.item.mmoitem.MMOItem;
import net.Indyuce.mmoitems.manager.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.EventListener;

public class PlayerKill implements Listener {

    public final SoulSystem plugin;
    public PlayerKill(SoulSystem plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerKill(PlayerDeathEvent event){


        Player killer = event.getPlayer().getKiller();
        Player player = event.getPlayer();
        String mmoItemType = plugin.getConfig().getString("soul-shard.Type");
        String mmoItemId = plugin.getConfig().getString("soul-shard.Id");
        MMOItem soulShard0 = MMOItems.plugin.getMMOItem(Type.get(mmoItemType), mmoItemId);
        ItemStack soulShard = soulShard0.newBuilder().getItemStack();
        int maxSouls = plugin.getConfig().getInt("max-souls");

        String dieFromPlayer = plugin.getLang(player, "message.die-from-player");
        String dieFromNature = plugin.getLang(player, "message.die-from-other");
        String hasNoSouls = plugin.getLang(player, "message.no-souls");
        String killMessage = plugin.getLang(player, "message.kill");

        if (killer != null){
            plugin.removeSouls(player, 1);
            if (plugin.getSouls(player) == 0){
                player.sendMessage(hasNoSouls);
                player.setGameMode(GameMode.SPECTATOR);
            }
            if (plugin.getSouls(killer) >= maxSouls) {

                if (soulShard != null) {
                    player.getInventory().addItem(soulShard);
                    player.sendMessage(ChatColor.DARK_AQUA + "You already have the maximum" + ChatColor.AQUA + " " + ChatColor.BOLD + "Souls" + ChatColor.DARK_AQUA + "!");
                }else{
                    player.sendMessage(ChatColor.RED + "The SoulShard item not configured correctly!");
                }

            }else{
                plugin.addSouls(killer, 1);
                killer.sendMessage(killMessage);
                player.sendMessage(dieFromPlayer);
            }

        }else {
            plugin.removeSouls(player, 1);
            if (plugin.getSouls(player) == 0){
                player.sendMessage(hasNoSouls);
                player.setGameMode(GameMode.SPECTATOR);
            }
            player.sendMessage(dieFromNature);
        }



    }


}
