/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author horvathpatricia
 */
public class TopicsController implements Initializable {

    @FXML
    private AnchorPane topicAnchorPane;
    @FXML
    private Button dataOut;
    @FXML
    private Pane beginPane;
    @FXML
    private Pane quitPane;
    @FXML
    private Pane errorPane;
    @FXML
    private Button buttonQuit;
    @FXML
    private Button buttonNoQuit;
    @FXML
    private Button logOutButton;
    @FXML
    private Label firstErrorLabel;
    Connection conn;

    DBConnection dbconnection;
    
    WordDAO worddao;
    LearnDAO learndao;
    TopicDAO topicdao;
    
    private int userId;
    @FXML
    private Label secondErrorLabel;
    @FXML
    private Button buttonRight;
    @FXML
    private ImageView topLeftIma;
    @FXML
    private ImageView middleLeftIma;
    @FXML
    private ImageView bottomLeftIma;
    @FXML
    private ImageView topRightIma;
    @FXML
    private ImageView middleRightIma;
    @FXML
    private ImageView bottomRightIma;
    @FXML
    private Label topLeftLabel;
    @FXML
    private Label middleLeftLabel;
    @FXML
    private Label bottomLeftLabel;
    @FXML
    private Label topRightLabel;
    @FXML
    private Label middleRightLabel;
    @FXML
    private Label bottomRightLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            conn = DBConnection.getInstance();
            System.out.println("Adatbáziskapcsolat létrehozva.");
            worddao = new WordDAO(conn);
            learndao = new LearnDAO(conn);
            topicdao = new TopicDAO(conn);
            List<Topic> topic = topicdao.findAllTopic();
//            tool1.setText("A gomb megnyomásával a(z) " + t.get(0).getTopic() + " témakörben tanulhat.");
            //topLeft.setStyle(topLeft.getStyle() + ";-fx-background-color:" + t.get(0).getColour());
        //    topLeft.getStyleClass().add(t.get(0).getColour());
            //topLeftLabel.setText(t.get(0).getTopic());
            
            Tooltip tooltip0 = new Tooltip(topic.get(0).getTopic());
            tooltip0.setStyle("-fx-font-size: 24px; fx-position: absolute; top: 100%; left: 50%;");
            Tooltip tooltip1 = new Tooltip(topic.get(1).getTopic());
            tooltip1.setStyle("-fx-font-size: 24px; fx-position: absolute;");
            Tooltip tooltip2 = new Tooltip(topic.get(2).getTopic());
            tooltip2.setStyle("-fx-font-size: 24px; fx-position: absolute;");
            Tooltip tooltip3 = new Tooltip(topic.get(3).getTopic());
            tooltip3.setStyle("-fx-font-size: 24px; fx-position: absolute;");
            Tooltip tooltip4 = new Tooltip(topic.get(4).getTopic());
            tooltip4.setStyle("-fx-font-size: 24px; fx-position: absolute;");
            Tooltip tooltip5 = new Tooltip(topic.get(5).getTopic());
            tooltip5.setStyle("-fx-font-size: 24px; fx-position: absolute;");
            
