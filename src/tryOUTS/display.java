import java.util.ArrayList;

public class display 
{
    public static void main(String[] args) {
        Player CPlayer1 = new Player();
        Player CPlayer2 = new Player();

        ArrayList<Player> aPlayers = new ArrayList<Player>();
        aPlayers.add(CPlayer1);
        aPlayers.add(CPlayer2);

        System.out.println(aPlayers.size()+
        "\nPlayers health = " + aPlayers.CPlayer1.getHealth());

    }
}
