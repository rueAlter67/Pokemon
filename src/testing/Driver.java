//package testing;

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args)
    {
        Creature CStrawander = new Creature("Strawander",'A',"Fire",1,true);
        Creature CChocowool = new Creature("Chocowool",'B',"Fire",1,false);
        Creature CParfwit = new Creature("Parfwit",'C',"Fire",1,false);
        Creature CBrownisaur = new Creature("Brownisaur",'D',"Grass",1,false);
        Creature CFrubat = new Creature("Frubat",'E',"Grass",1,false);
        Creature CMalts = new Creature("Malts",'F',"Grass",1,false);
        Creature CSquirpie = new Creature("Squirpie",'G',"Water",1,false);
        Creature CChocolite = new Creature("Chocolite",'H',"Water",1,false);
        Creature COshacone = new Creature("Oshacone",'I',"Water",1,false);
        
        ArrayList<Creature> aCaptured = new ArrayList<Creature>();

        aCaptured.add(CStrawander);
        aCaptured.add(CChocowool);
        aCaptured.add(CParfwit);
        aCaptured.add(CBrownisaur);

        System.out.println(aCaptured.get(0).getCreatureName());
        System.out.println(aCaptured.get(0).getFamily());
        
        System.out.print(aCaptured);
    }
}
//(CapturedCreature) 
