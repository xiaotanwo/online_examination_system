package com.foxanfgrapes.dao;

import com.foxanfgrapes.entity.Questions;
import com.foxanfgrapes.util.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
    private JdbcUtil jdbcUtil = new JdbcUtil();
    public int add (Questions question, HttpServletRequest request) {
        String sql = "insert into questions (question, optionA, optionB, optionC, optionD, answer) values(?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = jdbcUtil.getPs(sql, request);
        int result = 0;
        try {
            ps.setString(1, question.getQuestion());
            ps.setString(2, question.getOptionA());
            ps.setString(3, question.getOptionB());
            ps.setString(4, question.getOptionC());
            ps.setString(5, question.getOptionD());
            ps.setString(6, question.getAnswer());
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
        String sql = "select * from questions";
        PreparedStatement ps = jdbcUtil.getPs(sql, request);
        String question, optionA, optionB, optionC, optionD, answer;
        Integer questionId;
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                questionId = rs.getInt("questionId");
                question = rs.getString("question");
                optionA = rs.getString("optionA");
                optionB = rs.getString("optionB");
                optionC = rs.getString("optionC");
                optionD = rs.getString("optionD");
                answer = rs.getString("answer");
                Questions questions = new Questions(questionId, question, optionA, optionB, optionC, optionD, answer);
                list.add(questions);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(rs, request);
        }
        return list;
    }

    public int delete(Integer questionId, HttpServletRequest request) {
        String sql = "delete from questions where questionId=?";
        PreparedStatement ps = jdbcUtil.getPs(sql, request);
        int result = 0;
        try {
            ps.setInt(1, questionId);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(request);
        }
        return result;
    }

    public Questions findById(Integer questionId, HttpServletRequest request) {
        String sql = "select * from questions where questionId=?";
        PreparedStatement ps = jdbcUtil.getPs(sql, request);
        String question, optionA, optionB, optionC, optionD, answer;
        Questions questions = null;
        ResultSet rs = null;
        try {
            ps.setInt(1, questionId);
            rs = ps.executeQuery();
            if (rs.next()) {
                question = rs.getString("question");
                optionA = rs.getString("optionA");
                optionB = rs.getString("optionB");
                optionC = rs.getString("optionC");
                optionD = rs.getString("optionD");
                answer = rs.getString("answer");
                questions = new Questions(questionId, question, optionA, optionB, optionC, optionD, answer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(rs, request);
        }
        return questions;
    }

    public int update (Questions question, HttpServletRequest request) {
        String sql = "update questions set question=?, optionA=?, optionB=?, optionC=?, optionD=?, answer=? where questionId=?";
        PreparedStatement ps = jdbcUtil.getPs(sql, request);
        int result = 0;
        try {
            ps.setString(1, question.getQuestion());
            ps.setString(2, question.getOptionA());
            ps.setString(3, question.getOptionB());
            ps.setString(4, question.getOptionC());
            ps.setString(5, question.getOptionD());
            ps.setString(6, question.getAnswer());
            ps.setInt(7, question.getQuestionId());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(request);
        }
        return result;
    }

    public List findRand(HttpServletRequest request) {
        String sql = "select * from questions order by rand() limit 5";
        List list = new ArrayList();
        PreparedStatement ps = jdbcUtil.getPs(sql, request);
        String question, optionA, optionB, optionC, optionD, answer;
        Integer questionId;
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                questionId = rs.getInt("questionId");
                question = rs.getString("question");
                optionA = rs.getString("optionA");
                optionB = rs.getString("optionB");
                optionC = rs.getString("optionC");
                optionD = rs.getString("optionD");
                answer = rs.getString("answer");
                Questions questions = new Questions(questionId, question, optionA, optionB, optionC, optionD, answer);
                list.add(questions);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(rs, request);
        }
        return list;
    }
}
