package games;

import javax.swing.JFrame;

/**
 *
 * @author Yashraj Balidani
 * @author Milind Jain
 * @author Sarvesh Choushetti
 * @version 1.0
 * 
 */
public class Windowgame 
{
    public static final int WIDTH = 445, HEIGHT =629;
    
    private Tboard board;
    private JFrame window;
    
    public Windowgame()
    {
        window = new JFrame("Tetris");
        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        board = new Tboard();
        window.add(board);
        window.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new Windowgame();
    }
}
