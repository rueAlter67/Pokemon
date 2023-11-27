import java.awt.geom.Area;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.FlowLayout; 
import java.awt.event.KeyEvent; 

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
                A1View A1View = new A1View();
                dispose();
            }

        });
        add(this.chooseLbl);
        add(this.area1Btn);

        setVisible(true);
    }
}