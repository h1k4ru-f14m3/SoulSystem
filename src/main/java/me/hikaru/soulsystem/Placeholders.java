package me.hikaru.soulsystem;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Placeholders extends PlaceholderExpansion {

    public final SoulSystem plugin;

    public Placeholders(SoulSystem plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "souls";
    }

    @Override
    public @NotNull String getAuthor() {
        return "H1k4ru_";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.1.4-SNAPSHOT";
    }

    public String onPlaceholderRequest(Player player, String identifier){
        if (identifier.equalsIgnoreCase("souls_count")){
            return String.valueOf(plugin.getSouls(player));
        }
        return identifier;
    }


}
