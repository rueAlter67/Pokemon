import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.*; 
import java.awt.event.*;

public class MultipleAreas extends JFrame{
    private boolean bValidMove; 
    private boolean bPlaying;
    
    private int nGridRow; 
    private int nGridCol; 
    private int nYDim; 
    private int nXDim; 
    private int nRow;
    private int nCol;
    private int nPlayerRow; 
    private int nPlayerCol; 
    private JButton gridBtn; 
    private JButton playerBtn; 

    private JLabel creatureLbl; 
    private JPanel controlsPanel;
    private JPanel gridGamePanel;

    private JButton leftBtn;
    private JButton rightBtn;
    private JButton upBtn;
    private JButton downBtn;  
    private JButton exitBtn;  
 
    private ImageIcon leftBtnIcon;
    private ImageIcon rightBtnIcon;
    private ImageIcon upBtnIcon;
    private ImageIcon downBtnIcon;
    private ImageIcon exitBtIcon;

    private int nButtonDimension;

    public MultipleAreas(String strTitle, int nRow, int nCol){
        // setting up the frame 
        setTitle(strTitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
		setSize(1000, 800);
        setResizable(true);
        this.nButtonDimension = 50;
        this.nPlayerCol = 0; 
        this.nPlayerRow = 0; 
        this.nXDim = 100;
        this.nYDim = 220;
        this.nRow = nRow;
        this.nCol = nCol;
        this.bValidMove = true; 
        this.bPlaying = true; 

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

          // create and set up the content pane
        this.controlsPanel.add(leftBtn);
        this.controlsPanel.add(rightBtn);
        this.controlsPanel.add(upBtn);
        this.controlsPanel.add(downBtn);
        this.controlsPanel.add(exitBtn);


        for(int r=0; r<nRow; r++){
            for(int c=0;c<nCol; c++){   

                if(nPlayerRow == r && nPlayerCol == c){
                    gridBtn= new JButton(); 
                    gridBtn.setBounds(this.nXDim , this.nYDim, 60 , 60);
                    gridBtn.setBackground(Color.PINK);
                    gridBtn.setText("O");
                    gridBtn.setEnabled(false);
                    this.gridGamePanel.add(gridBtn);

                    this.nXDim += 75; 

                }
                else{
                    gridBtn= new JButton(); 
                    gridBtn.setBounds(this.nXDim , this.nYDim, 60 , 60);
                    gridBtn.setBackground(Color.BLACK);
                    gridBtn.setEnabled(false);
                    this.gridGamePanel.add(gridBtn);

                    this.nXDim += 75; 
                }
                
            }
            this.nXDim = 100;
            this.nYDim += 80;
        }
        
        add(controlsPanel);
        add(gridGamePanel);
        
      
        this.setVisible(true); 
    }

    private ImageIcon createImageIcon(String strImagePath){
        java.net.URL imgURL = MultipleAreas.class.getResource(strImagePath); 
       

        if(imgURL != null) { 
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + strImagePath); 
            return null; 
        }
    }


    public void setLeftBtnListener(MouseAdapter mouseAdapter){
        this.leftBtn.addMouseListener(mouseAdapter);
    }

    public void setRightBtnListener(MouseAdapter mouseAdapter){
        this.rightBtn.addMouseListener(mouseAdapter);
    }

    public void setExtBtnListener(MouseAdapter mouseAdapter){
        this.exitBtn.addMouseListener(mouseAdapter);
    }

    public int getGridRow(){
        return this.nGridRow;
    }

    public int getPlayerXPos(){
        return this.nPlayerCol;
    }
    
    public int getPlayerYPos(){
        return this.nPlayerRow;
    }

    public void setPlayerXPos(int nXPos){
        this.nPlayerCol = nXPos;
    }


    public void setPlayerYPos(int nYPos){
        this.nPlayerCol = nYPos;
    }
    


    public int getRow(){
        return this.nRow;
    }

    public int getCol(){
        return this.nCol; 
    }

    public boolean isValidMove(){
        return this.bValidMove;
    }

    public void setValidMove(boolean bValue){
        this.bValidMove = bValue;
    }

    public boolean isPlaying(){
        return this.bPlaying;
    }

    public void setPlaying(boolean bValue){
        this.bPlaying = bValue;
    }
    
}
    


    