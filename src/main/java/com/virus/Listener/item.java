package com.virus.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldEvent;

public class item implements Listener {
    @EventHandler
    public void getItems(WorldEvent e){
        int num =  e.getWorld().getEntities().size();
        int SUM = 0;
        int num2 = e.getWorld().getEntities().size();
        SUM = num - num2;

        System.out.println();

    }
}

