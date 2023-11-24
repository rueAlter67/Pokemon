import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.w3c.dom.events.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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


        // area button
        this.areaBtn  = new JButton("Area");

       
        // evolve button
        this.evolveBtn = new JButton("Evolve");

        // evolve button
        this.exitBtn = new JButton("Exit");

        add(menuLbl);
        add(inventoryBtn);
        add(areaBtn); 
        add(evolveBtn);
        add(exitBtn);
        setVisible(true); 
    }
    

    public void setInventoryBtnListener(ActionListener actionListener){
        this.inventoryBtn.addActionListener(actionListener);
    }

    public void setAreaBtnListener(ActionListener actionListener){
        this.areaBtn.addActionListener(actionListener);
    }

    public void setEvolveBtnListener(ActionListener actionListener){
        this.evolveBtn.addActionListener(actionListener);
    }

    public void setExitBtnListener(ActionListener actionListener){
        this.exitBtn.addActionListener(actionListener);
    }
   
       
    
}
