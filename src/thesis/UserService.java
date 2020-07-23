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
    
    public final ObservableList<User> result = FXCollections.observableArrayList();

    public ArrayList<User> userService(){
        
        result = db.getAllUsers();
        return result;
    }
    
     
}
