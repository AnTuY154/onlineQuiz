/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Question;
import entity.User;
import entity.lastInputQues;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Darkness_King
 */
public class QuizDAO {

    public void inserQuiz(Question q) throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            String sql = "INSERT INTO question\n"
                    + "VALUES (?,?,?,?,?,?,GETDATE());";
            ps = conn.prepareStatement(sql);
            ps.setString(1, q.getQuestion());

            //
            for (int i = 0; i < q.getAnswer().size(); i++) {
                ps.setString(i + 2, q.getAnswer().get(i));
            }
            ps.setString(6, q.getRightAnswer());
            ps.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            throw e;
        } finally {
            conn.setAutoCommit(true);
            db.closeConnection(rs, ps, conn);
        }
      
    }

    public ArrayList<Question> getQuiz(int id) throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Question> a = new ArrayList();
        try {
            String sql = "SELECT top (?)* "
                    + "FROM question\n"
                    + "ORDER BY NEWID()";
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Question q = new Question();
                q.setQuestion(rs.getString("quiz"));

                ArrayList<String> ans = new ArrayList();
                ans.add(rs.getNString("answer1"));
                ans.add(rs.getNString("answer2"));
                ans.add(rs.getNString("answer3"));
                ans.add(rs.getNString("answer4"));
                q.setRightAnswer(rs.getString("isright"));
                q.setAnswer(ans);
                a.add(q);
            }
            return a;
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }

    }

    public void inserUser(User u) throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            String sql = "INSERT INTO [user]\n"
                    + "VALUES (?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setNString(1, u.getName());
            ps.setNString(2, u.getPassword());
            ps.setNString(3, u.getEmail());
            ps.setNString(4, u.getType());
            ps.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            throw e;
        } finally {
            conn.setAutoCommit(true);
            db.closeConnection(rs, ps, conn);
        }
    }

    public boolean getUserName(String userName) throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "Select * from [user] u where u.userName = ?";
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return false;
    }

    public User getInfoUserName(String userName) throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "Select * from [user] u where u.userName = ?";
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setName(rs.getNString("userName"));
                u.setPassword(rs.getNString("password"));
                u.setEmail(rs.getNString("email"));
                u.setType(rs.getNString("type"));
                return u;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return null;
    }

    public boolean checkmail(String email) throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "Select * from [user] u where u.email = ?";
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return false;
    }

    public ArrayList<Question> getAllQuestion(int pageindex, int pagesize) throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Question> question = new ArrayList();
        try {
            String sql = " select * from ("
                    + " SELECT *, ROW_NUMBER() OVER (ORDER BY date ASC) as row_num FROM question) abc"
                    + "             WHERE row_num >= (? - 1)*? +1 AND row_num<= ? * ?";
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pageindex);
            ps.setInt(2, pagesize);
            ps.setInt(3, pageindex);
            ps.setInt(4, pagesize);

            rs = ps.executeQuery();
            while (rs.next()) {
                Question q = new Question();
                q.setQuestion(rs.getString("quiz"));
                ArrayList<String> ans = new ArrayList();
                ans.add(rs.getNString("answer1"));
                ans.add(rs.getNString("answer2"));
                ans.add(rs.getNString("answer3"));
                ans.add(rs.getNString("answer4"));
                q.setRightAnswer(rs.getString("isright"));
                Date date = rs.getDate("date");
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy ");

                String cvDate = dateFormat1.format(date);
                q.setDate(cvDate);
                question.add(q);

            }
            return question;
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }

    }

    public int countQuestion() throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select Count(*) as numberOfQues  from question";
            //   System.out.println(sql);
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("numberOfQues");
            }
        } catch (Exception e) {
            throw e;
        }
        return 0;
    }

    public void DeleteQuiz(String question) throws Exception {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String sql
                    = " delete from question \n"
                    + "where quiz= ?";
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, question);
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            conn.setAutoCommit(true);
            db.closeConnection(rs, ps, conn);
        }
    }

}
