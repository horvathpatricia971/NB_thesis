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
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author horvathpatricia
 */
public class WordDAO {
    private Connection conn;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement findAll;
    private PreparedStatement findById;
    private PreparedStatement findByTopicID;
    
    public WordDAO(Connection conn) throws SQLException {
        this.conn = conn;
        // TODO: adatbázis és program legyen azonos:
        this.insert = conn.prepareStatement("insert into word (wordInHun, wordInEng, wordClass, image, audio, sentenceHun1, sentenceEng1, sentenceHun2, sentenceEng2, topicID) values (?,?,?,?,?,?,?,?,?,?)");
        this.delete = conn.prepareStatement("DELETE FROM word WHERE wordID = ?");
        this.update = conn.prepareStatement("UPDATE word SET wordInHun = ?, wordInEng = ?, wordClass = ?, image = ?, audio = ?, sentenceHun1 = ?, sentenceEng1 = ?, sentenceHun2 = ?, sentenceEng2 = ?, topicID = ?");
        this.findAll = conn.prepareStatement("SELECT * FROM word");
        this.findById = conn.prepareStatement("SELECT * FROM word WHERE wordID = ?");
        this.findByTopicID = conn.prepareStatement("SELECT * FROM word WHERE topicID = ?");
    }
    
    public void addWord(Word newWord) throws SQLException {
        this.insert.setString(1, newWord.getWord());
        this.insert.setString(2, newWord.getWordInEng());
        this.insert.setString(3, newWord.getWordClass());
        this.insert.setBlob(4, newWord.getImage());
        this.insert.setBlob(5, newWord.getAudio());
        this.insert.setString(6, newWord.getSentenceHun1());
        this.insert.setString(7, newWord.getSentenceEng1());
        this.insert.setString(8, newWord.getSentenceHun2());
        this.insert.setString(9, newWord.getSentenceEng2());
        this.insert.setInt(10, newWord.getTopicID());
        this.insert.executeUpdate();
        
    }
    
    public void deleteTopic(int wordID) throws SQLException {
        this.delete.setInt(1, wordID);
        this.delete.executeUpdate();
    }
    
    public void updateWord(Word word) throws SQLException {
        this.update.setString(1, word.getWord());
        this.update.setString(2, word.getWordInEng());
        this.update.setString(3, word.getWordClass());
        this.update.setBlob(4, word.getImage());
        this.update.setBlob(5, word.getAudio());
        this.update.setString(6, word.getSentenceHun1());
        this.update.setString(7, word.getSentenceEng1());
        this.update.setString(8, word.getSentenceHun2());
        this.update.setString(9, word.getSentenceEng2());
        this.update.setInt(10, word.getTopicID());
    }
    
    public List<Word> findAllWord() throws SQLException {
        List<Word> ret = new ArrayList<>();
        ResultSet rs = this.findAll.executeQuery();
        while (rs.next()) {
            Word word = makeOneWord(rs);
            ret.add(word);
        }
        rs.close();
        return ret;
    }
    
    public Word findWordById(int wordID) throws SQLException {
        this.findById.setInt(1, wordID);
        ResultSet rs = this.findById.executeQuery();
        Word ret = null;
        if (rs.next()) {
            ret = makeOneWord(rs);
        }
        rs.close();
        return ret;
    }
    
    private Word makeOneWord(ResultSet rs) throws SQLException {
        int wordID = rs.getInt("wordID");
        String word = rs.getString("wordInHun");
        String wordInEng = rs.getString("wordInEng");
        String wordClass = rs.getString("wordClass");
        SerialBlob image = (SerialBlob) rs.getBlob("image");
        SerialBlob audio = (SerialBlob) rs.getBlob("audio");
        String sentenceHun1 = rs.getString("sentenceHun1");
        String sentenceEng1 = rs.getString("sentenceEng1");
        String sentenceHun2 = rs.getString("sentenceHun2");
        String sentenceEng2 = rs.getString("sentenceEng2");
        int topicID = rs.getInt("topicID");
        
        Word word1 = new Word(wordID, word, wordInEng, wordClass, image, audio, sentenceHun1, sentenceEng1, sentenceHun2, sentenceEng2, topicID); 
        return word1;
    }
    
    public List<Word> findByTopicID(int TopicID)throws SQLException{
        List<Word> ret = new ArrayList<>();
        this.findByTopicID.setInt(1, TopicID);
        ResultSet rs = this.findByTopicID.executeQuery();
        while (rs.next()) {
            Word word = makeOneWord(rs);
            ret.add(word);
        }
        rs.close();
        return ret;
    }
}

