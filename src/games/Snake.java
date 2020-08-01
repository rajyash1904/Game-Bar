/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Yashraj Balidani
 */
public class Snake 
{
    public static void main(String[] args)
    {
        JFrame obj = new JFrame();
        snakeplay splay = new snakeplay();
        obj.setBounds(10, 10, 905, 700);
        obj.setBackground(Color.blue);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(splay);
        
    }
}
