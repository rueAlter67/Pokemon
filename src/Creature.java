import java.util.ArrayList;

public class Creature {
    
    private double nHealth;    
    private int nImageID;    
    private String strCreatureName;    
    private char cFamily;    
    private String strType;    
    private int nLevel;    
    private boolean bActive;    

    /**
     *
     * Is a constructor containing all creature fields.
     *
     * @param (nHealth) the double value of creature's assigned health 
     * @param (nImageID) the integer value of creature's assigned image ID
     * @param (strCreatureName) the String value of creature's assigned name
     * @param (cFamily) the character value of creature's assigned family
     * @param (strType) the String value of creature's assigned Type
     * @param (nLevel) the integer value of creature's assigned evolution level
     * @param (bActive) the boolean value of creature's assigned active status
     *   
     */ 
    public Creature(double nHealth, int nImageID, String strCreatureName, char cFamily, String strType, int nLevel, boolean bActive){
        this.nHealth = nHealth;
        this.nImageID = nImageID;
        this.strCreatureName = strCreatureName;
        this.cFamily = cFamily;
        this.strType = strType;
        this.nLevel = nLevel;
        this.bActive = bActive;
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

     /**
     *
     * Sets a creature's Image ID.
     * 
     * @param (nImageID) the integer value of creature's assigned image ID
     *   
     */
    public void setImageID(int nImageID){
        this.nImageID = nImageID;
    }

    /**
     *
     * Gets a creature's Image ID.
     *
     * @return (nImageID), the integer value of creature's assigned image ID
     *   
     */ 
    public int getImageID(){
        return nImageID;
    }

    /**
     *
     * Sets the creature's name.
     *
     * @param (strCreatureName) the String value of creature's assigned name
     *   
     */ 
    public void setCreatureName(String strCreatureName) { 
        this.strCreatureName = strCreatureName;           
    }

    /**
     *
     * Gets the creature's name.
     *
     * @return (strCreatureName), the String value of creature's assigned name
     *   
     */ 
    public String getCreatureName() {   
        return strCreatureName; 
    }

    /**
     *
     * Sets the creature's family character.
     *
     * @param (cFamily) the character value of creature's assigned family
     *   
     */ 
    public void setFamily(char cFamily) {
        this.cFamily = cFamily;
    }
    /**
     *
     * Gets the creature's family character.
     *
     * @return (cFamily), the character value of creature's assigned family
     *   
     */ 
    public char getFamily() {
        return cFamily;
    }
    /**
     *
     * Sets a creature's type.
     *
     * @param (strType) the String value of creature's assigned Type
     *   
     */ 
    public void setType(String strType) {
        this.strType = strType;
    }
    /**
     *
     * Gets a creature's type.
     *
     * @return (strType), the String value of creature's assigned Type
     *   
     */ 
    public String getType() {
        return strType;
    }
    
    /**
     *
     * Sets a creature's evolution level.
     *
     * @param (nLevel) the integer value of creature's assigned evolution level
     *   
     */ 
     public void setLevel(int nLevel) { 
         this.nLevel = nLevel;
     } 

    /**
     *
     * Gets a creature's evolution level.
     *
     * @return (nLevel), the integer value of creature's assigned evolution level
     *   
     */ 
     public int getLevel() {
        return nLevel;
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
     * Gets a creature's active status, true (if active) or false (not active).
     *
     * @return (bActive), the boolean value of creature's assigned active status
     *   
     */ 
    public boolean getActiveCreature() {
        return bActive;
    }

    /**
     *
     * Copies the initial information from CMasterInventory to a new creature instance in aCapturedCreatures 
     *
     * @return (CNewCreature), the new creature instance
     *   
     */ 
    public Creature copyCreatureInfo() //can be used to catch creatures/add creatures to aCapturedCreatures
    {
      Creature CNewCreature = new Creature(nHealth, nImageID, strCreatureName, cFamily, strType, nLevel, bActive);
      return CNewCreature;
    }
}
