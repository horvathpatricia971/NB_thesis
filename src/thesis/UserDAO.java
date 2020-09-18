/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author horvathpatricia
 */
public class UserDAO {
    private Connection conn;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement findAll;
    private PreparedStatement findById;
    
    public UserDAO(Connection conn) throws SQLException {
        this.conn = conn;
        this.insert = conn.prepareStatement("insert into user (userName, gender, age, education, disease, hearing, seeing, testNumber, userResult) values (?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        this.delete = conn.prepareStatement("DELETE FROM user WHERE userID = ?");
        this.update = conn.prepareStatement("UPDATE user SET userName = ?, gender = ?, age = ?, education = ?, disease = ?, hearing = ?, seeing = ?, testNumber = ?, userResult = ? WHERE userID = ?");
        this.findAll = conn.prepareStatement("SELECT * FROM user");
        this.findById = conn.prepareStatement("SELECT * FROM user WHERE userID = ?");
    }
    
    public void addUser(User newUser) throws SQLException {
        this.insert.setString(1, newUser.getUsername());
        this.insert.setString(2, newUser.getGender());
        this.insert.setInt(3, newUser.getAge());
        this.insert.setString(4, newUser.getEducation());
        this.insert.setString(5, newUser.getDesease());
        this.insert.setString(6, newUser.getHearing());
        this.insert.setString(7, newUser.getSeeing());
        this.insert.setInt(8, newUser.getTestNumber());
        this.insert.setInt(9, newUser.getUserResult());
        this.insert.executeUpdate();
        
        try (ResultSet generatedKeys = this.insert.getGeneratedKeys()) {
            if (generatedKeys.next())
                newUser.setUserID(generatedKeys.getInt(1));
            else
                throw new SQLException("No ID generated");
        }
    }
    
    public void deleteUser(int userID) throws SQLException {
        this.delete.setInt(1, userID);
        this.delete.executeUpdate();
    }
    
    public void updateUser(User user) throws SQLException {
        this.update.setString(1, user.getUsername());
        this.update.setString(2, user.getGender());
        this.update.setInt(3, user.getAge());
        this.update.setString(4, user.getEducation());
        this.update.setString(5, user.getDesease());
        this.update.setString(6, user.getHearing());
        this.update.setString(7, user.getSeeing());
        this.update.setInt(8, user.getTestNumber());
        this.update.setInt(9, user.getUserResult());
        this.update.setInt(10, user.getUserID());
        this.update.executeUpdate();
    }
    
    public List<User> findAllUser() throws SQLException {
        List<User> ret = new ArrayList<>();
        ResultSet rs = this.findAll.executeQuery();
        while (rs.next()) {
            User user = makeOneUser(rs);
            ret.add(user);
        }
        rs.close();
        return ret;
    }
    
    public User findByIdUser(int id) throws SQLException {
        this.findById.setInt(1, id);
        ResultSet rs = this.findById.executeQuery();
        User ret = null;
        if (rs.next()) {
            ret = makeOneUser(rs);
        }
        rs.close();
        return ret;
    }
    
    private User makeOneUser(ResultSet rs) throws SQLException {
        int id = rs.getInt("userID");
        String userName = rs.getString("userName");
        String gender = rs.getString("gender");
        int age = rs.getInt("age");
        String education = rs.getString("education");
        String disease = rs.getString("disease");
        String hearing = rs.getString("hearing");
        String seeing = rs.getString("seeing");
        int testNumber = rs.getInt("testNumber");
        int userResult = rs.getInt("userResult");
        User user = new User(id, userName, gender, age, education, disease, hearing, seeing, testNumber, userResult); 
        return user;
    }
}
