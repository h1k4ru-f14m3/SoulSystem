package me.hikaru.soulsystem.commands;

import me.hikaru.soulsystem.SoulSystem;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandSoulSystem implements CommandExecutor {

    public final SoulSystem plugin;

    public CommandSoulSystem(SoulSystem plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player player = (Player) commandSender;

        if (!player.hasPermission("SoulSystem.admin")){
            player.sendMessage(ChatColor.RED + "You don't have permission to run this command!");
        }

        if (args.length < 3) {
            player.sendMessage(ChatColor.RED + "You didn't provide any command arguments!");
        }

        String subCommand = args[0];
        String targetPlayerName = args[1];
        int amount;

        try {
            amount = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            player.sendMessage(ChatColor.RED + "Invalid amount specified!");
            return true;
        }

        Player targetPlayer = plugin.getServer().getPlayer(targetPlayerName);
        int maxsouls = plugin.getConfig().getInt("max-souls");

        if (targetPlayer == null){
            player.sendMessage(ChatColor.RED + "Player not found!");
            return true;
        }

        // SET SOULS!!!!!
        if (subCommand.equalsIgnoreCase("setsouls")){
            if (amount > maxsouls){
                player.sendMessage(ChatColor.RED + "The Maximum amount of souls a player can have is " + maxsouls + "!");
            }else{
                plugin.setSouls(targetPlayer, amount);
                player.sendMessage(ChatColor.AQUA + "You set " + targetPlayer.getDisplayName() + "'s Souls To" + amount);
                targetPlayer.sendMessage(ChatColor.AQUA + "An Admin set your souls amount to " + amount);
            }

        // ADD SOULS!!!!!
        }else if (subCommand.equalsIgnoreCase("addsouls")){
            int updatedSouls = plugin.getSouls(targetPlayer) + amount;
            if (updatedSouls != maxsouls) {
                plugin.addSouls(targetPlayer, amount);
                player.sendMessage(ChatColor.AQUA + "You added " + amount + " Soul(s) to " + targetPlayer.getDisplayName());
                targetPlayer.sendMessage(ChatColor.AQUA + "An Admin gave you " + amount + " Soul(s)!");
            }else{
                player.sendMessage(ChatColor.RED + "The Maximum amount of souls a player can have is " + maxsouls + "!");
            }

        // REMOVE SOULS!!!!
        }else if (subCommand.equalsIgnoreCase("removesouls")) {
            plugin.removeSouls(targetPlayer, amount);
            player.sendMessage(ChatColor.AQUA + "You removed " + amount + " Soul(s) from " + targetPlayer.getDisplayName());
            targetPlayer.sendMessage(ChatColor.AQUA + "An Admin removed " + amount + " from you!");

        // CHECK SOULS!!!
        }else if (subCommand.equalsIgnoreCase("checksouls")) {
            player.sendMessage(ChatColor.DARK_AQUA + targetPlayer.getDisplayName() + " has " + ChatColor.AQUA + plugin.getSouls(targetPlayer) + " Souls " + ChatColor.DARK_AQUA + "left" + ChatColor.AQUA + "!" );

        // Invaild Usage!
        }else{
            player.sendMessage(ChatColor.RED + "Invaild Usage!");
            player.sendMessage(ChatColor.RED + "Usage: /soulsystem [<addsouls/setsouls/removesouls>] [<playername>] [<amount>]");
        }



        return true;
    }
}
