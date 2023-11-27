import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.*; 
import java.awt.event.*;

public class StartUpView extends JFrame{

    private JButton creatureBtn; 

    public StartUpView(){
        
        setTitle("Pokemon Startup");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
		setSize(1000, 800);
        setResizable(false);;

        this.creatureBtn = new JButton();
        this.creatureBtn.setText("Choose Starter Creature");
        this.creatureBtn.addMouseListener(new MouseAdapter(){
            @Override 
            public void mouseClicked(MouseEvent e){
                // go to main menu
                MainMenuView mainMenuView = new MainMenuView();
                dispose();
            }
        }); 

        add(creatureBtn);
        setVisible(true); 
        
    }


    
}
    

