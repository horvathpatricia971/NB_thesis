/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author horvathpatricia
 */
public class TestAttemptDAO {
    private Connection conn;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement findAll;
    private PreparedStatement findById;
    
    public TestAttemptDAO(Connection conn) throws SQLException{
        this.conn = conn;
        this.insert = conn.prepareStatement("insert into testAttempt (userID, testID, result, startTime, endTime) values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        this.delete = conn.prepareStatement("DELETE FROM testAttempt WHERE testAttemptID = ?");
        this.update = conn.prepareStatement("UPDATE testAttempt SET userID = ?, testID = ?, result = ?, startTime = ?, endTime = ? WHERE testAttemptID = ?");
        this.findAll = conn.prepareStatement("SELECT * FROM testAttempt");
        this.findById = conn.prepareStatement("SELECT * FROM testAttempt WHERE testAttemptID = ?");
    }
    
    public void addTestAttempt(TestAttempt attempt) throws SQLException {
        this.insert.setInt(1, attempt.getUserId());
        this.insert.setInt(2, attempt.getTestId());
        this.insert.setInt(3, attempt.getResult());
        this.insert.setTimestamp(4, attempt.getStartTime());
        this.insert.setTimestamp(5, attempt.getEndTime());
        this.insert.executeUpdate();
        try (ResultSet keys = this.insert.getGeneratedKeys()) {
            if (keys.next())
                attempt.setTestAttemptID(keys.getInt(1));
            else
                throw new SQLException("Test Attempt ID setting failed.");
        }
    }
    
    public void deleteTestAttempt(int testAttemptID) throws SQLException {
        this.delete.setInt(1, testAttemptID);
        this.delete.executeUpdate();
    }
    
    public void updateTestAttempt(TestAttempt attempt) throws SQLException {
        this.update.setInt(1, attempt.getUserId());
        this.update.setInt(2, attempt.getTestId());
        this.update.setInt(3, attempt.getResult());
        this.update.setTimestamp(4, attempt.getStartTime());
        this.update.setTimestamp(5, attempt.getEndTime());
        this.update.setInt(6, attempt.getTestAttemptID());
        this.update.executeUpdate();
    }
    
    public List<TestAttempt> findAllTestAttempt() throws SQLException {
        List<TestAttempt> ret = new ArrayList<>();
        ResultSet rs = this.findAll.executeQuery();
        while (rs.next()) {
            TestAttempt attempt = makeOneTestAttempt(rs);
            ret.add(attempt);
        }
        rs.close();
        return ret;
    }
    
    public TestAttempt findTestAttemptById(int testAttemptID) throws SQLException {
        this.findById.setInt(1, testAttemptID);
        ResultSet rs = this.findById.executeQuery();
        TestAttempt ret = null;
        if (rs.next()) {
            ret = makeOneTestAttempt(rs);
        }
        rs.close();
        return ret;
    }
    
    private TestAttempt makeOneTestAttempt(ResultSet rs) throws SQLException {
        int testAttemptID = rs.getInt("testAttemptID");
        int userID = rs.getInt("userID");
        int testID = rs.getInt("testID");
        int result = rs.getInt("result");
        Timestamp startTime = rs.getTimestamp("startTime");
        Timestamp endTime = rs.getTimestamp("endTime");
        
        TestAttempt attempt = new TestAttempt(testAttemptID, userID, testID, result, startTime, endTime); 
        return attempt;
    }
}
