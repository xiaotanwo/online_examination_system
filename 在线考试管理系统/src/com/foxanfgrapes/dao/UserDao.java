package com.foxanfgrapes.dao;

import com.foxanfgrapes.entity.Users;
import com.foxanfgrapes.util.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private JdbcUtil jdbcUtil = new JdbcUtil();
    public int add (Users user, HttpServletRequest request) {
        String sql = "insert into users(userName, password, sex, email) values(?, ?, ?, ?)";
        PreparedStatement ps = jdbcUtil.getPs(sql, request);
        int result = 0;
        try {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(request);
        }
        return result;
    }

    public List find(HttpServletRequest request) {
        List list = new ArrayList();
        String sql = "select * from users";
        PreparedStatement ps = jdbcUtil.getPs(sql, request);
        String userName, password, sex, email;
        Integer userId;
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                userId = rs.getInt("userId");
                userName = rs.getString("userName");
                password = rs.getString("password");
                sex = rs.getString("sex");
                email = rs.getString("email");
                Users user = new Users(userId, userName, password, sex, email);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(rs, request);
        }
        return list;
    }

    public int delete(Integer userId, HttpServletRequest request) {
        String sql = "delete from users where userId=?";
        PreparedStatement ps = jdbcUtil.getPs(sql, request);
        int result = 0;
        try {
            ps.setInt(1, userId);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(request);
        }
        return  result;
    }

    public int login(String userName, String password, HttpServletRequest request) {
        String sql = "select count(*) from users where userName=? and password=?";
        PreparedStatement ps = jdbcUtil.getPs(sql, request);
        int result = 0;
        ResultSet rs = null;
        try {
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(rs, request);
        }
        return  result;
    }
}
