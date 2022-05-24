package com.virus.SQL;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LastLeaveTime {
    public void saveLast(String pName,String UUID,String Date) throws SQLException, ClassNotFoundException {
        String sql = "";
        ResultSet rs = null;
        BaseDao dao = new BaseDao();

        sql = "select * from playerlastleave where UUID = ?";
        Object[] objQuery = {UUID};
        dao.Query(sql,objQuery);
        rs = dao.rs;
        if(rs.next()){
            sql = "update playerlastleave set Date = ? where UUID = ?";
            Object[] objUpdate = {Date,UUID};
            dao.dml(sql,objUpdate);
            System.out.println("更改成功");
        }else {
            sql = "insert into playerlastleave(pName,UUID,Date) Values(?,?,?)";
            Object[] objInsert = {pName,UUID,Date};
            dao.dml(sql,objInsert);
            System.out.println("添加成功");
        }

    }
}
