package com.virus.Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class PlayerInfo implements Listener {
    @EventHandler
    public void Info(PlayerChatEvent e){
        Player p = e.getPlayer();
        if(p.getName().equals("Virus_Cui")) {
            e.setFormat(ChatColor.DARK_RED + "[腐竹] " + ChatColor.YELLOW + p.getName() + "> " + e.getMessage());
        }else if(p.getName().equals("lyl")){
            e.setFormat(ChatColor.BLUE + "[老涩批] " + ChatColor.AQUA + p.getName() + "> " + e.getMessage());
        }else{
            e.setFormat(ChatColor.WHITE +"[玩家] "+ChatColor.AQUA+p.getName()+"> "+e.getMessage());
        }
    }
}
