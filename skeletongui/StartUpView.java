import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*; 
import java.awt.event.*;

public class StartUpView extends JFrame{

    private JButton creatureLbl; 

    public StartUpView(){
        
        setTitle("Pokemon Startup");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
		setSize(1000, 800);
        setResizable(false);;

        this.creatureLbl = new JButton();

        this.creatureLbl.setText("Choose");
        this.creatureLbl.addMouseListener(new MyMouseListener()); 
        add(creatureLbl);


        /*todo: 
        *  - add a background 
            - add a preferred size 
        */
       
        
        setVisible(true); 
        
    }

    private class MyMouseListener implements MouseListener{

        @Override 
        public void mouseClicked(MouseEvent evt){
            // go to main menu
            MainMenuView MainMenuView = new MainMenuView();
            dispose();
        }

        // other interfaces
        @Override 
        public void mousePressed(MouseEvent evt){
            
        }
        @Override
        public void mouseReleased(MouseEvent evt){}
        @Override public 
        void mouseEntered(MouseEvent evt){}
        @Override public
        void mouseExited(MouseEvent evt) {}

    }
       

}
    

