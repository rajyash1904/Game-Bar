package games;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Yashraj Balidani
 * @author Milind Jain
 * @author Sarvesh Choushetti
 * @version 1.0
 * 
 */
public class Tboard extends JPanel
{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(10, 10, 200, 200);
    }
    
}
