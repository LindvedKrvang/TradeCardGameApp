/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradecardgameapp.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tradecardgameapp.bll.TradeCardGameManager;
import tradecardgameapp.gui.model.TradeCardGameModel;

/**
 *
 * @author Rasmus
 */
public class MainController implements Initializable
{
    @FXML
    private TextField txtHealthOne;
    @FXML
    private TextField txtDamageOne;
    @FXML
    private Label lblNameOne;
    @FXML
    private TextField txtHealthTwo;
    @FXML
    private TextField txtDamageTwo;
    @FXML
    private Label lblNameTwo;
    @FXML
    public Button btnNewGame;
    
    private final int PLAYER_ONE = 1;
    private final int PLAYER_TWO = 2;
    
    private static MainController instance;
    
    private final TradeCardGameModel TCG_MODEL = TradeCardGameModel.getInstance();
    private final TradeCardGameManager TCG_MANAGER = TradeCardGameManager.getInstance(); 
    
    public static MainController getInstance()
    {
        return instance;
    }    
    
    public MainController()
    {
        instance = this;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
    }    

    @FXML
    private void handleNewGame() throws IOException
    {
        Stage primStage = (Stage) lblNameOne.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tradecardgameapp/gui/view/NewGameView.fxml"));
        Parent root = loader.load();
        
        Stage newGameStage = new Stage();
        newGameStage.setScene(new Scene(root));
        
        newGameStage.initModality(Modality.WINDOW_MODAL);
        newGameStage.initOwner(primStage);
        newGameStage.setTitle("New Game");
        
        newGameStage.show();
    }
    
    /**
     * Adds one health when clicked.
     */
    @FXML
    private void handleHealthUpButton()
    {
        TCG_MANAGER.addHealth(PLAYER_ONE, true, TCG_MODEL.getPlayers());
        txtHealthOne.setText(TCG_MODEL.getHealth(PLAYER_ONE));
    }
    
    /**
     * Remove one health when clicked.
     */
    @FXML
    private void handleHealthDownButton()
    {
        TCG_MANAGER.addHealth(PLAYER_ONE, false, TCG_MODEL.getPlayers());
        txtHealthOne.setText(TCG_MODEL.getHealth(PLAYER_ONE));
        if(TCG_MANAGER.checkDead(PLAYER_ONE, TCG_MODEL.getPlayers()))
        {
            showDefeatDialog(PLAYER_ONE);
        }
    } 
    
    /**
     * Display the names of the players. 
     */
    public void updateStartData()
    {
        //Update player one.
        lblNameOne.setText(TCG_MODEL.getName(PLAYER_ONE));
        txtHealthOne.setText(TCG_MODEL.getHealth(PLAYER_ONE));
        txtDamageOne.setText("");
        //Update player two.
        lblNameTwo.setText(TCG_MODEL.getName(PLAYER_TWO));
        txtHealthTwo.setText(TCG_MODEL.getHealth(PLAYER_TWO));
        txtDamageTwo.setText("");
    }
    
    /**
     * Heal one damage when clicked.
     */
    @FXML
    private void handleDamageDownOne()
    {
        TCG_MANAGER.addDamage(PLAYER_ONE, false, TCG_MODEL.getPlayers());
        txtDamageOne.setText(TCG_MODEL.getDamage(PLAYER_ONE));
    }
    
    /**
     * Adds one damage when clicked.
     */
    @FXML
    private void handleDamageUpOne()
    {
        TCG_MANAGER.addDamage(PLAYER_ONE, true, TCG_MODEL.getPlayers());
        txtDamageOne.setText(TCG_MODEL.getDamage(PLAYER_ONE));
        if(TCG_MANAGER.checkDead(PLAYER_ONE, TCG_MODEL.getPlayers()))
        {
            showDefeatDialog(PLAYER_ONE);
        }        
    }
    
    /**
     * Adds when health when clicked.
     */
    @FXML
    private void handleHealthUpTwo()
    {
        TCG_MANAGER.addHealth(PLAYER_TWO, true, TCG_MODEL.getPlayers());
        txtHealthTwo.setText(TCG_MODEL.getHealth(PLAYER_TWO));
    }
    
    /**
     * Removes one health when clicked.
     */
    @FXML
    private void handleHealthDownTwo()
    {
        TCG_MANAGER.addHealth(PLAYER_TWO, false, TCG_MODEL.getPlayers());
        txtHealthTwo.setText(TCG_MODEL.getHealth(PLAYER_TWO));
        if(TCG_MANAGER.checkDead(PLAYER_TWO, TCG_MODEL.getPlayers()))
        {
            showDefeatDialog(PLAYER_TWO);
        }
    }
    
    /**
     * Heals one damage when clicked.
     */
    @FXML
    private void handleDamageDownTwo()
    {
        TCG_MANAGER.addDamage(PLAYER_TWO, false, TCG_MODEL.getPlayers());
        txtDamageTwo.setText(TCG_MODEL.getDamage(PLAYER_TWO));
    }
    
    /**
     * Heals one damage when clicked.
     */
    @FXML
    private void handleDamageUpTwo()
    {
        TCG_MANAGER.addDamage(PLAYER_TWO, true, TCG_MODEL.getPlayers());
        txtDamageTwo.setText(TCG_MODEL.getDamage(PLAYER_TWO));
        if(TCG_MANAGER.checkDead(PLAYER_TWO, TCG_MODEL.getPlayers()))
        {
            showDefeatDialog(PLAYER_TWO);
        }
    }
    
    /**
     * Show a dialog stating a player has been defeated.
     * @param id 
     */
    private void showDefeatDialog(int id)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Defeated!");
        alert.setHeaderText(null);
        alert.setContentText(TCG_MANAGER.getDefeatedName(id, TCG_MODEL.getPlayers()));
        alert.showAndWait();
        try
        {
            showMenuStage();
        } catch (IOException ex)
        {
            System.out.println("Menu not found...");
        }
    }
    
    private void showMenuStage() throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tradecardgameapp/gui/view/MenuView.fxml"));
        Parent root = loader.load();
        
        MenuViewController menuViewController = loader.getController();
        
        Scene scene = new Scene(loader.getRoot());
        MenuViewController.primStage.setTitle("Menu");
        MenuViewController.primStage.setScene(scene);
    }

    @FXML
    private void handleMenuButton(ActionEvent event) throws IOException
    {
        showMenuStage();
    }
}
