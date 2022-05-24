package com.virus.Runnable;

import com.virus.SQL.lastDeath;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.SQLException;

public class runn extends BukkitRunnable {
    @Override
    public void run() {
        lastDeath lest = new lastDeath();
        try {
            lest.last();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
