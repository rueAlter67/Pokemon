import java.awt.geom.Area;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.FlowLayout; 

public class AreaView extends JFrame{

    private JLabel chooseLbl;
    private JButton area1Btn; 
    private JButton area2Btn; 
    private JButton area3Btn; 
    private JButton menuBtn; 

    public AreaView(){
        setTitle("Pokemon Area");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(1000, 800);
        setResizable(false);

        //Choose label
        this.chooseLbl = new JLabel("Choose Area");

        // button
        this.area1Btn = new JButton("Area 1");
        //this.area1Btn.setMnemonic(KeyEvent.KEY_PRESSED); 

        this.area1Btn.addMouseListener(new MouseAdapter(){
            
            @Override 
            public void mouseClicked(MouseEvent e){
                // go to main menu
                MultipleAreas area1View = new MultipleAreas("Area 1",1,5 );
                dispose();
            }

        });

        // button
        this.area2Btn = new JButton("Area 2");
     
        this.area2Btn.addMouseListener(new MouseAdapter(){
            
            @Override 
            public void mouseClicked(MouseEvent e){
                // go to main menu
                MultipleAreas area2View = new MultipleAreas("Area 2",3,3 );
                dispose();
            }

        });

        // button
        this.area3Btn = new JButton("Area 2");

        this.area3Btn.addMouseListener(new MouseAdapter(){
            
            @Override 
            public void mouseClicked(MouseEvent e){
                // go to main menu
                MultipleAreas area3View = new MultipleAreas("Area 2",4,4 );
                dispose();
            }

        });


        add(this.chooseLbl);
        add(this.area1Btn);
        add(this.area2Btn);
        add(this.area3Btn);

        setVisible(true);
    }

   

    
}