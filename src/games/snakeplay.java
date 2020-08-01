/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Yashraj Balidani
 */
public class snakeplay extends JPanel
{
    private ImageIcon titleImage;
    
    public snakeplay()
    {
        
    }
    
    public void paint(Graphics g)
    {
        //draw title Image Border
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);
        
        
        //Draw Title Image
        titleImage = new ImageIcon("snaketitle.jpg");
        titleImage.paintIcon(this, g, 25, 11);
        
        //Draw Border for Play area
        g.setColor(Color.WHITE);
        g.drawRect(24, 74, 851, 577);
        
        //draw Backgroud Game Play
        g.setColor(Color.BLACK);
        g.fillRect(25, 75, 850, 575);
        
        
    }
}
