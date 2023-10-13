public class Creature {
    
    private String strCreatureName;    
    private char cFamily;    
    private String strType;    
    private int nLevel;    
    private boolean bActive;    

    public Creature(String strCreatureName, char cFamily, String strType, int nLevel, boolean bActive){
        this.strCreatureName = strCreatureName;
        this.cFamily = cFamily;
        this.strType = strType;
        this.nLevel = nLevel;
        this.bActive = bActive;
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

    public void setActive(boolean bActive) { 
        this.bActive = bActive;
    }

    public boolean getActive() {
        return bActive;
    }

    
}
