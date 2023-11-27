public class Enemy extends Creature {
    
    private double nHealth;

    
    /**
     *
     * Is a constructor containing all enemy fields.
     *
     * @param (nHealth) the double value of enemy's assigned health 
     * @param (nImageID) the integer value of enemy's assigned image ID
     * @param (strCreatureNam
     * e) the String value of enemy's assigned name
     * @param (cFamily) the character value of enemy's assigned family
     * @param (strType) the String value of enemy's assigned Type
     * @param (nLevel) the integer value of enemy's assigned evolution level
     * 
     *   
     */ 

     public Enemy(Creature CCreature) {
        super(CCreature.getImageID(), CCreature.getCreatureName(), CCreature.getFamily(), CCreature.getType(), CCreature.getLevel());
        this.nHealth = 50;
    }

    /**
     *
     * Sets a creature's health.
     *
     * @param (nHealth) the double value of creature's assigned health 
     *   
     */ 
    public void setHealth(double nHealth){
        this.nHealth = nHealth;
    }
    
     /**
     *
     * Gets a creature's health.
     *
     * @return (nHealth), the double value of creature's assigned health 
     *   
     */
    public double getHealth(){
        return nHealth;
    }

    // /**
    //  *
    //  * Similar to copyCreatureInfo(), copies the initial information from CMasterInventory to create a new enemy instance 
    //  *
    //  * @return (CNewEnemy), the new enemy instance
    //  *   
    //  */ 
    // public Enemy createEnemy(Creature CCreature){

    //     Enemy CNewEnemy = new Enemy(CCreature);
       
    //     return CNewEnemy;
    // }
}
