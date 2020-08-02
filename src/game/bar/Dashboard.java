package game.bar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;



public class Dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dashboard() {
		
		int width = 1800;
		int height = 800;
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel navigation_panel = new JPanel();
		contentPane.add(navigation_panel, BorderLayout.WEST);
		
		JPanel content_panel = new JPanel();
		contentPane.add(content_panel, BorderLayout.CENTER);
		
		
		JButton logo = new JButton();
		logo.setBackground(Color.white);
		logo.setBorder(null);
		logo.setFocusPainted(false);
//		Border logo_outside_border  = BorderFactory.createEmptyBorder(5, 5, 10, 5);
//		Border logo_inside_border = BorderFactory.createEmptyBorder(5, 5, 5, 5);
//		Border logo_overall_border = BorderFactory.createCompoundBorder(logo_outside_border, logo_inside_border);
//		logo.setBorder(logo_overall_border);
		
		logo.setIcon(new ImageIcon("images/game_hub.png"));
		
		
		menuBar.add(logo);
		menuBar.setBorder(BorderFactory.createEtchedBorder());
		
		Color menu_bar_bg = getBackground();
		menuBar.setBackground(menu_bar_bg);
		
		Color nav_bar_icons_bg = Color.decode("#ff7c2b");
//		Color nav_bar_bg = Color.decode("#000000");
		navigation_panel.setLayout(new BoxLayout(navigation_panel, BoxLayout.Y_AXIS));
//		navigation_panel.setBackground(nav_bar_bg);
		navigation_panel.setPreferredSize(new Dimension(width/10, height/20));
		
		
		JPanel test_panel = new JPanel();
		test_panel.setLayout(new BorderLayout());
			
		
		JButton games_button = new JButton("Games");
		games_button.setBackground(nav_bar_icons_bg);
		games_button.setForeground(Color.white);
		games_button.setFont(new Font("Segoe UI", Font.BOLD, 20));
		games_button.setBorder(null);
		games_button.setFocusPainted(false);
		Border inside_border = BorderFactory.createEmptyBorder(5, 5, 10, 5);
		Border outside_border = BorderFactory.createLineBorder(Color.black, 1);
		Border overall_border = BorderFactory.createCompoundBorder(outside_border, inside_border);
		games_button.setBorder(overall_border);
		
		JButton score_button = new JButton("Score");
		score_button.setBackground(nav_bar_icons_bg);
		score_button.setForeground(Color.white);
		score_button.setFont(new Font("Segoe UI", Font.BOLD, 20));
		score_button.setBorder(null);
		score_button.setFocusPainted(false);
		score_button.setBorder(overall_border);
		
		JPanel test_panel_2 = new JPanel();
		test_panel_2.setLayout(new BorderLayout());
		
		test_panel.setMaximumSize(new Dimension(width/10, height/20));
		test_panel.add(games_button);
		
		test_panel_2.setMaximumSize(new Dimension(width/10, height/20));
		test_panel_2.add(score_button);

		
		navigation_panel.add(test_panel);
		navigation_panel.add(test_panel_2);
		
		
		
		JPanel blank_panel = new JPanel();
		blank_panel.setBackground(new Color(255, 255, 255));
		
		
		navigation_panel.add(blank_panel);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100, 100);
		setSize(width, height);
		
	}

}
