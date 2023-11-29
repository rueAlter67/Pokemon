import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MultiplAreasController{
    private MultipleAreas multipleAreas;

    MultiplAreasController(String strTitle, int nRow, int nCol){
        multipleAreas = new MultipleAreas( strTitle,  nRow, nCol);
    
        this.multipleAreas.setLeftBtnListener(new MouseAdapter(){
            @Override 
            public void mouseClicked(MouseEvent e){
            int nPlayerXPos = multipleAreas.getPlayerXPos();
            int nPlayerYPos = multipleAreas.getPlayerYPos();
            boolean bValidMove = false; 

            if(nPlayerXPos> 0 && nPlayerXPos >0) {
                    nPlayerXPos--;
                    bValidMove = true; 
            }else{
                    JOptionPane.showMessageDialog(null, "Player can't move to left", "title", JOptionPane.WARNING_MESSAGE);
            }

            multipleAreas.setPlayerXPos(nPlayerXPos);
            multipleAreas.setPlayerYPos(nPlayerYPos);
            multipleAreas.setValidMove(bValidMove);
            }
        });

        this.multipleAreas.setRightBtnListener(new MouseAdapter(){
            @Override 
            public void mouseClicked(MouseEvent e){
                int nPlayerXPos = multipleAreas.getPlayerXPos();
                int nPlayerYPos = multipleAreas.getPlayerYPos();
                boolean bValidMove = false; 

                if(nPlayerXPos>= 0 && nPlayerXPos >=0) {
                        nPlayerYPos++;
                        bValidMove = true; 
                }else{
                        JOptionPane.showMessageDialog(null, "Player can't move to left", "title", JOptionPane.WARNING_MESSAGE);
                }

                multipleAreas.setPlayerXPos(nPlayerXPos);
                multipleAreas.setPlayerYPos(nPlayerYPos);
                multipleAreas.setValidMove(bValidMove);
                SwingUtilities.updateComponentTreeUI(multipleAreas);
            }
        });

        this.multipleAreas.setExtBtnListener(new MouseAdapter() {
            @Override 
            public void mouseClicked(MouseEvent e){
               MainMenuController controller = new MainMenuController();
               
            }
            
        });

    }


}
