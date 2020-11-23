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
public class User {
    private int userID;
    private String userName;
    private String gender; 
    private int age;
    private String education;
    private String desease;
    private String hearing;
    private String seeing;
    
    public User(int UserID, String UserName, String Gender, int Age, String Education, String Desease, String Hearing, String Seeing){
        this.userID = UserID;
        this.userName = UserName;
        this.gender = Gender;
        this.age = Age;
        this.education = Education;
        this.desease = Desease;
        this.hearing = Hearing;
        this.seeing = Seeing;
    }
    
    public int getUserID(){
        return userID;
    }
    
    public void setUserID(int UserId){
        this.userID = UserId;
    }
    
    public String getUsername(){
        return userName;
    }
  
    public void setUsername(String UserName){
        this.userName = UserName;
    }
    
    public String getGender(){
        return gender;
    }
    
    public void setGender(String Gender){
        this.gender = Gender;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setAge(int Age){
        this.age = Age;
    }
        
    public String getEducation(){
        return education;
    }
    
    public void setEducation(String Education){
        this.education = Education;
    }
        
    public String getDesease(){
        return desease;
    }
    
    public void setDesease(String Desease){
        this.desease = Desease;
    }
    
    public String getHearing(){
        return hearing;
    }
    
    public void setHearing(String Hearing){
        this.hearing = Hearing;
    }
    
    public String getSeeing(){
        return seeing;
    }
    
    public void setSeeing(String Seeing){
        this.seeing = Seeing;
    }
}   
