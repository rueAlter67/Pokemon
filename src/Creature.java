
public class Creature {
    
    private int nHealth;    
    private int nImageID;    
    private String strCreatureName;    
    private char cFamily;    
    private String strType;    
    private int nLevel;    
    private boolean bActive;    

    public Creature(int nHealth, int nImageID, String strCreatureName, char cFamily, String strType, int nLevel, boolean bActive){
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

    public void setImageID(int nImageID){
        this.nImageID = nImageID;
    }

    public int getImageID(){
        return nImageID;
    }

    public void setCreatureName(String strCreatureName) { 
        this.strCreatureName = strCreatureName;           
    }

    public String getCreatureName() {   
        return strCreatureName; 
    }

    public void setFamily(char cFamily) {
        this.cFamily = cFamily;
    }

    public char getFamily() {
        return cFamily;
    }

    public void setType(String strType) {
        this.strType = strType;
    }

    public String getType() {
        return strType;
    }
    
     public void setLevel(int nLevel) { 
         this.nLevel = nLevel;
     } 

    public int getLevel() {
        return nLevel;
    }

    public void setActiveCreature(boolean bActive) { 
        this.bActive = bActive;
    }

    public boolean getActiveCreature() {
        return bActive;
    }

    public Creature copyCreatureInfo() //can be used to catch creatures/add creatures to aCapturedCreatures
    {
      Creature CNewCreature = new Creature(nHealth, nImageID, strCreatureName, cFamily, strType, nLevel, bActive);
      return CNewCreature;
    }
}
