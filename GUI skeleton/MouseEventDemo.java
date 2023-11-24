import java.awt.*; 
import java.awt.event.*;
import javax.swing.JFrame;

public class MouseEventDemo extends JFrame {

    private TextField tfMouseX; // to display mouse-click-x
   private TextField tfMouseY;


    public MouseEventDemo() {
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new Label("X-Click")); 
        tfMouseX = new TextField(10); 
        tfMouseX.setEditable(false); 
        add(tfMouseX); 

         // Label (anonymous)
        add(new Label("Y-Click: ")); // "super" frame adds Label component

        // TextField
        tfMouseY = new TextField(10);
        tfMouseY.setEditable(false);  // read-only
        add(tfMouseY);                // "super" frame adds TextField component
        
        addMouseListener(new MyMouseListener());
        
        setTitle("MouseEvent Demo"); // "super" Frame sets title
        setSize(350, 100);           // "super" Frame sets initial size
        setVisible(true);    

    }

    private class MyMouseListener implements MouseListener{
        @Override 
        public void mouseClicked(MouseEvent evt){
            tfMouseX.setText(evt.getX() + "");
            tfMouseY.setText(evt.getY() + "");
        }

        // Not used - need to provide an empty body to compile.
        @Override public void mousePressed(MouseEvent evt) { }
        @Override public void mouseReleased(MouseEvent evt) { }
        @Override public void mouseEntered(MouseEvent evt) { }
        @Override public void mouseExited(MouseEvent evt) { }
    }

    
    public static void main(String[] args) {
        new MouseEventDemo();  // Let the constructor do the job
     }
}
