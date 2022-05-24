package com.virus.SQL;

import java.sql.ResultSet;
import java.sql.SQLException;

public class INIT_PlayerInfo {
    public void __INIT__(String pName,String UUID,String time) throws SQLException, ClassNotFoundException {
        BaseDao dao = new BaseDao();
        String sql = "select * from playerinfo where UUID = ?";
        Object[] objs = {UUID};
        dao.Query(sql,objs);
        ResultSet rs = dao.rs;
        if(rs.next()){
            String UpdateSql = "update playerinfo set lastLoginTime = ? where UUID = ?";
            Object[] objUpdate = {time,UUID};
            dao.dml(UpdateSql,objUpdate);
        }else {
            String InsertSql = "insert into playerinfo(pName,UUID,lastLoginTime) values(?,?,?)";
            Object[] objInsert = {pName,UUID,time};
            dao.dml(InsertSql,objInsert);
        }
    }
}
