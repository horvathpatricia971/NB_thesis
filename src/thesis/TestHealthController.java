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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author horvathpatricia
 */
public class TestHealthController implements Initializable {

    @FXML
    private AnchorPane testAnchor;
    @FXML
    private Pane firstPane;
    @FXML
    private Pane secondPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void beginAction(ActionEvent event) {
        firstPane.setVisible(true);
    }

    @FXML
    private void firstButtonAction(ActionEvent event) {
        firstPane.setVisible(false);
        secondPane.setVisible(true);
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML_Topics.fxml"));
        testAnchor.getChildren().setAll(pane);
    }
    
}
