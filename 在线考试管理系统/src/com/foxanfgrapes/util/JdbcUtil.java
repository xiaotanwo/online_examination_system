package com.foxanfgrapes.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

public class JdbcUtil {

    final String URL = "jdbc:mysql://localhost:3306/foxandgrapes";
    final String USERNAME = "root";
    final String PASSWORD = "123456";
    Connection conn = null;
    PreparedStatement ps = null;

    static {
        // 注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public PreparedStatement getPs(String sql) {
        try {
            ps = getConn().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    public void close() {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close();
    }

    //----------------重载----------------------
    public Connection getConn(HttpServletRequest request) {
        ServletContext application = request.getServletContext();
        Map map = (Map)application.getAttribute("connPool");
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            conn = (Connection)it.next();
            Boolean flag = (Boolean) map.get(conn);
            if (flag) {
                map.put(conn, false);
                break;
            }
        }
        return conn;
    }

    public PreparedStatement getPs(String sql, HttpServletRequest request) {
        try {
            ps = getConn(request).prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    public void close(HttpServletRequest request) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        ServletContext application = request.getServletContext();
        Map map = (Map) application.getAttribute("connPool");
        map.put(conn, true);
    }

    public void close(ResultSet rs, HttpServletRequest request) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(request);
    }
    //----------------重载----------------------
}
