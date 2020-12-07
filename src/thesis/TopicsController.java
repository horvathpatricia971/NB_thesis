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
    
    Connection conn;
    DBConnection dbconnection;
    WordDAO worddao;
    LearnDAO learndao;
    TopicDAO topicdao;
    private int userId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            conn = DBConnection.getInstance();
            System.out.println("Adatbáziskapcsolat létrehozva.");
            worddao = new WordDAO(conn);
            learndao = new LearnDAO(conn);
            topicdao = new TopicDAO(conn);
            List<Topic> topic = topicdao.findAllTopic();
            
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
                System.out.println(""+ex);
                
            }
            Tooltip.install(topLeftIma, tooltip0);
            try {
                FileInputStream fis = new FileInputStream("topics_images/" + topic.get(1).getImageName());
                topRightIma.setImage(new Image(fis));
            } catch (FileNotFoundException ex) {
                System.out.println(""+ex);
            }
            Tooltip.install(topRightIma, tooltip1);
            try {
                FileInputStream fis = new FileInputStream("topics_images/" + topic.get(2).getImageName());
                middleLeftIma.setImage(new Image(fis));
            } catch (FileNotFoundException ex) {
                System.out.println(""+ex);
            }
            Tooltip.install(middleLeftIma, tooltip2);
            try {
                FileInputStream fis = new FileInputStream("topics_images/" + topic.get(3).getImageName());
                middleRightIma.setImage(new Image(fis));
            } catch (FileNotFoundException ex) {
                System.out.println(""+ex);
            }
            Tooltip.install(middleRightIma, tooltip3);
             try {
                FileInputStream fis = new FileInputStream("topics_images/" + topic.get(4).getImageName());
                bottomLeftIma.setImage(new Image(fis));
            } catch (FileNotFoundException ex) {
                System.out.println(""+ex);
            }
            Tooltip.install(bottomLeftIma, tooltip4);
             try {
                FileInputStream fis = new FileInputStream("topics_images/" + topic.get(5).getImageName());
                bottomRightIma.setImage(new Image(fis));
            } catch (FileNotFoundException ex) {
                System.out.println(""+ex);
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
    private void dataOutAction(ActionEvent event) throws IOException, SQLException {
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
    private void topLeftClick(MouseEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();
        controller.setUserId(this.userId);
        controller.setTopicId(1);
        topicAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void middleLeftClick(MouseEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();
        controller.setUserId(this.userId);
        controller.setTopicId(3);
        topicAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void bottomLeftClick(MouseEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();        
        controller.setUserId(this.userId);
        controller.setTopicId(5);
        topicAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void topRightClick(MouseEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();
        controller.setUserId(this.userId);
        controller.setTopicId(2);
        topicAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void middleRightClick(MouseEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();
        controller.setUserId(this.userId);
        controller.setTopicId(4);
        topicAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void bottomRightClick(MouseEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Learn.fxml"));
        AnchorPane pane = loader.load();
        LearnController controller = loader.<LearnController>getController();
        controller.setUserId(this.userId);
        controller.setTopicId(6);
        topicAnchorPane.getChildren().setAll(pane);
    }
}
