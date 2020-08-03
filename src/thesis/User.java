/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author horvathpatricia
 */
public class User {
    private final SimpleStringProperty username;
    private final SimpleStringProperty gender; 
    private final SimpleIntegerProperty age;
    private final SimpleIntegerProperty id;
    private final SimpleIntegerProperty excercisesNumber;
    private final SimpleIntegerProperty userResult;
    
    //result-float
    //number of excercises
    
    public User(){
        this.username = new SimpleStringProperty("");
        this.gender = new SimpleStringProperty("");
        this.age = new SimpleIntegerProperty(0);
        this.id = new SimpleIntegerProperty(0);
        this.excercisesNumber = new SimpleIntegerProperty(0);
        this.userResult = new SimpleIntegerProperty(0);
    }
    
    public User(String uName, String gend, int ages, int identity, int excercises, int eredmeny){
        this.username = new SimpleStringProperty(uName);
        this.gender = new SimpleStringProperty(gend);
        this.age = new SimpleIntegerProperty(ages);
        this.id = new SimpleIntegerProperty(identity);
        this.excercisesNumber = new SimpleIntegerProperty(excercises);
        this.userResult = new SimpleIntegerProperty(eredmeny);
    }
    
    public String getUsername(){
	return username.get();
    }

    public void setUsername(String uName){
	username.set(uName);
    }
    
    public String getGender(){
	return gender.get();
    }
    
    public void setGender(String gend){
        gender.set(gend);
    }
    
    public int getAge(){
        return age.get();
    }
    
    public void setAge(int ages){
        age.set(ages);
    }
    
    public int getId(){
        return id.get();
    }
    
    public void setId(int identity){
        id.set(identity);
    }
    
    public int getExcercisesNumber(){
        return excercisesNumber.get();
    }
    
    public void setExcercisesNumber(int excercises){
        id.set(excercises);
    }
    
    public int getUserResult(){
        return userResult.get();
    }
    
    public void setUserResult(int userresult){
        userResult.set(userresult);
    }
}
