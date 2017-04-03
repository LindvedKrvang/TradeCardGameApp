/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradecardgameapp.bll;

import java.util.List;
import tradecardgameapp.be.Player;

/**
 *
 * @author Rasmus
 */
public class TradeCardGameManager
{
    private static TradeCardGameManager instance = null;
    
    public TradeCardGameManager()
    {
    }
    
    public static TradeCardGameManager getInstance()
    {
        if(instance == null)
        {
            instance = new TradeCardGameManager();
        }
        return instance;
    }
    
    /**
     * Search the list for the player with the same Id.
     * When found, add or take one health to that player.
     * @param id 
     * @param upDown 
     * @param list 
     */
    public void addHealth(int id, boolean upDown, List<Player> list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getId() == id)
            {
                if(upDown)
                {
                    list.get(i).addHealth();
                    return;
                }
                else
                {
                    list.get(i).takeHealth();
                    return;
                }                
            }
        }
    }
    
    /**
     * Search the list for a player with that id.
     * When found, add or take one damage.
     * @param id of the player.
     * @param upDown checks if should or substract.
     * @param list 
     */
    public void addDamage(int id, boolean upDown, List<Player> list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getId() == id)
            {
                if(upDown)
                {
                    list.get(i).addDamage();
                    return;
                }
                else
                {
                    list.get(i).healDamage();
                    return;
                }                
            }
        }
    }
    
    /**
     * Checks if the damage is equal or bigger than the health of the player.
     * @param id
     * @param list
     * @return 
     */
    public boolean checkDead(int id, List<Player> list)
    {
        boolean dead = false;
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getId() == id)
            {
                if(list.get(i).getDamage() >= list.get(i).getHealth())
                {
                    dead = true;
                    return dead;
                }
            }
        }
        return dead;
    }
    
    /**
     * Return the name of the player with a "is defeated!" message.
     * @param id
     * @param list
     * @return 
     */
    public String getDefeatedName(int id, List<Player> list)
    {
        String defeated = "";
            for(int i = 0; i < list.size(); i++)
            {
                if(list.get(i).getId() == id)
                {
                    defeated = list.get(i).getName() + " is defeated!";
                    return  defeated;
                }
            }
        return defeated;
    }
}
