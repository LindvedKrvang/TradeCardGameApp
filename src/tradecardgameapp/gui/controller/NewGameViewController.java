/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradecardgameapp.gui.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tradecardgameapp.be.Player;
import tradecardgameapp.gui.model.TradeCardGameModel;

/**
 * FXML Controller class
 *
 * @author Rasmus
 */
public class NewGameViewController implements Initializable
{

    @FXML
    private TextField txtOneName;
    @FXML
    private TextField txtOneHealth;
    @FXML
    private TextField txtTwoName;
    @FXML
    private TextField txtTwoHealth;
    
    private MainController mController;
    private TradeCardGameModel tcgModel;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        mController = MainController.getInstance();
        tcgModel = TradeCardGameModel.getInstance();
    }    

    @FXML
    private void handleBeginButton()
    {
        if(checkInfo())
        {
            List<Player> list = tcgModel.getPlayers();
            list.clear();
            Player playerOne = new Player(1, txtOneName.getText(), Integer.parseInt(txtOneHealth.getText()));
            list.add(playerOne);
            Player playerTwo = new Player(2, txtTwoName.getText(), Integer.parseInt(txtTwoHealth.getText()));
            list.add(playerTwo);
        
            mController.updateStartData();
        
            Stage stage = (Stage) txtOneHealth.getScene().getWindow();
            stage.close();
        }
        else
        {
            showWrongInfoDialog();
        }        
    }
    
    /**
     * Checks if the info entered is valid.
     * @return 
     */
    private boolean checkInfo()
    {
        boolean errorLess = true;
        try
        {
            Integer.parseInt(txtOneHealth.getText());
        } catch (Exception e)
        {
            System.out.println("Player one wrong health.");
            errorLess = false;
        }
        try
        {
            Integer.parseInt(txtTwoHealth.getText());
        } catch (Exception e)
        {
            System.out.println("Player two wrong health.");
            errorLess = false;
        }
        return errorLess;
    }
    
    /**
     * Shows a dialog that asks to enter valid information.
     */
    private void showWrongInfoDialog()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Wrong information");
        alert.setHeaderText("The information entered is not valid!");
        alert.setContentText("Please enter a number for the players health.");
        alert.showAndWait();
    }
}
