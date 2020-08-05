package game.bar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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

		int width = 1000;
		int height = 745;
		
		
		setTitle("Game Bar");
		
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
		navigation_panel.setBorder(BorderFactory.createEmptyBorder(-5, 0, 0, 10));
		JPanel test_panel = new JPanel();
		test_panel.setLayout(new BorderLayout());

		JPanel test_panel_2 = new JPanel();
		test_panel_2.setLayout(new BorderLayout());

		JButton games_button = new JButton("Games");
//		
//		games_button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//
//				ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c",
//						"F: && cd \"F:\\Projects\\COLLAB\\Game-Bar\\PythonGame\" && \"virtual_env_game\\Scripts\\activate.bat\" && python game\\main.py");
//				builder.redirectErrorStream(true);
//				try {
//					Process p = builder.start();
//					BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
//					String line;
//
//					while (true) {
//						line = r.readLine();
//						System.out.println(line);
////			            System.out.println("Running");
//						if (line == null) {
//							break;
//						}
//
//					}
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		});
//

//		games_button.setBackground(nav_bar_icons_bg);
//		games_button.setForeground(nav_bar_icons_fg);
//		games_button.setFont(new Font("Segoe UI", Font.BOLD, 20));
//		games_button.setBorder(null);
//		games_button.setFocusPainted(false);
//		Border inside_border = BorderFactory.createLineBorder(nav_bar_icons_bg, 5);
//		Border outside_border = BorderFactory.createLineBorder(theme_color, 2);
//		Border overall_border = BorderFactory.createCompoundBorder(outside_border, inside_border);
//		test_panel.setBorder(overall_border);
//
//		games_button.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				games_button.setBackground(theme_color);
//				games_button.setForeground(Color.white);
//				Border test_panel_inside = BorderFactory.createLineBorder(theme_color, 5);
//				Border test_panel_overall_mouseover = BorderFactory.createCompoundBorder(outside_border,
//						test_panel_inside);
//				test_panel.setBorder(test_panel_overall_mouseover);
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				games_button.setBackground(nav_bar_icons_bg);
//				games_button.setForeground(nav_bar_icons_fg);
//				test_panel.setBorder(overall_border);
//			}
//		});
//
//		JButton score_button = new JButton("Score");
//		score_button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//
//			}
//		});
//
//		score_button.setBackground(nav_bar_icons_bg);
//		score_button.setForeground(nav_bar_icons_fg);
//		score_button.setFont(new Font("Segoe UI", Font.BOLD, 20));
//		score_button.setBorder(null);
//		score_button.setFocusPainted(false);
//		test_panel_2.setBorder(overall_border);
//
//		score_button.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				score_button.setBackground(theme_color);
//				score_button.setForeground(Color.white);
//				Border test_panel_2_inside = BorderFactory.createLineBorder(theme_color, 5);
//				Border test_panel_2_overall_mouseover = BorderFactory.createCompoundBorder(outside_border,
//						test_panel_2_inside);
//				test_panel_2.setBorder(test_panel_2_overall_mouseover);
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				score_button.setBackground(nav_bar_icons_bg);
//				score_button.setForeground(nav_bar_icons_fg);
//				test_panel_2.setBorder(overall_border);
//			}
//		});
//
//		test_panel.setMaximumSize(new Dimension(width / 10, height / 20));
//		test_panel.add(games_button);
//
//		test_panel_2.setMaximumSize(new Dimension(width / 10, height / 20));
//		test_panel_2.add(score_button);
//
//		navigation_panel.add(test_panel);
//
//		Component verticalStrut1 = Box.createVerticalStrut(2);
//		verticalStrut1.setBackground(nav_bar_icons_fg);
//		navigation_panel.add(verticalStrut1);
//
//		navigation_panel.add(test_panel_2);
//
//		Component verticalStrut2 = Box.createVerticalStrut(2);
//		verticalStrut2.setBackground(nav_bar_icons_fg);
//		navigation_panel.add(verticalStrut2);

		class BlankPanel extends JPanel {
			private BufferedImage bg_image;
			private int x;
			private int y;

			BlankPanel(String image_path, int x, int y) {
				try {
					this.bg_image = ImageIO.read(new File(image_path));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.x = x;
				this.y = y;
			}

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(bg_image, x, y, this.getWidth()-20, this.getHeight()-20, this);
			}
		}

		JPanel blank_panel = new JPanel();
		JLabel image_label = new JLabel();

		image_label.setIcon(new ImageIcon("images/fist.png"));
		blank_panel.add(image_label);

		JLabel unleash = new JLabel("<html><CENTER>UNLEASH<br><br>THE<br><br>SPIRIT</CENTER><html>");
		unleash.setForeground(Color.white);
		unleash.setFont(new Font("Segoe UI", Font.BOLD, 25));
		blank_panel.add(unleash);

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/fonts/deathrattlebb_reg.ttf"))
					.deriveFont(30f);
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
		Border overall_border_blank_panel = BorderFactory.createCompoundBorder(outside_border_blank_panel,
				inside_border_blank_panel);

