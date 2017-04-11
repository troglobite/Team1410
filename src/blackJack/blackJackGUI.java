package blackJack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class blackJackGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					blackJackGUI frame = new blackJackGUI();
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
	public blackJackGUI() {
		setTitle("Blackjack v1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1036, 613);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel scoreLabel = new JLabel("Score:");
		scoreLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		scoreLabel.setBackground(Color.LIGHT_GRAY);
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		scoreLabel.setBounds(896, 13, 56, 16);
		contentPane.add(scoreLabel);
		
		JLabel label = new JLabel("0");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(960, 13, 58, 16);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setMaximumSize(new Dimension(500, 727));
		lblNewLabel.setMinimumSize(new Dimension(500, 727));
		lblNewLabel.setPreferredSize(new Dimension(500, 727));
		lblNewLabel.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		lblNewLabel.setBounds(64, 13, 100, 145);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		label_1.setPreferredSize(new Dimension(500, 727));
		label_1.setMinimumSize(new Dimension(500, 727));
		label_1.setMaximumSize(new Dimension(500, 727));
		label_1.setBounds(176, 13, 100, 145);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		label_2.setPreferredSize(new Dimension(500, 727));
		label_2.setMinimumSize(new Dimension(500, 727));
		label_2.setMaximumSize(new Dimension(500, 727));
		label_2.setBounds(290, 13, 100, 145);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		label_3.setPreferredSize(new Dimension(500, 727));
		label_3.setMinimumSize(new Dimension(500, 727));
		label_3.setMaximumSize(new Dimension(500, 727));
		label_3.setBounds(633, 13, 100, 145);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		label_4.setPreferredSize(new Dimension(500, 727));
		label_4.setMinimumSize(new Dimension(500, 727));
		label_4.setMaximumSize(new Dimension(500, 727));
		label_4.setBounds(402, 13, 100, 145);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		label_5.setPreferredSize(new Dimension(500, 727));
		label_5.setMinimumSize(new Dimension(500, 727));
		label_5.setMaximumSize(new Dimension(500, 727));
		label_5.setBounds(745, 13, 100, 145);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("New label");
		label_6.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		label_6.setPreferredSize(new Dimension(500, 727));
		label_6.setMinimumSize(new Dimension(500, 727));
		label_6.setMaximumSize(new Dimension(500, 727));
		label_6.setBounds(519, 13, 100, 145);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("New label");
		label_7.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		label_7.setPreferredSize(new Dimension(500, 727));
		label_7.setMinimumSize(new Dimension(500, 727));
		label_7.setMaximumSize(new Dimension(500, 727));
		label_7.setBounds(64, 408, 100, 145);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("New label");
		label_8.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		label_8.setPreferredSize(new Dimension(500, 727));
		label_8.setMinimumSize(new Dimension(500, 727));
		label_8.setMaximumSize(new Dimension(500, 727));
		label_8.setBounds(176, 408, 100, 145);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("New label");
		label_9.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		label_9.setPreferredSize(new Dimension(500, 727));
		label_9.setMinimumSize(new Dimension(500, 727));
		label_9.setMaximumSize(new Dimension(500, 727));
		label_9.setBounds(290, 408, 100, 145);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("New label");
		label_10.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		label_10.setPreferredSize(new Dimension(500, 727));
		label_10.setMinimumSize(new Dimension(500, 727));
		label_10.setMaximumSize(new Dimension(500, 727));
		label_10.setBounds(402, 408, 100, 145);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("New label");
		label_11.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		label_11.setPreferredSize(new Dimension(500, 727));
		label_11.setMinimumSize(new Dimension(500, 727));
		label_11.setMaximumSize(new Dimension(500, 727));
		label_11.setBounds(519, 408, 100, 145);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("New label");
		label_12.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		label_12.setPreferredSize(new Dimension(500, 727));
		label_12.setMinimumSize(new Dimension(500, 727));
		label_12.setMaximumSize(new Dimension(500, 727));
		label_12.setBounds(633, 408, 100, 145);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("New label");
		label_13.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		label_13.setPreferredSize(new Dimension(500, 727));
		label_13.setMinimumSize(new Dimension(500, 727));
		label_13.setMaximumSize(new Dimension(500, 727));
		label_13.setBounds(745, 408, 100, 145);
		contentPane.add(label_13);
		
		JButton btnHit = new JButton("Hit");
		btnHit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnHit.setBounds(875, 408, 97, 47);
		contentPane.add(btnHit);
		
		JButton btnStay = new JButton("Stay");
		btnStay.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnStay.setBounds(875, 468, 97, 47);
		contentPane.add(btnStay);
		
		JLabel label_14 = new JLabel("New label");
		label_14.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/card_back.png")));
		label_14.setPreferredSize(new Dimension(500, 727));
		label_14.setMinimumSize(new Dimension(500, 727));
		label_14.setMaximumSize(new Dimension(500, 727));
		label_14.setBounds(64, 204, 100, 145);
		contentPane.add(label_14);
		
		JLabel lblComputerScore = new JLabel("Computer Total:");
		lblComputerScore.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblComputerScore.setBackground(Color.LIGHT_GRAY);
		lblComputerScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblComputerScore.setBounds(334, 204, 140, 24);
		contentPane.add(lblComputerScore);
		
		JLabel label_15 = new JLabel("0");
		label_15.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_15.setBackground(Color.LIGHT_GRAY);
		label_15.setHorizontalAlignment(SwingConstants.LEFT);
		label_15.setBounds(486, 204, 34, 24);
		contentPane.add(label_15);
		
		JLabel lblPlayerTotal = new JLabel("Player Total:");
		lblPlayerTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerTotal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPlayerTotal.setBackground(Color.LIGHT_GRAY);
		lblPlayerTotal.setBounds(334, 325, 140, 24);
		contentPane.add(lblPlayerTotal);
		
		JLabel label_17 = new JLabel("0");
		label_17.setHorizontalAlignment(SwingConstants.LEFT);
		label_17.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_17.setBackground(Color.LIGHT_GRAY);
		label_17.setBounds(486, 325, 34, 24);
		contentPane.add(label_17);
	}
}
