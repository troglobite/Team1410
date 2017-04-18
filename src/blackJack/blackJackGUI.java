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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class blackJackGUI extends JFrame {
	gameLogic gameObject = new gameLogic();
	
	JLabel playerCardOne, playerCardTwo, playerCardThree, playerCardFour, playerCardFive, playerCardSix, playerCardSeven;	
	JLabel comCardOne, comCardTwo, comCardThree, comCardFour, comCardFive, comCardSix, comCardSeven;
	JLabel playerTotal, computerTotal;
	
	JButton btnHit, btnStay;

	int playCurrentCard = 1;
	int comCurrentCard = 1;
	
	boolean playBust = false;
	boolean comBust = false;
	
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
		
		JLabel score = new JLabel("0");
		score.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		score.setBackground(Color.LIGHT_GRAY);
		score.setBounds(960, 13, 58, 16);
		contentPane.add(score);
		
		comCardOne = new JLabel("New label");
		//comCardOne.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		comCardOne.setMaximumSize(new Dimension(500, 727));
		comCardOne.setMinimumSize(new Dimension(500, 727));
		comCardOne.setPreferredSize(new Dimension(500, 727));
		comCardOne.setBounds(64, 13, 100, 145);
		contentPane.add(comCardOne);
		
		comCardTwo = new JLabel("New label");
		//comCardTwo.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		comCardTwo.setPreferredSize(new Dimension(500, 727));
		comCardTwo.setMinimumSize(new Dimension(500, 727));
		comCardTwo.setMaximumSize(new Dimension(500, 727));
		comCardTwo.setBounds(176, 13, 100, 145);
		contentPane.add(comCardTwo);
		
		comCardThree = new JLabel("New label");
		//comCardThree.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		comCardThree.setPreferredSize(new Dimension(500, 727));
		comCardThree.setMinimumSize(new Dimension(500, 727));
		comCardThree.setMaximumSize(new Dimension(500, 727));
		comCardThree.setBounds(290, 13, 100, 145);
		contentPane.add(comCardThree);
		
		comCardFour = new JLabel("New label");
		//comCardFour.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		comCardFour.setPreferredSize(new Dimension(500, 727));
		comCardFour.setMinimumSize(new Dimension(500, 727));
		comCardFour.setMaximumSize(new Dimension(500, 727));
		comCardFour.setBounds(402, 13, 100, 145);
		contentPane.add(comCardFour);
		
		comCardFive = new JLabel("New label");
		//comCardFive.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		comCardFive.setPreferredSize(new Dimension(500, 727));
		comCardFive.setMinimumSize(new Dimension(500, 727));
		comCardFive.setMaximumSize(new Dimension(500, 727));
		comCardFive.setBounds(519, 13, 100, 145);
		contentPane.add(comCardFive);
		
		comCardSix = new JLabel("New label");
		//comCardSix.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		comCardSix.setPreferredSize(new Dimension(500, 727));
		comCardSix.setMinimumSize(new Dimension(500, 727));
		comCardSix.setMaximumSize(new Dimension(500, 727));
		comCardSix.setBounds(633, 13, 100, 145);
		contentPane.add(comCardSix);
		
		comCardSeven = new JLabel("New label");
		//comCardSeven.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		comCardSeven.setPreferredSize(new Dimension(500, 727));
		comCardSeven.setMinimumSize(new Dimension(500, 727));
		comCardSeven.setMaximumSize(new Dimension(500, 727));
		comCardSeven.setBounds(745, 13, 100, 145);
		contentPane.add(comCardSeven);
		
		playerCardOne = new JLabel("New label");
		//playerCardOne.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		playerCardOne.setPreferredSize(new Dimension(500, 727));
		playerCardOne.setMinimumSize(new Dimension(500, 727));
		playerCardOne.setMaximumSize(new Dimension(500, 727));
		playerCardOne.setBounds(64, 408, 100, 145);
		contentPane.add(playerCardOne);
		
		playerCardTwo = new JLabel("New label");
		//playerCardTwo.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		playerCardTwo.setPreferredSize(new Dimension(500, 727));
		playerCardTwo.setMinimumSize(new Dimension(500, 727));
		playerCardTwo.setMaximumSize(new Dimension(500, 727));
		playerCardTwo.setBounds(176, 408, 100, 145);
		contentPane.add(playerCardTwo);
		
		playerCardThree = new JLabel("New label");
		//playerCardThree.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		playerCardThree.setPreferredSize(new Dimension(500, 727));
		playerCardThree.setMinimumSize(new Dimension(500, 727));
		playerCardThree.setMaximumSize(new Dimension(500, 727));
		playerCardThree.setBounds(290, 408, 100, 145);
		contentPane.add(playerCardThree);
		
		playerCardFour = new JLabel("New label");
		//playerCardFour.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		playerCardFour.setPreferredSize(new Dimension(500, 727));
		playerCardFour.setMinimumSize(new Dimension(500, 727));
		playerCardFour.setMaximumSize(new Dimension(500, 727));
		playerCardFour.setBounds(402, 408, 100, 145);
		contentPane.add(playerCardFour);
		
		playerCardFive = new JLabel("New label");
		//playerCardFive.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		playerCardFive.setPreferredSize(new Dimension(500, 727));
		playerCardFive.setMinimumSize(new Dimension(500, 727));
		playerCardFive.setMaximumSize(new Dimension(500, 727));
		playerCardFive.setBounds(519, 408, 100, 145);
		contentPane.add(playerCardFive);
		
		playerCardSix = new JLabel("New label");
		//playerCardSix.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		playerCardSix.setPreferredSize(new Dimension(500, 727));
		playerCardSix.setMinimumSize(new Dimension(500, 727));
		playerCardSix.setMaximumSize(new Dimension(500, 727));
		playerCardSix.setBounds(633, 408, 100, 145);
		contentPane.add(playerCardSix);
		
		playerCardSeven = new JLabel("New label");
		//playerCardSeven.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/2_of_clubs.png")));
		playerCardSeven.setPreferredSize(new Dimension(500, 727));
		playerCardSeven.setMinimumSize(new Dimension(500, 727));
		playerCardSeven.setMaximumSize(new Dimension(500, 727));
		playerCardSeven.setBounds(745, 408, 100, 145);
		contentPane.add(playerCardSeven);
		
		btnHit = new JButton("Hit");
		btnHit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				switch(playCurrentCard){
				case 1:
					playerCardOne.setText(gameObject.cardInfo("player"));
					playerTotal.setText(gameObject.generateHandTotal("player"));
					playCurrentCard++;
					
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 1) {
						comCardOne.setText(gameObject.cardInfo("computer"));
						computerTotal.setText(gameObject.generateHandTotal("computer"));
						comCurrentCard++;
					}
					
					if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 0) {
						btnHit.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The player has won!");
					} else if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 2) {
						btnHit.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The player has busted!");
					} else if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						btnStay.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The computer has won!");
					} else if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "The computer has busted!");
					}
					break;
				case 2:
					playerCardTwo.setText(gameObject.cardInfo("player"));
					playerTotal.setText(gameObject.generateHandTotal("player"));				
					playCurrentCard++;
					
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 1) {
						comCardTwo.setText(gameObject.cardInfo("computer"));
						computerTotal.setText(gameObject.generateHandTotal("computer"));
						comCurrentCard++;
					}
					
					if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 0) {
						btnHit.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The player has won!");
					} else if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 2) {
						btnHit.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The player has busted!");
					} else if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						btnStay.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The computer has won!");
					} else if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "The computer has busted!");
					}
					break;
				case 3:
					playerCardThree.setText(gameObject.cardInfo("player"));
					playerTotal.setText(gameObject.generateHandTotal("player"));				
					playCurrentCard++;
					
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 1) {
						comCardThree.setText(gameObject.cardInfo("computer"));
						computerTotal.setText(gameObject.generateHandTotal("computer"));
						comCurrentCard++;
					}
					
					if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 0) {
						btnHit.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The player has won!");
					} else if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 2) {
						btnHit.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The player has busted!");
					} else if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						btnStay.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The computer has won!");
					} else if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "The computer has busted!");
					}
					break;
				case 4:
					playerCardFour.setText(gameObject.cardInfo("player"));
					playerTotal.setText(gameObject.generateHandTotal("player"));				
					playCurrentCard++;
					
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 1) {
						comCardFour.setText(gameObject.cardInfo("computer"));
						computerTotal.setText(gameObject.generateHandTotal("computer"));
						comCurrentCard++;
					}
					
					if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 0) {
						btnHit.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The player has won!");
					} else if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 2) {
						btnHit.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The player has busted!");
					} else if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						btnStay.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The computer has won!");
					} else if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "The computer has busted!");
					}
					break;
				case 5:
					playerCardFive.setText(gameObject.cardInfo("player"));
					playerTotal.setText(gameObject.generateHandTotal("player"));				
					playCurrentCard++;
					
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 1) {
						comCardFive.setText(gameObject.cardInfo("computer"));
						computerTotal.setText(gameObject.generateHandTotal("computer"));
						comCurrentCard++;
					}
					
					if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 0) {
						btnHit.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The player has won!");
					} else if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 2) {
						btnHit.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The player has busted!");
					} else if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						btnStay.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The computer has won!");
					} else if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "The computer has busted!");
					}
					break;
				case 6:
					playerCardSix.setText(gameObject.cardInfo("player"));
					playerTotal.setText(gameObject.generateHandTotal("player"));		
					playCurrentCard++;
					
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 1) {
						comCardSix.setText(gameObject.cardInfo("computer"));
						computerTotal.setText(gameObject.generateHandTotal("computer"));
						comCurrentCard++;
					}
					
					if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 0) {
						btnHit.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The player has won!");
					} else if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 2) {
						btnHit.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The player has busted!");
					} else if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						btnStay.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The computer has won!");
					} else if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "The computer has busted!");
					}
					break;
				case 7:
					playerCardSeven.setText(gameObject.cardInfo("player"));
					playerTotal.setText(gameObject.generateHandTotal("player"));				
					playCurrentCard++;
					
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 1) {
						comCardSeven.setText(gameObject.cardInfo("computer"));
						computerTotal.setText(gameObject.generateHandTotal("computer"));
						comCurrentCard++;
					}
					
					if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 0) {
						btnHit.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The player has won!");
					} else if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 2) {
						btnHit.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The player has busted!");
					} else if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						btnStay.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The computer has won!");
					} else if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "The computer has busted!");
					}
					break;
				default:
					break;
				}
				
			}
		});
		btnHit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnHit.setBounds(875, 408, 97, 47);
		contentPane.add(btnHit);
		
		btnStay = new JButton("Stay");
		btnStay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(comCurrentCard){
				case 1:
					comCardOne.setText(gameObject.cardInfo("computer"));
					computerTotal.setText(gameObject.generateHandTotal("computer"));				
					comCurrentCard++;
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						btnStay.setEnabled(false);
					}
					break;
				case 2:
					comCardTwo.setText(gameObject.cardInfo("computer"));
					computerTotal.setText(gameObject.generateHandTotal("computer"));				
					comCurrentCard++;
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						btnStay.setEnabled(false);
					}
					break;
				case 3:
					comCardThree.setText(gameObject.cardInfo("computer"));
					computerTotal.setText(gameObject.generateHandTotal("computer"));				
					comCurrentCard++;
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						btnStay.setEnabled(false);
					}
					break;
				case 4:
					comCardFour.setText(gameObject.cardInfo("computer"));
					computerTotal.setText(gameObject.generateHandTotal("computer"));				
					comCurrentCard++;
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						btnStay.setEnabled(false);
					}
					break;
				case 5:
					comCardFive.setText(gameObject.cardInfo("computer"));
					computerTotal.setText(gameObject.generateHandTotal("computer"));				
					comCurrentCard++;
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						btnStay.setEnabled(false);
					}
					break;
				case 6:
					comCardSix.setText(gameObject.cardInfo("computer"));
					computerTotal.setText(gameObject.generateHandTotal("computer"));				
					comCurrentCard++;
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						btnStay.setEnabled(false);
					}
					break;
				case 7:
					comCardSeven.setText(gameObject.cardInfo("computer"));
					computerTotal.setText(gameObject.generateHandTotal("computer"));				
					comCurrentCard++;
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						btnStay.setEnabled(false);
					}
					break;
				default:
					break;
				}
			}
		});
		btnStay.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnStay.setBounds(875, 468, 97, 47);
		contentPane.add(btnStay);
		
		JLabel dealerDeck = new JLabel("New label");
		dealerDeck.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/card_back.png")));
		dealerDeck.setPreferredSize(new Dimension(500, 727));
		dealerDeck.setMinimumSize(new Dimension(500, 727));
		dealerDeck.setMaximumSize(new Dimension(500, 727));
		dealerDeck.setBounds(64, 204, 100, 145);
		contentPane.add(dealerDeck);
		
		JLabel computerTotalLabel = new JLabel("Computer Total:");
		computerTotalLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		computerTotalLabel.setBackground(Color.LIGHT_GRAY);
		computerTotalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		computerTotalLabel.setBounds(334, 204, 140, 24);
		contentPane.add(computerTotalLabel);
		
		computerTotal = new JLabel("0");
		computerTotal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		computerTotal.setBackground(Color.LIGHT_GRAY);
		computerTotal.setHorizontalAlignment(SwingConstants.LEFT);
		computerTotal.setBounds(486, 204, 34, 24);
		contentPane.add(computerTotal);
		
		JLabel playerTotalLabel = new JLabel("Player Total:");
		playerTotalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerTotalLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		playerTotalLabel.setBackground(Color.LIGHT_GRAY);
		playerTotalLabel.setBounds(334, 325, 140, 24);
		contentPane.add(playerTotalLabel);
		
		playerTotal = new JLabel("0");
		playerTotal.setHorizontalAlignment(SwingConstants.LEFT);
		playerTotal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		playerTotal.setBackground(Color.LIGHT_GRAY);
		playerTotal.setBounds(486, 325, 34, 24);
		contentPane.add(playerTotal);
	}
	
	public static int checkForBlackJack(int userHand) {
		if(userHand == 21) {
			return 0;
		} else if(userHand < 21) {
			return 1;
		} else {
			return 2;
		}
	}
}
