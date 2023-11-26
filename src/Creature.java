import java.util.ArrayList;

public class Creature { //make children: enemy and caught/player creature
       
    protected int nImageID;    
    protected String strCreatureName;    
    protected char cFamily;    
    protected String strType;    
    protected int nLevel;      

    /**
     *
     * Is a constructor containing all creature fields.
     *
     * 
     * @param (nImageID) the integer value of creature's assigned image ID
     * @param (strCreatureName) the String value of creature's assigned name
     * @param (cFamily) the character value of creature's assigned family
     * @param (strType) the String value of creature's assigned Type
     * @param (nLevel) the integer value of creature's assigned evolution level
     * 
     *   
     */ 
    public Creature(int nImageID, String strCreatureName, char cFamily, String strType, int nLevel){
        this.nImageID = nImageID;
        this.strCreatureName = strCreatureName;
        this.cFamily = cFamily;
        this.strType = strType;
        this.nLevel = nLevel;
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
     * Sets the creature's name. For nicknaming?
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
     * Gets a creature's evolution level.
     *
     * @return (nLevel), the integer value of creature's assigned evolution level
     *   
     */ 
     public int getLevel() {
        return nLevel;
     }

}
