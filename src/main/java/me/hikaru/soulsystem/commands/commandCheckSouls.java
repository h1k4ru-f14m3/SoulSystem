package me.hikaru.soulsystem.commands;

import me.hikaru.soulsystem.SoulSystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class commandCheckSouls implements CommandExecutor {
    
    public final SoulSystem plugin;

    public commandCheckSouls(SoulSystem plugin) {

        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        String checkSouls = plugin.getLang(player, "message.check-souls");

        if (commandSender instanceof Player){
            player.sendMessage(checkSouls);
        }
        
        
        
        return true;
    }
}
