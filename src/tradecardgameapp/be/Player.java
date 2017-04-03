/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradecardgameapp.be;

/**
 *
 * @author Rasmus
 */
public class Player
{
    private final int ID;
    
    private String name;
    private int health;
    private int damage;
    
    
    public Player(int id, String name, int health)
    {
        this.ID = id;
        this.name = name;
        this.health = health;
        damage = 0;        
    }
    
    /**
     * Gets the ID of the player.
     * @return the ID as an int.
     */
    public int getId()
    {
        return ID;
    }

    /**
     * Get the name of the player.
     * @return the name as String.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Get the health if the player.
     * @return the health as an int.
     */
    public int getHealth()
    {
        return health;
    }
    
    /**
     * Set the health of the player.
     * @param health as an int.
     */
    public void setHealth(int health)
    {
        this.health = health;
    }
    
    /**
     * Get the damage of the player.
     * @return the damage as an int.
     */
    public int getDamage()
    {
        return damage;
    }
    
    /**
     * Set the damage of the player.
     * @param damage as an int.
     */
    public void setDamage(int damage)
    {
        this.damage = damage;
    }    
    
    /**
     * Adds one damage to the player.
     */
    public void addDamage()
    {
        damage++;
    }
    
    /**
     * Heals one damage from the player.
     */
    public void healDamage()
    {
        if(damage > 0)
        {
            damage--;
        }
    }
    
    /**
     * Give the player one plus health;
     */
    public void addHealth()
    {
        health++;
    }
    
    /**
     * Take one health from the player.
     */
    public void takeHealth()
    {
        health--;
    }
}
