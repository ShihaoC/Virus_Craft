package com.virus.SQL;

import java.sql.SQLException;

public class DeleteLastDeath {
    public void delete(String playerName) throws SQLException, ClassNotFoundException {
        BaseDao dao = new BaseDao();
        String sql = "DELETE FROM `return` where pName = ?";
        Object[] obj = {playerName};
        dao.dml(sql,obj);
    }
}
