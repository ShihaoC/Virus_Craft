package com.virus.Runnable;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class DropItem {
    public void DropItems() {
        //初始化实体数量
        int entity1_world = 0;
        int entity2_world = 0;
        int entity1_world_the_end = 0;
        int entity2_world_the_end = 0;
        int entity1_world_nether = 0;
        int entity2_world_nether = 0;
        int sum = 0;
        int sum2 = 0;
        int sum3 = 0;
        //获取清除前实体数量
        entity1_world = Bukkit.getWorld("world").getEntities().size();
        entity1_world_the_end = Bukkit.getWorld("world_nether").getEntities().size();
        entity1_world_nether = Bukkit.getWorld("world_the_end").getEntities().size();
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "killall drops world");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "killall drops world_nether");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "killall drops world_the_end");
        //清除实体
        entity2_world = Bukkit.getWorld("world").getEntities().size();
        //获取清除后的实体数量
        entity2_world_the_end = Bukkit.getWorld("world_nether").getEntities().size();
        entity2_world_nether = Bukkit.getWorld("world_the_end").getEntities().size();
        System.out.println("清理成功");
        //主世界清除掉落物的数量
        sum = entity1_world - entity2_world;
        //地狱清除掉落物的数量
        sum2 = entity1_world_the_end - entity2_world_the_end;
        //末地清除掉落物的数量
        sum3 = entity1_world_nether - entity2_world_nether;
        //清除总数量
        int sumS = sum + sum3 + sum2;
        //给玩家发送清除信息
        Bukkit.broadcastMessage(ChatColor.YELLOW + "开始清理");
        Bukkit.broadcastMessage("清理主世界掉落物:" + ChatColor.AQUA + sum);
        Bukkit.broadcastMessage("清理地狱掉落物:" + ChatColor.AQUA + sum2);
        Bukkit.broadcastMessage("清理末地掉落物:" + ChatColor.AQUA + sum3);
        Bukkit.broadcastMessage("此次共清理掉落物:" + ChatColor.RED + sumS);
        Bukkit.broadcastMessage(ChatColor.YELLOW + "清理完毕");
    }
}

