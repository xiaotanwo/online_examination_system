package com.foxanfgrapes.listener;

import com.foxanfgrapes.util.JdbcUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ServerListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        Map map = new HashMap();
        JdbcUtil jdbcUtil = new JdbcUtil();
        // 创建conn池
        System.out.println("创建30个conn的池");
        for (int i=0; i<30; i++) {
            Connection conn = jdbcUtil.getConn();
            map.put(conn, true);
        }
        application.setAttribute("connPool", map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Map map = (Map) sce.getServletContext().getAttribute("connPool");
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Connection conn = (Connection) it.next();
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
