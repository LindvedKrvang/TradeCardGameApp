/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradecardgameapp.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tradecardgameapp.be.Player;

/**
 *
 * @author Rasmus
 */
public class TradeCardGameModel
{
    private final ObservableList<Player> list;
    
    
    private static TradeCardGameModel instance = null;
    
    public TradeCardGameModel()
    {
        list = FXCollections.observableArrayList();
    }
    
    public static TradeCardGameModel getInstance()
    {
        if(instance == null)
        {
            instance = new TradeCardGameModel();
        }
        return instance;
    }
    
    public ObservableList<Player> getPlayers()
    {
        return list;
    }
    
    /**
     * Goes through the list and find the name belonging to the id.
     * @param id
     * @return 
     */
    public String getName(int id)
    {
        String name = "Name not found..";
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getId() == id)
            {
                name = list.get(i).getName();
                return name;
            }
        }
        return name;
    }
    
    /**
     * Goes trough the list and returns the health of the player with that id.
     * @param id
     * @return 
     */
    public String getHealth(int id)
    {
        String health = "";
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getId() == id)
            {
                health = list.get(i).getHealth() + "";
                return health;
            }
        }
        return health;
    }
    
    /**
     * Goes through the list and returns the damage of the player with the same id.
     * @param id
     * @return 
     */
    public String getDamage(int id)
    {
        String damage = "";
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getId() == id)
            {
                damage = list.get(i).getDamage()+ "";
                return damage;
            }
        }
        return damage;
    }
}
