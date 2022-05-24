package com.virus.Listener;

import com.virus.SQL.DeleteLastDeath;
import com.virus.SQL.LastLeaveTime;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class playerLeft implements Listener {
    @EventHandler
    public void left(PlayerQuitEvent e) throws SQLException, ClassNotFoundException {
        Player player = e.getPlayer();
        String playerName = player.getName();
        DeleteLastDeath lastDeath = new DeleteLastDeath();
        lastDeath.delete(playerName);
        if(playerName.equals("lyl")){
            e.setQuitMessage(ChatColor.AQUA +playerName+"老涩批走了.......");
        }else {
            e.setQuitMessage(ChatColor.GRAY+"["+ChatColor.RED+"-"+ChatColor.GRAY+"]"+ChatColor.RED+playerName+"离开了游戏");
        }


        String pName = player.getName();
        String UUID = String.valueOf(player.getUniqueId());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(date);

        LastLeaveTime Last = new LastLeaveTime();
        Last.saveLast(pName,UUID,time);
    }
}
