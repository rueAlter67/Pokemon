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
import java.awt.event.MouseListener;


public class InventoryView extends JFrame{
    JLabel inventoryLbl;
    
    public InventoryView(){
        setTitle("Pokemon Inventory");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(1000, 800);
        setResizable(false);
        this.inventoryLbl = new JLabel("Welcome to Inventory"); 
        this.inventoryLbl.setHorizontalAlignment(JLabel.CENTER);

       
        setVisible(true); 
    }
}
