/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author horvathpatricia
 */
public class TopicsController implements Initializable {

    @FXML
    private AnchorPane secondAnchorPane;
    @FXML
    private Button dataOut;
    @FXML
    private Pane beginPane;
    @FXML
    private Pane quitPane;
    @FXML
    private Button buttonQuit;
    @FXML
    private Button buttonNoQuit;
    
    
    Connection conn;

    WordDAO worddao;
    LearnDAO learndao;
    DBConnection dbconnection;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
        //    dbconnection.getInstance();
            conn = DBConnection.getInstance();
            System.out.println("A híd létrejött");
            worddao = new WordDAO(conn);
            learndao = new LearnDAO(conn);
        } catch (SQLException ex) {
            
            System.out.println("Valami nem jó a connection létrehozásakor");
            System.out.println(""+ex);
        }
    }    


    @FXML
    private void dataOutAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML_Leader_Board.fxml"));
        secondAnchorPane.getChildren().setAll(pane);
       
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        quitPane.setVisible(true);
        beginPane.setDisable(true);
        beginPane.setOpacity(0.2);
    }

    @FXML
    private void quitAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML_Login.fxml"));
        secondAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void noQuitAction(ActionEvent event) {
        quitPane.setVisible(false);
        beginPane.setDisable(false);
        beginPane.setOpacity(1);
    }

    @FXML
    private void loadHealth(ActionEvent event) throws IOException, SQLException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML_Word_First.fxml"));
        secondAnchorPane.getChildren().setAll(pane);
        learndao.addLearn(new Learn(1, new java.sql.Date(System.currentTimeMillis()), null, 1, 1));
    }

    @FXML
    private void loadNature(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML_Nature.fxml"));
        secondAnchorPane.getChildren().setAll(pane);
    }
    @FXML
    private void loadFood(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML_Learn.fxml"));
        secondAnchorPane.getChildren().setAll(pane);
    }
}
