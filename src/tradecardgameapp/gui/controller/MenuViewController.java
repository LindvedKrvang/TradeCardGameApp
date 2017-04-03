/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradecardgameapp.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rasmus
 */
public class MenuViewController implements Initializable
{
    @FXML
    private Button btnDuel;
    
    static Stage primStage;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    }    

    @FXML
    private void handleDuelButton(ActionEvent event) throws IOException
    {
        primStage = (Stage) btnDuel.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tradecardgameapp/gui/view/MainView.fxml"));
        Parent root = loader.load();
        
        MainController mainController = loader.getController();
        
        Scene scene = new Scene(loader.getRoot());
        primStage.setScene(scene);
        primStage.setTitle("Duel");
        mainController.btnNewGame.fireEvent(event);
    }
}
