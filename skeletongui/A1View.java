import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.*; 
import java.awt.event.*;

public class A1View extends JFrame{

    protected int nRow; 
    protected int nCol; 
    protected JButton[] RowBtn; 
    protected JButton[] ColBtn;


    protected JLabel creatureLbl; 
    protected JPanel controlsPanel;
    protected JPanel gridGamePanel;

    protected JButton leftBtn;
    protected JButton rightBtn;
    protected JButton upBtn;
    protected JButton downBtn;  
    protected JButton exitBtn;  
 
    protected ImageIcon leftBtnIcon;
    protected ImageIcon rightBtnIcon;
    protected ImageIcon upBtnIcon;
    protected ImageIcon downBtnIcon;
    protected ImageIcon exitBtIcon;


    protected int nButtonDimension;

    public A1View(){
        // setting up the frame 
        setTitle("Pokemon Area 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
		setSize(1000, 800);
        setResizable(true);
        this.nButtonDimension = 50;

        this.nRow = 5;
        this.nCol = 1;

        this.RowBtn = new JButton[nRow];
        this.ColBtn = new JButton[nCol];

        

    



       

        //setting up controls pane
        this.controlsPanel = new JPanel();
        this.controlsPanel.setLayout(null);
        this.controlsPanel.setBounds(0, 0, 300, 800);
        this.controlsPanel.setBackground(Color.BLACK);


        //setting up views pane
        this.gridGamePanel = new JPanel();
        this.gridGamePanel.setLayout(null);
        this.gridGamePanel.setBounds(300, 0, 700, 800);
        this.gridGamePanel.setBackground(Color.GREEN);

        //images for buttons
        leftBtnIcon = createImageIcon("images/leftbtn.jpg");
        rightBtnIcon = createImageIcon("images/rightbtn.jpg");
        upBtnIcon = createImageIcon("images/upbtn.jpg");
        downBtnIcon = createImageIcon("images/downbtn.png");
        exitBtIcon = createImageIcon("images/exitbtn.jpg");

        
       
        //left button
        leftBtn = new JButton(leftBtnIcon); 
        leftBtn.setBounds(100, 200, 50 , 50);

        //right button
        rightBtn = new JButton(rightBtnIcon);  
        rightBtn.setBounds(100, 300, 50 , 50);

        //up button
        upBtn = new JButton(upBtnIcon); 
        upBtn.setBounds(100, 400, 50 , 50);

        //right button
        downBtn = new JButton(downBtnIcon); 
        downBtn.setBounds(100, 500, 50 , 50);

        //right button
        exitBtn = new JButton(exitBtIcon); 
        exitBtn.setBounds(100, 600, 50 , 50);


        // add the buttons to the panel
        this.controlsPanel.add(leftBtn);
        this.controlsPanel.add(rightBtn);
        this.controlsPanel.add(upBtn);
        this.controlsPanel.add(downBtn);
        this.controlsPanel.add(exitBtn);


        // add disabled buttons to gameGrid
        for(int k =0; k<nRow; k++){

        }

        
        add(controlsPanel);
        add(gridGamePanel);
        setVisible(true); 
        
    }

    protected ImageIcon createImageIcon(String strImagePath){
        java.net.URL imgURL = A1View.class.getResource(strImagePath); 
       

        if(imgURL != null) { 
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + strImagePath); 
            return null; 
        }
    }

    
}
    

