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
public class ResultDAO {
    private Connection conn;
    private PreparedStatement findByUserId;
    
    public ResultDAO(Connection conn) throws SQLException{
        this.conn = conn;
        this.findByUserId = conn.prepareStatement("SELECT user.userName, topic.topic, topic.difficulty, testAttempt.result, TIMESTAMPDIFF(second, testAttempt.startTime, testAttempt.endTime) as time, testAttempt.prize FROM user JOIN testAttempt ON user.userID = testAttempt.userID JOIN test ON test.testID = testAttempt.testID JOIN topic ON topic.topicID = test.topicID WHERE user.userID = ?");
    }
    
    public List<Result> findResultByUserId(int userID) throws SQLException {
        List<Result> ret = new ArrayList<>();
        this.findByUserId.setInt(1, userID);
        ResultSet rs = this.findByUserId.executeQuery();

        while (rs.next()) {
            ret.add(makeOneResult(rs));
        }
        rs.close();
        return ret;
    }
    
    private Result makeOneResult(ResultSet rs) throws SQLException {
        String userName = rs.getString("userName");
        String topic = rs.getString("topic");
        int difficulty = rs.getInt("difficulty");
        int result = rs.getInt("result");
        int time = rs.getInt("time");
        String prize = rs.getString("prize");
        
        Result result1 = new Result(userName, topic, difficulty, result, time, prize); 
        return result1;
    }
}
