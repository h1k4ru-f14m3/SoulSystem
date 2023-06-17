/* package me.hikaru.soulsystem.commands;

import me.hikaru.soulsystem.SoulSystem;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AdminCommands implements CommandExecutor {
    public final SoulSystem plugin;

    public AdminCommands(SoulSystem plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player player = (Player) commandSender;
        String targetplayername = args[1];
        int amount = Integer.parseInt(args[2]);
        Player targetplayer = plugin.getServer().getPlayer(targetplayername);

        if (!player.hasPermission("soulsSystem.admin")) {
            player.sendMessage(ChatColor.RED + "You don't have permission to run this command!");
        }else if (args.length == 0){
            player.sendMessage(ChatColor.RED + "You didn't provide any command arguments!");
        // SET SOULS!!!
        }else if (args[0] == "setsouls"){

            if (args[1] != null){

                if (args[2] != null){
                    plugin.setSouls(targetplayer, amount);
                    player.sendMessage(ChatColor.AQUA + "You set " + targetplayer.getDisplayName() + "'s Souls To" + amount);
                    targetplayer.sendMessage(ChatColor.AQUA + "An Admin set your souls amount to " + amount);
                }else{
                    player.sendMessage(ChatColor.RED + "You need to specify an amount!");
                }

            }else{
                player.sendMessage(ChatColor.RED + "You need to specify a player or the player you entered can't be found!");
            }
        // ADD SOULS!!!
        }else if (args[0] == "addsouls"){

            if (args[1] != null){

                if (args[2] != null){
                    plugin.addSouls(targetplayer, amount);
                    player.sendMessage(ChatColor.AQUA + "You added " + amount + " Soul(s) to " + targetplayer.getDisplayName());
                    targetplayer.sendMessage(ChatColor.AQUA + "An Admin gave you " + amount + " Soul(s)!");
                }else{
                    player.sendMessage(ChatColor.RED + "You need to specify an amount!");
                }

            }else{
                player.sendMessage(ChatColor.RED + "You need to specify a player or the player you entered can't be found!");
            }

        }else if (args[0] == "removesouls"){

            if (args[1] != null){

                if (args[2] != null){
                    plugin.removeSouls(targetplayer, amount);
                    player.sendMessage(ChatColor.AQUA + "You removed " + amount + " Soul(s) from " + targetplayer.getDisplayName());
                    targetplayer.sendMessage(ChatColor.AQUA + "An Admin removed " + amount + " from you!");
                }else{
                    player.sendMessage(ChatColor.RED + "You need to specify an amount!");
                }

            }else{
                player.sendMessage(ChatColor.RED + "You need to specify a player or the player you entered can't be found!");
            }

        }


        return true;
    }
} */
