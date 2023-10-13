public class Creature {
    
    private int nHealth;    
    private int nImageID;    
    private String strCreatureName;    
    private char cFamily;    
    private String strType;    
    private int nLevel;    
    private boolean bActive;    

    public Creature(int nHealth, int nImageID, 
                    String strCreatureName, char cFamily, 
                    String strType, int nLevel, boolean bActive)
    {
        this.nHealth = nHealth;
        this.nImageID = nImageID;
        this.strCreatureName = strCreatureName;
        this.cFamily = cFamily;
        this.strType = strType;
        this.nLevel = nLevel;
        this.bActive = bActive;
    }

    public void setHealth(int nHealth){
        this.nHealth = nHealth;
    }
    
    public int getHealth(){
        return nHealth;
    }

    public int getImageID(){
        return nImageID;
    }

    public void setCreatureName(String strCreatureName) { //the reason i kept this is in if we want to let the player
        this.strCreatureName = strCreatureName;           //make Captured pokemon nicknames (bonus feature) but we can remove it if di nagamit
    }

    public String getCreatureName() {   
        return strCreatureName; 
    }

    public char getFamily() {
        return cFamily;
    }

    public String getType() {
        return strType;
    }
    
    // public void setLevel(int nLevel) { 
    //     this.nLevel = nLevel;
    // } idk if need level setter for evolution, comment out ko muna

    public int getLevel() {
        return nLevel;
    }

    public void setActiveCreature(boolean bActive) { 
        this.bActive = bActive;
    }

    public boolean getActiveCreature() {
        return bActive;
    }

    
}
