
public class CapturedCreature extends Creature {
    
    private boolean bActive;

    /**
     *
     * Is a constructor containing all captured creatures fields.
     *
     * @param (bActive) the boolean value of captured creatures's assigned active status 
     * @param (nImageID) the integer value of captured creatures's assigned image ID
     * @param (strCreatureNam
     * e) the String value of captured creatures's assigned name
     * @param (cFamily) the character value of captured creatures's assigned family
     * @param (strType) the String value of captured creatures's assigned Type
     * @param (nLevel) the integer value of captured creatures's assigned evolution level
     * 
     *   
     */ 

    public CapturedCreature(Creature CCreature){
        super(CCreature.getImageID(), CCreature.getCreatureName(), CCreature.getFamily(), CCreature.getType(), CCreature.getLevel());
        this.bActive = false;
    }

      /**
     *
     * Sets a creature's active status to true (if active) or false (not active).
     *
     * @param (bActive) the boolean value of creature's assigned active status
     *   
     */ 
    public void setActiveCreature(boolean bActive) { 
        this.bActive = bActive;
    }

      /**
     *
     * Gets a creature's active status and returns if it is true (active) or false (not active).
     *
     * @param (bActive) the boolean value of creature's assigned active status
     *   
     */ 
    public boolean getActiveCreature() { 
        return bActive;
    }

    
    // /**
    //  *
    //  * Copies the initial information from CMasterInventory to create a new creature instance in aCapturedCreatures 
    //  *
    //  * @return (CNewCreature), the new creature instance
    //  *   
    //  */ 
    // public CapturedCreature copyCreatureInfo(Creature CCreature) //can be used to catch creatures/add creatures to aCapturedCreatures
    // {

    //   CapturedCreature CNewCreature = new CapturedCreature(CCreature);
      
    //   return CNewCreature;
    // }
}
