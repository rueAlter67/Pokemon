import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MainMenuView extends JFrame{

    private JLabel menuLbl;
    private JButton inventoryBtn;
    private JButton areaBtn;
    private JButton evolveBtn;
    private JButton exitBtn;

    public MainMenuView(){
        setTitle("Pokemon Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(1000, 800);
        setResizable(false);

        this.menuLbl = new JLabel("Main Menu"); 
        this.menuLbl.setHorizontalAlignment(JLabel.CENTER);


        // inventory button
        this.inventoryBtn = new JButton("Inventory");
        this.inventoryBtn.addMouseListener(new InventoryBtnListener());
    
        // area button
        this.areaBtn  = new JButton("Area");
        this.areaBtn.addMouseListener(new AreaBtnListener());

        // evolve button
        this.evolveBtn = new JButton("Evolve");
        this.evolveBtn.addMouseListener(new EvolveBtnListener());
        
        // exit button
        this.exitBtn = new JButton("Exit");

        add(menuLbl);
        add(inventoryBtn);
        add(areaBtn); 
        add(evolveBtn);
        add(exitBtn);
        setVisible(true); 
    }
    
   
    private class InventoryBtnListener implements MouseListener{

        @Override 
        public void mouseClicked(MouseEvent e){
            // go to main menu
            InventoryView inventoryView = new InventoryView();
            dispose();
        }

        // other interfaces
        @Override 
        public void mousePressed(MouseEvent e){}
        @Override
        public void mouseReleased(MouseEvent e){}
        @Override public 
        void mouseEntered(MouseEvent e){}
        @Override public
        void mouseExited(MouseEvent e) {}

    }

    private class AreaBtnListener implements MouseListener{

        @Override 
        public void mouseClicked(MouseEvent e){
            // go to main menu
            AreaView areaView = new AreaView();
            dispose();
        }

        // other interfaces
        @Override 
        public void mousePressed(MouseEvent e){}
        @Override
        public void mouseReleased(MouseEvent e){}
        @Override public 
        void mouseEntered(MouseEvent e){}
        @Override public
        void mouseExited(MouseEvent e) {}

    }


    private class EvolveBtnListener implements MouseListener{

        @Override 
        public void mouseClicked(MouseEvent e){
            // go to main menu
            EvolveView evolveView = new EvolveView();
            dispose();
        }

        // other interfaces
        @Override 
        public void mousePressed(MouseEvent e){}
        @Override
        public void mouseReleased(MouseEvent e){}
        @Override public 
        void mouseEntered(MouseEvent e){}
        @Override public
        void mouseExited(MouseEvent e) {}

    }



}
