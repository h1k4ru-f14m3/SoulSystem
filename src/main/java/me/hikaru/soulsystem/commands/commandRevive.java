package me.hikaru.soulsystem.commands;

import me.hikaru.soulsystem.SoulSystem;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class commandRevive implements CommandExecutor {

    public final SoulSystem plugin;

    public commandRevive(SoulSystem plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        // Variables
        Player player = (Player) commandSender;

        String reviveSuccess = plugin.getLang(player, "message.revive-success");
        String gotRevived = plugin.getLang(player, "message.got-revived");
        String notDead = plugin.getLang(player, "message.not-dead");
        String dead = plugin.getLang(player, "message.dead");
        String notEnoughSouls = plugin.getLang(player, "message.not-enough-souls");

        if (commandSender instanceof Player) {


            if (args.length == 0){
                commandSender.sendMessage(ChatColor.RED + "You didn't specify a player to revive!");
            } else{
                Player revivePlayer = plugin.getServer().getPlayer(args[0]);
                if (revivePlayer.getGameMode() == GameMode.SPECTATOR){
                    if (plugin.getSouls(player) >= 4){
                        player.sendMessage(reviveSuccess);
                        revivePlayer.sendMessage(gotRevived);
                        revivePlayer.setGameMode(GameMode.SURVIVAL);
                        plugin.setSouls(revivePlayer, 1);
                        plugin.removeSouls(player, 3);
                    }else{
                        player.sendMessage(notEnoughSouls);
                    }
                }else{
                    player.sendMessage(notDead);
                }

            }

        }else{

            System.out.println("Get on the server bruv");

        }if (player.getGameMode().equals(GameMode.SPECTATOR)){
            player.sendMessage(dead);
        }

        return true;
    }
}
