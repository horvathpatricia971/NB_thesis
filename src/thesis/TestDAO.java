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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author horvathpatricia
 */
public class TestDAO {
    private Connection testConn;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement findAll;
    private PreparedStatement findById;
    private PreparedStatement findByTopicId;
    
    public TestDAO(Connection testConn) throws SQLException{
        this.testConn = testConn;
        this.insert = testConn.prepareStatement("insert into test (topicID) values (?)");
        this.delete = testConn.prepareStatement("DELETE FROM test WHERE testID = ?");
        this.update = testConn.prepareStatement("UPDATE test SET topicID = ? WHERE testID = ?");
        this.findAll = testConn.prepareStatement("SELECT * FROM test");
        this.findById = testConn.prepareStatement("SELECT * FROM test WHERE testID = ?");
        this.findByTopicId = testConn.prepareStatement("SELECT * FROM test WHERE topicID = ?");
    }
    
    public void addTest(Test newTest) throws SQLException {
        this.insert.setInt(1, newTest.getTopicID());
        this.insert.executeUpdate();
    }
    
    public void deleteTest(int testID) throws SQLException {
        this.delete.setInt(1, testID);
        this.delete.executeUpdate();
    }
    
    public void updateTest(Test test) throws SQLException {
        this.update.setInt(1, test.getTopicID());
        this.update.setInt(2, test.getTestID());
        this.update.executeUpdate();
    }
    
    public List<Test> findAllTest() throws SQLException {
        List<Test> ret = new ArrayList<>();
        ResultSet rs = this.findAll.executeQuery();
        while (rs.next()) {
            Test test = makeOneTest(rs);
            ret.add(test);
        }
        rs.close();
        return ret;
    }
    
    public Test findTestById(int testID) throws SQLException {
        this.findById.setInt(1, testID);
        ResultSet rs = this.findById.executeQuery();
        Test ret = null;
        if (rs.next()) {
            ret = makeOneTest(rs);
        }
        rs.close();
        return ret;
    }
    
    public List<Test> findTestByTopicId(int topicID) throws SQLException {
        List<Test> ret = new ArrayList<>();
        this.findByTopicId.setInt(1, topicID);
        ResultSet rs = this.findByTopicId.executeQuery();

        while (rs.next()) {
            ret.add(makeOneTest(rs));
        }
        rs.close();
        return ret;
    }
    
    private Test makeOneTest(ResultSet rs) throws SQLException {
        int testID = rs.getInt("testID");
        int topicID = rs.getInt("topicID");
        
        Test test = new Test(testID, topicID); 
        return test;
    }
}
