package com.virus.SQL;

import java.sql.ResultSet;
import java.sql.SQLException;

public class lastDeath {

    public void last() throws SQLException, ClassNotFoundException {
        String sql = "select * from `return`";
        BaseDao dao = new BaseDao();
        Object[] objects = null;
        dao.Query(sql, objects);
        ResultSet rs = dao.rs;
        while (rs.next()) {
            System.out.println(rs.getString("pName") + "\t" + rs.getString("x") + "\t" + rs.getString("y") + "\t" + rs.getString("z") + "\t" + rs.getString("world"));
        }
    }
}
