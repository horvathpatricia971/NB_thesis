/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

/**
 *
 * @author horvathpatricia
 */
public class WordConnection {
    private int connectionID;
    private int wordID;
    private int userID;
    
    public WordConnection(int ConnectionID, int WordID, int UserID){
        this.connectionID = ConnectionID;
        this.wordID = WordID;
        this.userID = UserID;
    }
    
    public int getConnectionID(){
        return connectionID;
    }
    
    public void setConnectionID(int ConnectionID){
        this.connectionID = ConnectionID;
    }
    
    public int getWordID(){
        return wordID;
    }
    
    public void setWordID(int WordID){
        this.wordID = WordID;
    }
    
    public int getUserID(){
        return userID;
    }
    
    public void setUserID(int UserId){
        this.userID = UserId;
    }
}