            try {
                FileInputStream fis = new FileInputStream("topics_images/" + topic.get(0).getImageName());
                topLeftIma.setImage(new Image(fis));
            } catch (FileNotFoundException ex) {
                // TODO dobjon fel egy figyelmeztetest vagy toltson be egy alapertelmezett kepet
                
            }
            Tooltip.install(topLeftIma, tooltip0);
            //topRightLabel.setText(t.get(1).getTopic());
            try {
                FileInputStream fis = new FileInputStream("topics_images/" + topic.get(1).getImageName());
                topRightIma.setImage(new Image(fis));
            } catch (FileNotFoundException ex) {
                // TODO dobjon fel egy figyelmeztetest vagy toltson be egy alapertelmezett kepet
            }
            Tooltip.install(topRightIma, tooltip1);
                //topRight.setStyle(topRight.getStyle() + ";-fx-background-color:" + t.get(1).getColour());
            //    topRight.getStyleClass().add(t.get(1).getColour());

            
           // middleLeft.setStyle(middleLeft.getStyle() + ";-fx-background-color:" + t.get(2).getColour());
        //    middleLeft.getStyleClass().add(t.get(2).getColour());
            //middleLeftLabel.setText(t.get(2).getTopic());
            try {
                FileInputStream fis = new FileInputStream("topics_images/" + topic.get(2).getImageName());
                middleLeftIma.setImage(new Image(fis));
            } catch (FileNotFoundException ex) {
                // TODO dobjon fel egy figyelmeztetest vagy toltson be egy alapertelmezett kepet
            }
            Tooltip.install(middleLeftIma, tooltip2);
            //middleRight.setStyle(middleRight.getStyle() + ";-fx-background-color:" + t.get(3).getColour());
        //    middleRight.getStyleClass().add(t.get(3).getColour());
            //middleRightLabel.setText(t.get(3).getTopic());
            try {
                FileInputStream fis = new FileInputStream("topics_images/" + topic.get(3).getImageName());
                middleRightIma.setImage(new Image(fis));
            } catch (FileNotFoundException ex) {
                // TODO dobjon fel egy figyelmeztetest vagy toltson be egy alapertelmezett kepet
            }
            Tooltip.install(middleRightIma, tooltip3);
            //bottomLeft.setStyle(bottomLeft.getStyle() + ";-fx-background-color:" + t.get(4).getColour());
        //    bottomLeft.getStyleClass().add(t.get(4).getColour());
            //bottomLeftLabel.setText(t.get(4).getTopic());
             try {
                FileInputStream fis = new FileInputStream("topics_images/" + topic.get(4).getImageName());
                bottomLeftIma.setImage(new Image(fis));
            } catch (FileNotFoundException ex) {
                // TODO dobjon fel egy figyelmeztetest vagy toltson be egy alapertelmezett kepet
            }
            Tooltip.install(bottomLeftIma, tooltip4);
            //bottomRight.setStyle(bottomRight.getStyle() + ";-fx-background-color:" + t.get(5).getColour());
        //    bottomRight.getStyleClass().add(t.get(5).getColour());
            //bottomRightLabel.setText(t.get(5).getTopic());
             try {
                FileInputStream fis = new FileInputStream("topics_images/" + topic.get(5).getImageName());
                bottomRightIma.setImage(new Image(fis));
            } catch (FileNotFoundException ex) {
                // TODO dobjon fel egy figyelmeztetest vagy toltson be egy alapertelmezett kepet
            }
            Tooltip.install(bottomRightIma, tooltip5);
        } catch (SQLException ex) {
            errorPane.setVisible(true);
            beginPane.setDisable(true);
            firstErrorLabel.setText("Nem jött létre az adatbáziskapcsolat.");
            System.out.println(""+ex);
        }
    }  
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
            

    @FXML
    private void dataOutAction(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Results.fxml"));
        AnchorPane pane = loader.load();
        ResultController controller = loader.<ResultController>getController();
        controller.setUserId(this.userId);
        topicAnchorPane.getChildren().setAll(pane);
        
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        quitPane.setVisible(true);
        beginPane.setDisable(true);
        beginPane.setOpacity(0.5);
    }

    @FXML
    private void quitAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXML_Login.fxml"));
        topicAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void noQuitAction(ActionEvent event) {
        quitPane.setVisible(false);
        beginPane.setDisable(false);
        beginPane.setOpacity(1);
    }
    
    @FXML
    private void loadRight(ActionEvent event) {
        errorPane.setVisible(false);
        beginPane.setDisable(false);
    }

    @FXML
    private void topLeftClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();
        controller.setUserId(this.userId);
        controller.setTopicId(1);
        topicAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void middleLeftClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();
        controller.setUserId(this.userId);
        controller.setTopicId(3);
        topicAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void bottomLeftClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();        
        controller.setUserId(this.userId);
        controller.setTopicId(5);
        topicAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void topRightClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();
        controller.setUserId(this.userId);
        controller.setTopicId(2);
        topicAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void middleRightClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();
        controller.setUserId(this.userId);
        controller.setTopicId(4);
        topicAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void bottomRightClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();
        controller.setUserId(this.userId);
        controller.setTopicId(6);
        topicAnchorPane.getChildren().setAll(pane);
    }
}
