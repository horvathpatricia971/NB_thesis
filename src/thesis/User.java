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
    private final SimpleStringProperty age;
    private final SimpleStringProperty id;
    private final SimpleStringProperty excercisesNumber;
    private final SimpleStringProperty userResult;
    
    //result-float
    //number of excercises
    
    public User(){
        this.username = new SimpleStringProperty("");
        this.gender = new SimpleStringProperty("");
        this.age = new SimpleStringProperty(String.valueOf(0));
        this.id = new SimpleStringProperty(String.valueOf(0));
        this.excercisesNumber = new SimpleStringProperty(String.valueOf(0));
        this.userResult = new SimpleStringProperty(String.valueOf(0));
    }
    
    public User(String uName, String gend, int ages, int identity, int excercises, int eredmeny){
        this.username = new SimpleStringProperty(uName);
        this.gender = new SimpleStringProperty(gend);
        this.age = new SimpleStringProperty(String.valueOf(ages));
        this.id = new SimpleStringProperty(String.valueOf(identity));
        this.excercisesNumber = new SimpleStringProperty(String.valueOf(excercises));
        this.userResult = new SimpleStringProperty(String.valueOf(eredmeny));
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
    
    public String getAge(){
        return age.get();
    }
    
    public void setAge(String ages){
        age.set(ages);
    }
    
    public String getId(){
        return id.get();
    }
    
    public void setId(String identity){
        id.set(identity);
    }
    
    public String getExcercisesNumber(){
        return excercisesNumber.get();
    }
    
    public void setExcercisesNumber(String excercises){
        id.set(excercises);
    }
    
    public String getUserResult(){
        return userResult.get();
    }
    
    public void setUserResult(String userresult){
        userResult.set(userresult);
    }
}
