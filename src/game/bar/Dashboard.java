package game.bar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
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

		int width = 1500;
		int height = 900;

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

		Color theme_color = Color.decode("#040c52");

		JButton logo = new JButton();
		logo.setBackground(Color.white);
		logo.setBorder(null);
		logo.setFocusPainted(false);
//		Border logo_outside_border  = BorderFactory.createEmptyBorder(5, 5, 10, 5);
//		Border logo_inside_border = BorderFactory.createEmptyBorder(5, 5, 5, 5);
//		Border logo_overall_border = BorderFactory.createCompoundBorder(logo_outside_border, logo_inside_border);
//		logo.setBorder(logo_overall_border);

		logo.setIcon(new ImageIcon("images/newLogo4.jpg"));
		logo.setBackground(theme_color);

		JPanel encloser_logo = new JPanel();
		encloser_logo.setBackground(theme_color);
		encloser_logo.add(logo);
		menuBar.add(encloser_logo);
		menuBar.setBorder(BorderFactory.createEtchedBorder());

		Color menu_bar_bg = getBackground();

		Border menu_inside_border = BorderFactory.createLineBorder(Color.white, 2);
		Border menu_outside_border = BorderFactory.createLineBorder(theme_color, 4);
		Border menu_overall_border = BorderFactory.createCompoundBorder(menu_outside_border, menu_inside_border);
		menuBar.setBorder(menu_overall_border);
		menuBar.setBackground(menu_bar_bg);

//		Color nav_bar_icons_bg = theme_color;
//		Color nav_bar_icons_fg = Color.white;
		Color nav_bar_icons_bg = Color.yellow;
		Color nav_bar_icons_fg = theme_color;
//		Color nav_bar_bg = Color.decode("#000000");
		navigation_panel.setLayout(new BoxLayout(navigation_panel, BoxLayout.Y_AXIS));
//		navigation_panel.setBackground(nav_bar_bg);
		navigation_panel.setPreferredSize(new Dimension(width / 10, height / 20));
		navigation_panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 10));
		JPanel test_panel = new JPanel();
		test_panel.setLayout(new BorderLayout());
		
		JPanel test_panel_2 = new JPanel();
		test_panel_2.setLayout(new BorderLayout());
		
		JButton games_button = new JButton("Games");
		
		games_button.setBackground(nav_bar_icons_bg);
		games_button.setForeground(nav_bar_icons_fg);
		games_button.setFont(new Font("Segoe UI", Font.BOLD, 20));
		games_button.setBorder(null);
		games_button.setFocusPainted(false);
		Border inside_border = BorderFactory.createLineBorder(nav_bar_icons_bg, 5);
		Border outside_border = BorderFactory.createLineBorder(theme_color, 2);
		Border overall_border = BorderFactory.createCompoundBorder(outside_border, inside_border);
		test_panel.setBorder(overall_border);

		games_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				games_button.setBackground(theme_color);
				games_button.setForeground(Color.white);
				Border test_panel_inside = BorderFactory.createLineBorder(theme_color, 5);
				Border test_panel_overall_mouseover  = BorderFactory.createCompoundBorder(outside_border, test_panel_inside);
				test_panel.setBorder(test_panel_overall_mouseover);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				games_button.setBackground(nav_bar_icons_bg);
				games_button.setForeground(nav_bar_icons_fg);
				test_panel.setBorder(overall_border);
			}
		});
		
		
		JButton score_button = new JButton("Score");
		score_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		score_button.setBackground(nav_bar_icons_bg);
		score_button.setForeground(nav_bar_icons_fg);
		score_button.setFont(new Font("Segoe UI", Font.BOLD, 20));
		score_button.setBorder(null);
		score_button.setFocusPainted(false);
		test_panel_2.setBorder(overall_border);
		
		score_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				score_button.setBackground(theme_color);
				score_button.setForeground(Color.white);
				Border test_panel_2_inside = BorderFactory.createLineBorder(theme_color, 5);
				Border test_panel_2_overall_mouseover  = BorderFactory.createCompoundBorder(outside_border, test_panel_2_inside);
				test_panel_2.setBorder(test_panel_2_overall_mouseover);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				score_button.setBackground(nav_bar_icons_bg);
				score_button.setForeground(nav_bar_icons_fg);
				test_panel_2.setBorder(overall_border);
			}
		});
		

		test_panel.setMaximumSize(new Dimension(width / 10, height / 20));
		test_panel.add(games_button);

		test_panel_2.setMaximumSize(new Dimension(width / 10, height / 20));
		test_panel_2.add(score_button);

		navigation_panel.add(test_panel);
		
		Component verticalStrut1 = Box.createVerticalStrut(2);
		verticalStrut1.setBackground(nav_bar_icons_fg);
		navigation_panel.add(verticalStrut1);
		
		navigation_panel.add(test_panel_2);
		
		Component verticalStrut2 = Box.createVerticalStrut(2);
		verticalStrut2.setBackground(nav_bar_icons_fg);
		navigation_panel.add(verticalStrut2);
		
		class BlankPanel extends JPanel{
			private BufferedImage bg_image;
			
			BlankPanel(String image_path){
				try {
					this.bg_image = ImageIO.read(new File(image_path));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(bg_image, 0, 0, this);
			}
		}
		
		JPanel blank_panel = new JPanel();
		JLabel image_label = new JLabel();
		
		image_label.setIcon(new ImageIcon("images/fist.png"));
		blank_panel.add(image_label);
		
		JLabel unleash = new JLabel("<html><CENTER>UNLEASH<br>THE<br>SPIRIT</CENTER><html>");
		unleash.setForeground(Color.white);
		unleash.setFont(new Font("Segoe UI", Font.BOLD, 25));
		blank_panel.add(unleash);
		
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/fonts/deathrattlebb_reg.ttf")).deriveFont(43f);
			ge.registerFont(customFont);
			unleash.setFont(customFont);
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		
		Border inside_border_blank_panel = BorderFactory.createLineBorder(Color.white, 3);
		Border outside_border_blank_panel = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border overall_border_blank_panel = BorderFactory.createCompoundBorder(outside_border_blank_panel, inside_border_blank_panel);
		
//		blank_panel.setBorder(overall_border_blank_panel);
		
		blank_panel.setBackground(theme_color);
		
//		navigation_panel.setBackground(theme_color);

		navigation_panel.add(blank_panel);

		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100, 100);
		setSize(width, height);

	}

}
