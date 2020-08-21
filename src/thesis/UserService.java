/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;
 

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author horvathpatricia
 */


public class UserService {
    DB db = new DB();
    
   
    /*public ObservableList<User> userService(){
        ObservableList<User> result = FXCollections.observableArrayList();
        result = (ObservableList<User>) db.getAllUsers();
        return result;
    }
    
    public ObservableList<User> getUserList(){
        
        ObservableList<User> result = FXCollections.observableArrayList(db.getAllUsers());
        return result;
    }*/
    
/*    public ObservableList<User> userService(){
        return this.getUserList(getList());
    }
    
    public ArrayList<User> getList(){
        return db.getAllUsers();
    }
    
    public ObservableList<User> getUserList(ArrayList<User> list){
        return FXCollections.observableArrayList(list);
    }*/
    
}