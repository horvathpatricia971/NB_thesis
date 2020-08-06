/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.io.IOException;
import java.net.URL;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void loadThird(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML_Word_First.fxml"));
        secondAnchorPane.getChildren().setAll(pane);
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
    
}
