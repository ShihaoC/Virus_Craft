package com.virus.SQL;

import java.sql.*;

public class BaseDao {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/back?characterEncoding=utf-8";
    private String uname = "root";
    private String upwd = "123456";
    public Connection con = null;
    public PreparedStatement pstm = null;
    public ResultSet rs = null;

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        con = DriverManager.getConnection(url, uname, upwd);
    }
    public void close() throws SQLException {
        if(rs != null){ rs.close();
        if (pstm != null) pstm.close();
        if(con != null) con.close();
    }
    }
    public int dml(String sql,Object[] obj) throws SQLException, ClassNotFoundException {
        int result = 0;
        connect();
        pstm = con.prepareStatement(sql);
        for(int i = 0;i<obj.length;i++){
            pstm.setObject(i+1,obj[i]);
        }
        result = pstm.executeUpdate();
        close();
        return result;
    }

    public void Query(String sql,Object[] obj) throws SQLException, ClassNotFoundException {
        connect();
        pstm = con.prepareStatement(sql);
        if(obj != null){
            for (int i = 0; i < obj.length; i++) {
                pstm.setObject(i+1,obj[i]);
                rs = pstm.executeQuery();
            }
        }else {
            rs = pstm.executeQuery();
        }


    }
}
