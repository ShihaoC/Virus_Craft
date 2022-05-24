package com.virus.Listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class playerGamemode implements Listener {
    @EventHandler
    public void gameMode(PlayerJoinEvent e){
        Player player = e.getPlayer();
        player.setGameMode(GameMode.SURVIVAL);
    }
}
