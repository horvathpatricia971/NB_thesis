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
public class WordConnectionDAO {
    private Connection conn;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement findAll;
    private PreparedStatement findById;
    
    public WordConnectionDAO(Connection conn) throws SQLException {
        this.conn = conn;
        this.insert = conn.prepareStatement("insert into wordConnection (wordID, userID) values (?,?)");
        this.delete = conn.prepareStatement("DELETE FROM wordConnection WHERE connectionID = ?");
        this.update = conn.prepareStatement("UPDATE wordConnection SET wordID = ?, userID = ? WHERE connectionID = ?");
        this.findAll = conn.prepareStatement("SELECT * FROM wordConnection");
        this.findById = conn.prepareStatement("SELECT * FROM wordConnection WHERE connectionID = ?");
    }
    
    public void addConnection(WordConnection newConnection) throws SQLException {
        this.insert.setInt(1, newConnection.getWordID());
        this.insert.setInt(2, newConnection.getUserID());
        this.insert.executeUpdate();
    }
    
    public void deleteConnection(int connectionID) throws SQLException {
        this.delete.setInt(1, connectionID);
        this.delete.executeUpdate();
    }
    
    public void updateConnection(WordConnection wConnection) throws SQLException {
        this.update.setInt(1, wConnection.getWordID());
        this.update.setInt(2, wConnection.getUserID());
        this.update.setInt(3, wConnection.getConnectionID());
        this.update.executeUpdate();
    }
    
    public List<WordConnection> findAllWordConnection() throws SQLException {
        List<WordConnection> ret = new ArrayList<>();
        ResultSet rs = this.findAll.executeQuery();
        while (rs.next()) {
            WordConnection wordConnection = makeOneConnection(rs);
            ret.add(wordConnection);
        }
        rs.close();
        return ret;
    }
    
    public WordConnection findWordConnectionById(int wordConnectionID) throws SQLException {
        this.findById.setInt(1, wordConnectionID);
        ResultSet rs = this.findById.executeQuery();
        WordConnection ret = null;
        if (rs.next()) {
            ret = makeOneConnection(rs);
        }
        rs.close();
        return ret;
    }
    
    private WordConnection makeOneConnection(ResultSet rs) throws SQLException {
        int wordConnectionID = rs.getInt("wordConnectionID");
        int wordID = rs.getInt("wordID");
        int userID = rs.getInt("userID");
        
        WordConnection connection = new WordConnection(wordConnectionID, wordID, userID); 
        return connection;
    }
}