//		blank_panel.setBorder(overall_border_blank_panel);

		blank_panel.setBackground(theme_color);

//		navigation_panel.setBackground(theme_color);

		navigation_panel.add(blank_panel);
		
		
		content_panel.setBackground(Color.white);
//		content_panel.setBorder(BorderFactory.createLineBorder(theme_color, 2));
		content_panel.setLayout(new GridLayout(0, 3));
		
		class GamePanel extends JPanel{

			private BlankPanel image_panel;
			private JPanel text_panel;
			private int type;
			private JLabel heading_label;
			private JTextArea info;
			private JButton play_button;
			
			
			public GamePanel(String image_path, String info_text, String heading_text, int type) {
//				switch(type) {
//				case 1:
//					this.setBackground(Color.red);
//					break;
//				case 2:
//					this.setBackground(Color.blue);
//					break;
//				case 3:
//					this.setBackground(Color.green);
//					break;
//				}
				this.setBackground(Color.white);
				Border inside_border_game_panel = BorderFactory.createLineBorder(theme_color, 2);
				Border outside_border_game_panel = BorderFactory.createEmptyBorder(10, 10, 10, 10);
				Border overall_border_game_panel = BorderFactory.createCompoundBorder(outside_border_game_panel, inside_border_game_panel);
				this.setBorder(overall_border_game_panel);
				
				this.setLayout(new GridLayout(2, 1));
				this.image_panel = new BlankPanel(image_path, 9, 10);
				
				Border inside_border_image_panel = BorderFactory.createLineBorder(theme_color, 2);
				Border outside_border_image_panel = BorderFactory.createEmptyBorder(5, 5, 5, 5);
				Border overall_border_image_panel = BorderFactory.createCompoundBorder(outside_border_image_panel,
						inside_border_image_panel);
				
				this.image_panel.setBorder(overall_border_image_panel);
				this.image_panel.setMaximumSize(new Dimension(width/2, height/3));
				this.add(image_panel);
				
				JPanel main_panel = new JPanel();
				main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
				String formatted_text_heading = String.format("<html><span style='font-size:25px'>%s</span><html>", heading_text);
				heading_label = new JLabel(formatted_text_heading);
				JPanel heading_encloser = new JPanel();
//				heading_encloser.setMaximumSize(new Dimension(width/2, height/2));
				heading_encloser.add(heading_label);
				heading_encloser.setBackground(Color.white);
				main_panel.add(heading_encloser);
				main_panel.setBackground(Color.white);
				
				JPanel info_encloser = new JPanel();
				
				info = new JTextArea(info_text);
				info.setFont(info.getFont().deriveFont(20f));
				info.setLineWrap(true);
				info.setWrapStyleWord(true);
				info.setFocusable(false);
				
				info_encloser.setLayout(new BorderLayout());
				info_encloser.setBackground(Color.white);
				Border outside_border_info = BorderFactory.createEmptyBorder(0, 11, 10, 10);
				Border inside_border_info = BorderFactory.createEmptyBorder(10, 11, 10, 10);
				Border overall_border_info = BorderFactory.createCompoundBorder(outside_border_info, inside_border_info);
				info_encloser.setBorder(overall_border_info);
				info_encloser.add(info, BorderLayout.NORTH);
//				info_encloser.setMaximumSize(new Dimension(width/2, height/2));
				main_panel.add(info_encloser);
				
				JPanel btn_encloser = new JPanel();
				play_button = new JButton("<html><span style='font-size:15px'>Play</span><html>");
				play_button.setFocusPainted(false);
				play_button.setBackground(Color.white);
				
				btn_encloser.add(play_button);
				btn_encloser.setBackground(theme_color);
				main_panel.add(btn_encloser);
				
				this.add(main_panel);
				
				
				
			}
		}
		
		String image_path_one = "images\\snake.jpg";
		String image_path_two = "images\\tetris.jpg";
		String image_path_three = "images\\space_invaders.jpg";
		
		String info_text_one = "Come on! Feed that reptitle some food! It's dying to grow since the space bar shut it down";
		String info_text_two = "Want to destroy buildings\nby actually building them perfectly? Come here to make that possible";
		String info_text_three = "Hawkins was right about aliens. What's done is done. Let's eliminate them and save Earth.";
		
		GamePanel game_one_panel = new GamePanel(image_path_one, info_text_one, "Snake Game", 1);
		GamePanel game_two_panel = new GamePanel(image_path_two, info_text_two, "Tetris", 2);
		GamePanel game_three_panel = new GamePanel(image_path_three, info_text_three, "Space Invaders", 3);
		
		content_panel.add(game_one_panel);
		content_panel.add(game_two_panel);
		content_panel.add(game_three_panel);
		
//		game_one_panel.setBackground(Color.red);
//		game_two_panel.setBackground(Color.blue);
//		game_three_panel.setBackground(Color.green);
//		
//		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100, 100);
		setSize(width, height);

	}

}
