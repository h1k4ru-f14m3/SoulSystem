package me.hikaru.soulsystem;

//import me.hikaru.soulsystem.commands.AdminCommands; //
import me.clip.placeholderapi.PlaceholderAPI;
import me.hikaru.soulsystem.commands.CommandSoulSystem;
import me.hikaru.soulsystem.commands.commandCheckSouls;
import me.hikaru.soulsystem.commands.commandRevive;
import me.hikaru.soulsystem.listeners.PlayerJoin;
import me.hikaru.soulsystem.listeners.PlayerKill;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public final class SoulSystem extends JavaPlugin implements @NotNull Listener {

    private final Map<Player, Integer> souls = new HashMap<>();

    public void setSouls(Player player, int amount) {
        souls.put(player, amount);
    }

    public void addSouls(Player player, int amount) {
        int playerSouls = souls.getOrDefault(player, 0);
        souls.put(player, playerSouls + amount);
    }

    public void removeSouls(Player player, int amount) {
        int playerSouls = souls.getOrDefault(player, 0);
        int updatedSouls = Math.max(0, playerSouls - amount);
        souls.put(player, updatedSouls);
        if (updatedSouls == 0){
            player.setGameMode(GameMode.SPECTATOR);
        }
    }

    public int getSouls(Player player){
        return souls.getOrDefault(player, 0);
    }

    public String getLang(Player player, String path){
        String message = PlaceholderAPI.setPlaceholders(player, getConfig().getString(path));
        message = ChatColor.translateAlternateColorCodes('&', getConfig().getString(path));
        return message;
    }

    public void loadConfig() {
        File configFile = new File(getDataFolder(), "config.yml");
        Logger logger = getLogger();
        if (!configFile.exists()){
            saveDefaultConfig();
            reloadConfig();
            logger.info("SoulSystem config.yml loaded");
        }
    }


    @Override
    public void onEnable() {

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            /*
             * We register the EventListener here, when PlaceholderAPI is installed.
             * Since all events are in the main class (this class), we simply use "this"
             */
            new Placeholders(this).register();
            getCommand("revive").setExecutor(new commandRevive(this));
            getCommand("checksouls").setExecutor(new commandCheckSouls(this));
            getCommand("soulsystem").setExecutor(new CommandSoulSystem(this));
            getServer().getPluginManager().registerEvents((Listener) new PlayerKill(this), this);
            getServer().getPluginManager().registerEvents((Listener) new PlayerJoin(this), this);
            loadConfig();
        } else {
            /*
             * We inform about the fact that PlaceholderAPI isn't installed and then
             * disable this plugin to prevent issues.
             */
            getLogger().info(   "Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
}}
