package com.virus.Listener;

import com.virus.SQL.INIT_PlayerInfo;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlayerJoin implements Listener {
    @EventHandler
    public void Join(PlayerJoinEvent e) throws SQLException, ClassNotFoundException {
        Player p = e.getPlayer();
        String PlayerName = p.getName();
        BossBar bossBar = Bukkit.createBossBar("/bk可以回到上一个地点哦！", BarColor.YELLOW, BarStyle.SOLID);
        bossBar.addPlayer(p);
        BukkitTask task =  new BukkitRunnable() {
            @Override
            public void run() {
                bossBar.removePlayer(p);
            }

            //Cannot invoke "java.sql.ResultSet.next()" because "rs" is null
        }.runTaskLater(Bukkit.getPluginManager().getPlugin("Virus"), 320L);

        p.sendMessage("欢迎进入Virus_Craft服务器，/bk可回到上一个地点哦！");
        if(PlayerName.equals("Virus_Cui")){
            e.setJoinMessage(ChatColor.DARK_RED +"啊哈哈哈哈哈哈哈，鸡汤来咯！！");
        }else if(PlayerName.equals("lyl")) {
            e.setJoinMessage(ChatColor.YELLOW +"妹妹们,老涩批来了哟~~~");
        }else {
            e.setJoinMessage(ChatColor.LIGHT_PURPLE +"["+ChatColor.WHITE+"+"+ ChatColor.LIGHT_PURPLE+"]"+ChatColor.GREEN+PlayerName+"来了");
        }

        //存储玩家信息
        String pName = p.getName();
        String UUID = String.valueOf(p.getUniqueId());
        //获取系统时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(date);
        //插入数据库
        INIT_PlayerInfo INIT = new INIT_PlayerInfo();
        INIT.__INIT__(pName,UUID,time);


        //显示欢迎语句
        String Today = time.substring(8,10);
        int MotherDay = 8;
        if(Integer.parseInt(Today) == MotherDay){
            p.sendTitle(ChatColor.LIGHT_PURPLE+"祝天下的母亲 母亲节快乐",time);
        }else {
            p.sendTitle(ChatColor.AQUA +"欢迎"+ChatColor.RED+pName+ ChatColor.AQUA+"进入服务器","/bk可以回到上一个地点",20,100,20);
        }

    }
}
