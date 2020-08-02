/**
 *  set this file visible in code to start snake game
 *  snake.setVisible(true);
 *  
 *  snake play is implementation of game file this initialize the game;
 */
package games;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Yashraj Balidani
 * @author Milind Jain
 * @author Sarvesh Choushetti
 * @version 1.0
 * 
 */
public class Snake 
{
    public static void main(String[] args)
    {
        JFrame obj = new JFrame();
        snakeplay splay = new snakeplay();
        obj.setBounds(10, 10, 905, 700);
        obj.setBackground(Color.darkGray);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(splay);
        
    }
}
