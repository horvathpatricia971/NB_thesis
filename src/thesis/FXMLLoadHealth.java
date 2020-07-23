/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author horvathpatricia
 */
public class FXMLLoadHealth {
    public Pane view;
    
    public Pane getPage(String fileName){
 
    try{
        URL fileUrl = Thesis.class.getResource("/thesis/" + fileName + ".fxml");
        
        if(fileUrl == null){
            System.out.println("FXML file not found!");
        }
        
        view = new FXMLLoader().load(fileUrl);
    }catch(Exception e){
        System.out.println("Chechk FXMLLoader");
    }
    return view;
}
}
