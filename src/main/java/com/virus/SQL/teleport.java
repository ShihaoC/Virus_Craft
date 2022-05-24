package com.virus.SQL;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

public class teleport {
    public void tel(Player p) throws SQLException, ClassNotFoundException {
        BaseDao dao = new BaseDao();
        int x = 0;
        int y = 0;
        int z = 0;
        String world = "";
        String pName = p.getName();
        String sql = "select x,y,z,world from `return` where pName = ?";
        Object[] obj = {pName};
        dao.Query(sql, obj);
        ResultSet rs = dao.rs;
        if (rs.next()) {
            x = Integer.parseInt(rs.getString("x").substring(0, rs.getString("x").indexOf(".")));
            y = Integer.parseInt(rs.getString("y").substring(0, rs.getString("y").indexOf(".")));
            z = Integer.parseInt(rs.getString("z").substring(0, rs.getString("z").indexOf(".")));
            world = rs.getString("world");
            p.sendMessage(ChatColor.YELLOW+"[传送] 正在传送...");
            p.getPlayer().teleport(new Location(Bukkit.getWorld(world),x,y,z));
        } else {
            p.sendMessage(ChatColor.GREEN+"[传送] 没有上一个地点");
        }


    }
}
