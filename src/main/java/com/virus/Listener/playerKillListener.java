package com.virus.Listener;

import com.virus.SQL.BaseDao;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class playerKillListener implements Listener {
    @EventHandler
    public void PlayerKill(PlayerDeathEvent e) throws SQLException, ClassNotFoundException {
        //初始化BaseDao对象
        BaseDao dao = new BaseDao();
        //定义各项初始值
        String x = "";
        String y = "";
        String z = "";
        String name = "";
        String playerName = "";
        //获取死亡玩家的坐标
        String local = String.valueOf(e.getEntity().getPlayer().getLocation());
        System.out.println(local);
        //获取玩家名称
        playerName = e.getEntity().getPlayer().getName();
        //截取字符串获取x,y,z,name的值
        x = local.substring(local.indexOf("x=") + 2, local.indexOf(",y"));
        y = local.substring(local.indexOf("y=") + 2, local.indexOf(",z"));
        z = local.substring(local.indexOf("z=") + 2, local.indexOf(",pitch"));
        name = local.substring(local.indexOf("name=") + 5, local.indexOf("}"));
        System.out.println(name + " " + x + " " + y + " " + z);
        //SQL
        //定义SQL语句
        String sqlQ = "select * from `return` where pName = ?";
        Object[] obj2 = {playerName};
        //调用Query方法
        dao.Query(sqlQ, obj2);
        ResultSet rs = dao.rs;
        Boolean flag = rs.next();
        //条件判断
        if (flag) {
            String sqlU = "UPDATE `return` set x=?,y=?,z=?,world=? WHERE pName = ?";
            Object[] objU = {x, y, z, name, playerName};
            dao.dml(sqlU, objU);
        } else {
            String sql = "INSERT INTO `return`(pName,x,y,z,world) VALUES(?,?,?,?,?)";
            Object[] obj = {playerName, x, y, z, name};
            dao.dml(sql, obj);
        }
        dao.close();
    }
}
