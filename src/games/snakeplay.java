package games;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Yashraj Balidani
 */
public class snakeplay extends JPanel implements KeyListener, ActionListener
{

   
    private int[] snakexlen = new int[750];
    private int[] snakeylen = new int[750];
    
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    
    private ImageIcon rightmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;
    private ImageIcon leftmouth;
    
    private int lengthofsnake = 3 ;
    
    private int moves = 0;
    
    private Timer timer;
    private int delay = 100;
    private ImageIcon snakeimage;
    
    
    
    private ImageIcon titleImage;
    
    
    public snakeplay()
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }
    
    public void paint(Graphics g)
    {
        if(moves==0)
        {
            snakexlen[2] = 50;
            snakexlen[1] = 75;
            snakexlen[0] = 100;
            
            snakeylen[2] = 100;
            snakeylen[1] = 100;
            snakeylen[0] = 100;
        }
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
        
        rightmouth = new ImageIcon("rightmouth.png");
        rightmouth.paintIcon(this, g, snakexlen[0], snakeylen[0]);
        
        for(int a=0;a<lengthofsnake;a++)
        {
            if(a==0 && right)
            {
                rightmouth = new ImageIcon("rightmouth.png");
                rightmouth.paintIcon(this, g, snakexlen[a], snakeylen[a]);
            }
            
            if(a==0 && left)
            {
                leftmouth = new ImageIcon("leftmouth.png");
                leftmouth.paintIcon(this, g, snakexlen[a], snakeylen[a]);
            }
            
            if(a==0 && down)
            {
                downmouth = new ImageIcon("downmouth.png");
                downmouth.paintIcon(this, g, snakexlen[a], snakeylen[a]);
            }
            
            if(a==0 && up)
            {
                upmouth = new ImageIcon("upmouth.png");
                upmouth.paintIcon(this, g, snakexlen[a], snakeylen[a]);
            }
            
            if(a!=0)
            {
                snakeimage = new ImageIcon("snakeimage.png");
                snakeimage.paintIcon(this, g, snakexlen[a], snakeylen[a]);
            }
        }
        
        
        g.dispose();
    }
    
     @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}
