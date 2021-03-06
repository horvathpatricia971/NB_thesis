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
public class WordDAO {
    private Connection conn;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement findAll;
    private PreparedStatement findById;
    private PreparedStatement findByTopicID;
    private PreparedStatement findRandom10WordsByTopicID;
    private PreparedStatement findWrongWordByTestAttempt;
    
    public WordDAO(Connection conn) throws SQLException {
        this.conn = conn;
        // TODO: adatbázis és program legyen azonos:
        this.insert = conn.prepareStatement("insert into word (wordInHun, wordInEng, wordClass, image, audio, slowAudio, sentenceHun1, sentenceEng1, sentenceHun2, sentenceEng2, topicID) values (?,?,?,?,?,?,?,?,?,?)");
        this.delete = conn.prepareStatement("DELETE FROM word WHERE wordID = ?");
        this.update = conn.prepareStatement("UPDATE word SET wordInHun = ?, wordInEng = ?, wordClass = ?, image = ?, audio = ?, slowAudio = ?, sentenceHun1 = ?, sentenceEng1 = ?, sentenceHun2 = ?, sentenceEng2 = ?, topicID = ? WHERE wordID = ?");
        this.findAll = conn.prepareStatement("SELECT * FROM word");
        this.findById = conn.prepareStatement("SELECT * FROM word WHERE wordID = ?");
        this.findByTopicID = conn.prepareStatement("SELECT * FROM word WHERE topicID = ?");
        this.findRandom10WordsByTopicID = conn.prepareStatement("SELECT * FROM word WHERE topicID = ? ORDER BY rand() LIMIT 10");
        this.findWrongWordByTestAttempt = conn.prepareStatement(
                "SELECT * FROM language_db.word " +
                    "JOIN wordTestQuestion ON wordTestQuestion.wordID = word.wordID " +
                    "JOIN testQuestion ON testQuestion.testQuestionID = wordTestQuestion.testQuestionID " +
                    "JOIN testAnswer ON testAnswer.testQuestionID = testQuestion.testQuestionID " +
                    "WHERE testAnswer.isRight = 0 AND testAnswer.testAttemptID = ?");
    }
    
    public void addWord(Word newWord) throws SQLException {
        this.insert.setString(1, newWord.getWord());
        this.insert.setString(2, newWord.getWordInEng());
        this.insert.setString(3, newWord.getWordClass());
        this.insert.setString(4, newWord.getImage());
        this.insert.setString(5, newWord.getAudio());
        this.insert.setString(6, newWord.getSlowAudio());
        this.insert.setString(7, newWord.getSentenceHun1());
        this.insert.setString(8, newWord.getSentenceEng1());
        this.insert.setString(9, newWord.getSentenceHun2());
        this.insert.setString(10, newWord.getSentenceEng2());
        this.insert.setInt(11, newWord.getTopicID());
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
        this.update.setString(4, word.getImage());
        this.update.setString(5, word.getAudio());
        this.update.setString(6, word.getSlowAudio());
        this.update.setString(7, word.getSentenceHun1());
        this.update.setString(8, word.getSentenceEng1());
        this.update.setString(9, word.getSentenceHun2());
        this.update.setString(10, word.getSentenceEng2());
        this.update.setInt(11, word.getTopicID());
        this.update.setInt(12, word.getWordID());
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
        String image = rs.getString("image");
        String audio = rs.getString("audio");
        String slowAudio = rs.getString("slowAudio");
        String sentenceHun1 = rs.getString("sentenceHun1");
        String sentenceEng1 = rs.getString("sentenceEng1");
        String sentenceHun2 = rs.getString("sentenceHun2");
        String sentenceEng2 = rs.getString("sentenceEng2");
        int topicID = rs.getInt("topicID");
        
        Word word1 = new Word(wordID, word, wordInEng, wordClass, image, audio, slowAudio, sentenceHun1, sentenceEng1, sentenceHun2, sentenceEng2, topicID); 
        return word1;
    }
    
    public List<Word> findWordsByTopicID(int TopicID)throws SQLException{
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

    public List<Word> findRandom10WordsByTopicId(int topicId) throws SQLException {
        List<Word> ret = new ArrayList<>();
        this.findRandom10WordsByTopicID.setInt(1, topicId);
        ResultSet rs = this.findRandom10WordsByTopicID.executeQuery();
        while (rs.next()) {
            Word word = makeOneWord(rs);
            ret.add(word);
        }
        rs.close();
        return ret;
    }
    
    public List<Word> findWrongWordByTestAttempt(int testAttemptId)throws SQLException {
        List<Word> ret = new ArrayList<>();
        this.findWrongWordByTestAttempt.setInt(1, testAttemptId);
        ResultSet rs = this.findWrongWordByTestAttempt.executeQuery();
        while (rs.next()) {
            ret.add(makeOneWord(rs));
        }
        rs.close();
        return ret;
    }
}

