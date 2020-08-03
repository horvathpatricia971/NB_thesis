
package thesis;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class DB {
    final String URL = "jdbc:derby:sampleDataBase;create=true";
    final String Username = "";
    final String Password = "";
    
    Connection conn = null;
    Statement createStatement = null;
    DatabaseMetaData dbmb = null;
    
    
    public DB(){
        
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("A híd létrejött");
        } catch (SQLException ex) {
            
            System.out.println("Valami nem jó a connection létrehozásakor");
            System.out.println(""+ex);
        }
        
        if(conn != null){
            try {
                createStatement = conn.createStatement();
                System.out.println("A createStatement létrejött");
            } catch (SQLException ex) {
               System.out.println("Valami nem jó a createStatement létrehozásakor.");
               System.out.println(""+ex);
            }
        }
    
        try {
            dbmb = conn.getMetaData();
            System.out.println("Az adatbázis létrejött");
        } catch (SQLException ex) {
            System.out.println("Valami nem jó az adatbázis létrehozásakor.");
            System.out.println(""+ex);
        }
        //User tábla létrehozása
        try {
            ResultSet rs = dbmb.getTables(null, "APP", "USERS", null);
            if (!rs.next()) {
                createStatement.execute("create table users (username varchar(20), gender varchar(5), age int, id int primary key, excercisesNumber int, userResult int)");
                System.out.println("A tábla létrejött");
            }
        } catch (SQLException ex) {
            System.out.println("Valami nem jó az adattáblák létrehozásánál");
            System.out.println(""+ex);
        }
        
        
        //Excercises tábla létrehozása
        /*try {
            ResultSet rs = dbmb.getTables(null, "APP", "EXERCISES", null);
            if (!rs.next()) {
                createStatement.execute("create table exercises (exerciseId int primary key, topic varchar(20), numberOfWords int, pictures boolean, sound boolean, difficulty int)");
                System.out.println("Az excercises tábla létrejött");
            }
        } catch (SQLException ex) {
            System.out.println("Valami nem jó az excercises adattábla létrehozásánál");
            System.out.println(""+ex);
        }*/
        
        //A Words tábla létrehozása
        
        /*try {
            ResultSet rs = dbmb.getTables(null, "APP", "WORDS", null);
            if (!rs.next()) {
                createStatement.execute("create table words (serialNumber int primary key, word varchar(20), wordClass varchar(20), exerciseId int references exercises(exerciseId))");
                System.out.println("Az excercises tábla létrejött");
            }
        } catch (SQLException ex) {
            System.out.println("Valami nem jó az excercises adattábla létrehozásánál");
            System.out.println(""+ex);
        }*/
        
        
        //A Tests tábla létrehozása
       /* try {
            ResultSet rs = dbmb.getTables(null, "APP", "TESTS", null);
            if (!rs.next()) {
                createStatement.execute("create table tests (testId int primary key, userId int references users(id), exerciseId int references exercises(exerciseId), testResult int, startTime time, endTime time)");
                System.out.println("A tábla létrejött");
            }
        } catch (SQLException ex) {
            System.out.println("Valami nem jó az adattáblák létrehozásánál");
            System.out.println(""+ex);
        }*/
       
       
       //Az Answers tábla létrehozása
       /*try {
            ResultSet rs = dbmb.getTables(null, "APP", "ANSWERS", null);
            if (!rs.next()) {
                createStatement.execute("create table answers (testId int references tests(testId), answerNumber int primary key, answer varchar(20), right boolean)");
                System.out.println("A tábla létrejött");
            }
        } catch (SQLException ex) {
            System.out.println("Valami nem jó az adattáblák létrehozásánál");
            System.out.println(""+ex);
        }*/
        
    }   
    
    public void addUser(User user){
        try {
            
            String sql = "insert into users (username, gender, age, id, excercisesNumber, userResult) values (?,?,?,?,?,?)";
            
            PreparedStatement preparedStatement = conn.prepareCall(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getGender());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setInt(4, user.getId());
        //    preparedStatement.setInt(5, (int) user.getResult());
            preparedStatement.setInt(5, user.getExcercisesNumber());
            preparedStatement.setInt(6, user.getUserResult());
            preparedStatement.execute(); //ezt irtam
            System.out.println("User hozzaadva.");
        } catch (SQLException ex) {
            System.out.println("Valami gond van a userek hozzáadásakor.");
            System.out.println(""+ex);
        }
        
    }
    
    public ArrayList<User> getAllUsers(){
        String sql = "select * from users";
        ArrayList<User> users = null;
        int i = 0;
        try {
            ResultSet rs = createStatement.executeQuery(sql);
            users = new ArrayList<>();
            if (!rs.next()) {
                User actualUser = new User(rs.getString("username"), rs.getString("gender"), rs.getInt("age"), rs.getInt("id"),rs.getInt("excercisesNumber"),rs.getInt("userResult"));
                users.add(actualUser);
                System.out.println("if");
            }
            
            while(rs.next()){
                System.out.println(rs.getString("username") + ", " + rs.getString("gender") + ", " + rs.getInt("age") + ", " + rs.getInt("id")+ ", " + rs.getInt("excercisesNumber")+ ", " + rs.getInt("userResult"));
                i++;
               
                System.out.println(i + ".");
            }
        } catch (SQLException ex) {
            System.out.println("Valami gond van a userek kiolvasásakor.");
            System.out.println(""+ex);
        }
        return users;
    }
    
    
    
}
