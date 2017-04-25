package blackJack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class blackJackGUI extends JFrame {
	static gameLogic gameObject = new gameLogic();
	
	static JLabel playerCardOne, playerCardTwo, playerCardThree, playerCardFour, playerCardFive, playerCardSix, playerCardSeven;	
	static JLabel comCardOne, comCardTwo, comCardThree, comCardFour, comCardFive, comCardSix, comCardSeven;
	static JLabel playerTotal, computerTotal;
	
	static JButton btnHit, btnStay;
	
	static JTextArea textArea;

	static int playCurrentCard = 1;
	static int comCurrentCard = 1;
	static int playerScore;
	
	String userName;
	String fileContents;
	
	boolean playBust = false;
	boolean comBust = false;
	
	static Card comCard;
	static Card playerCard;
	
	private JPanel gamePanel;
	private JPanel leaderBoardPanel;
	
	private JMenuBar menuBar;
	private JMenuItem menuItemGame;
	private JMenuItem menuItemLeaderBoard;
	private JTextField textField;

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
		setBounds(100, 100, 1009, 654);
		//generateLeaderBoardPanel();
		generateGamePanel();
		createMenuBar();
	}
	
	private void createMenuBar() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenuItem menuItemFiller = new JMenuItem("            ");
		JMenuItem menuItemFiller2 = new JMenuItem("           ");
		JMenuItem menuItemFiller3 = new JMenuItem("           ");
		JMenuItem menuItemFiller4 = new JMenuItem("           ");
		JMenuItem menuItemFiller5 = new JMenuItem("           ");
		menuItemGame = new JMenuItem("Game");
		menuItemGame.setSelected(true);
		menuItemGame.setHorizontalAlignment(SwingConstants.CENTER);
		menuItemGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Game Panel");
				leaderBoardPanel.setVisible(false);
				generateGamePanel();
				menuItemGame.setSelected(true);
				menuItemLeaderBoard.setSelected(false);
			}
		});
		menuItemLeaderBoard = new JMenuItem("Leader Board");
		menuItemLeaderBoard.setHorizontalAlignment(SwingConstants.LEFT);
		menuItemLeaderBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println("Leader Board");
				gamePanel.setVisible(false);
				generateLeaderBoardPanel();
				menuItemGame.setSelected(false);
				menuItemLeaderBoard.setSelected(true);
			}
		});
		menuBar.add(menuItemGame);
		menuBar.add(menuItemLeaderBoard);
		menuBar.add(menuItemFiller);
		menuBar.add(menuItemFiller2);
		menuBar.add(menuItemFiller3);
		menuBar.add(menuItemFiller4);
		menuBar.add(menuItemFiller5);	
	}
	
	private void generateLeaderBoardPanel() {
		leaderBoardPanel = new JPanel();
		leaderBoardPanel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		leaderBoardPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(leaderBoardPanel);
		leaderBoardPanel.setLayout(null);
		
		fileContents = "";
		fileContents = updateTextArea();
		
		textArea = new JTextArea(fileContents);
		textArea.setEditable(false);
		textArea.setBounds(261, 30, 449, 423);
		leaderBoardPanel.add(textArea);
		
		textField = new JTextField();
		textField.setBounds(271, 466, 221, 22);
		leaderBoardPanel.add(textField);
		textField.setColumns(10);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userName = textField.getText();
				try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File("src\\blackJack\\leaderBoard.txt"), true))) {
					
					String result = String.format("%s, %d%n", userName, playerScore);
					//System.out.println(result);
					pw.append(result);
					pw.close();
					
					fileContents = "";
					fileContents = updateTextArea();
					textArea.setText(fileContents + result);
					textArea.repaint();
					textArea.revalidate();
					//System.out.println(fileContents);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

			}
		});
		submitButton.setBounds(504, 466, 97, 25);
		leaderBoardPanel.add(submitButton);
		
		JButton playAgainButton = new JButton("Play Again");
		playAgainButton.setBounds(613, 466, 97, 25);
		leaderBoardPanel.add(playAgainButton);
		
		JLabel scoreLabel = new JLabel("Score:");
		scoreLabel.setBounds(831, 33, 56, 16);
		leaderBoardPanel.add(scoreLabel);
		
		JLabel score = new JLabel(String.valueOf(playerScore));
		score.setHorizontalAlignment(SwingConstants.LEFT);
		score.setBounds(899, 33, 56, 16);
		leaderBoardPanel.add(score);
	}
	
	private String updateTextArea() {
		StringBuilder sb = new StringBuilder();
		String nextLine = "";
		
		try(Scanner reader = new Scanner(blackJackGUI.class.getResourceAsStream("leaderBoard.txt"))) {
			while(reader.hasNextLine()) {
				nextLine = reader.nextLine();
				sb.append(nextLine + "\n");
				//System.out.println(nextLine);
			}
			reader.close();
		} catch(ArrayIndexOutOfBoundsException e) {
			
		}
		return sb.toString();
	}

	private void generateGamePanel() {
		gamePanel = new JPanel();
		gamePanel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		gamePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(gamePanel);
		gamePanel.setLayout(null);
		
		comCardOne = new JLabel();
		comCardOne.setMaximumSize(new Dimension(500, 727));
		comCardOne.setMinimumSize(new Dimension(500, 727));
		comCardOne.setPreferredSize(new Dimension(500, 727));
		comCardOne.setBounds(63, 39, 100, 145);
		gamePanel.add(comCardOne);
		
		comCardTwo = new JLabel();
		comCardTwo.setPreferredSize(new Dimension(500, 727));
		comCardTwo.setMinimumSize(new Dimension(500, 727));
		comCardTwo.setMaximumSize(new Dimension(500, 727));
		comCardTwo.setBounds(175, 39, 100, 145);
		gamePanel.add(comCardTwo);
		
		comCardThree = new JLabel();
		comCardThree.setPreferredSize(new Dimension(500, 727));
		comCardThree.setMinimumSize(new Dimension(500, 727));
		comCardThree.setMaximumSize(new Dimension(500, 727));
		comCardThree.setBounds(289, 39, 100, 145);
		gamePanel.add(comCardThree);
		
		comCardFour = new JLabel();
		comCardFour.setPreferredSize(new Dimension(500, 727));
		comCardFour.setMinimumSize(new Dimension(500, 727));
		comCardFour.setMaximumSize(new Dimension(500, 727));
		comCardFour.setBounds(401, 39, 100, 145);
		gamePanel.add(comCardFour);
		
		comCardFive = new JLabel();
		comCardFive.setPreferredSize(new Dimension(500, 727));
		comCardFive.setMinimumSize(new Dimension(500, 727));
		comCardFive.setMaximumSize(new Dimension(500, 727));
		comCardFive.setBounds(518, 39, 100, 145);
		gamePanel.add(comCardFive);
		
		comCardSix = new JLabel();
		comCardSix.setPreferredSize(new Dimension(500, 727));
		comCardSix.setMinimumSize(new Dimension(500, 727));
		comCardSix.setMaximumSize(new Dimension(500, 727));
		comCardSix.setBounds(632, 39, 100, 145);
		gamePanel.add(comCardSix);
		
		comCardSeven = new JLabel();
		comCardSeven.setPreferredSize(new Dimension(500, 727));
		comCardSeven.setMinimumSize(new Dimension(500, 727));
		comCardSeven.setMaximumSize(new Dimension(500, 727));
		comCardSeven.setBounds(744, 39, 100, 145);
		gamePanel.add(comCardSeven);
		
		playerCardOne = new JLabel();
		playerCardOne.setPreferredSize(new Dimension(500, 727));
		playerCardOne.setMinimumSize(new Dimension(500, 727));
		playerCardOne.setMaximumSize(new Dimension(500, 727));
		playerCardOne.setBounds(63, 434, 100, 145);
		gamePanel.add(playerCardOne);
		
		playerCardTwo = new JLabel();
		playerCardTwo.setPreferredSize(new Dimension(500, 727));
		playerCardTwo.setMinimumSize(new Dimension(500, 727));
		playerCardTwo.setMaximumSize(new Dimension(500, 727));
		playerCardTwo.setBounds(175, 434, 100, 145);
		gamePanel.add(playerCardTwo);
		
		playerCardThree = new JLabel();
		playerCardThree.setPreferredSize(new Dimension(500, 727));
		playerCardThree.setMinimumSize(new Dimension(500, 727));
		playerCardThree.setMaximumSize(new Dimension(500, 727));
		playerCardThree.setBounds(289, 434, 100, 145);
		gamePanel.add(playerCardThree);
		
		playerCardFour = new JLabel();
		playerCardFour.setPreferredSize(new Dimension(500, 727));
		playerCardFour.setMinimumSize(new Dimension(500, 727));
		playerCardFour.setMaximumSize(new Dimension(500, 727));
		playerCardFour.setBounds(401, 434, 100, 145);
		gamePanel.add(playerCardFour);
		
		playerCardFive = new JLabel();
		playerCardFive.setPreferredSize(new Dimension(500, 727));
		playerCardFive.setMinimumSize(new Dimension(500, 727));
		playerCardFive.setMaximumSize(new Dimension(500, 727));
		playerCardFive.setBounds(518, 434, 100, 145);
		gamePanel.add(playerCardFive);
		
		playerCardSix = new JLabel();
		playerCardSix.setPreferredSize(new Dimension(500, 727));
		playerCardSix.setMinimumSize(new Dimension(500, 727));
		playerCardSix.setMaximumSize(new Dimension(500, 727));
		playerCardSix.setBounds(632, 434, 100, 145);
		gamePanel.add(playerCardSix);
		
		playerCardSeven = new JLabel();
		playerCardSeven.setPreferredSize(new Dimension(500, 727));
		playerCardSeven.setMinimumSize(new Dimension(500, 727));
		playerCardSeven.setMaximumSize(new Dimension(500, 727));
		playerCardSeven.setBounds(744, 434, 100, 145);
		gamePanel.add(playerCardSeven);
		
		btnHit = new JButton("Hit");
		btnHit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				switch(playCurrentCard){
				case 1:
					playerCard = gameObject.cardInfo("player");
					playerCardOne.setText(playerCard.toString());
					playerTotal.setText(gameObject.generateHandTotal("player"));
					playerCardOne.setIcon(gameObject.placeCard(playerCard));
					playCurrentCard++;
					
					comCard = gameObject.cardInfo("computer");
					comCardOne.setText(comCard.toString());
					computerTotal.setText(gameObject.generateHandTotal("computer"));
					comCardOne.setIcon(gameObject.placeCard(comCard));
					comCurrentCard++;
					break;
				case 2:
					playerCard = gameObject.cardInfo("player"); 
					playerCardTwo.setText(playerCard.toString());
					playerTotal.setText(gameObject.generateHandTotal("player"));
					playerCardTwo.setIcon(gameObject.placeCard(playerCard));
					playCurrentCard++;
					
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 1) {
						comCard = gameObject.cardInfo("computer");
						comCardTwo.setText(comCard.toString());
						computerTotal.setText(gameObject.generateHandTotal("computer"));
						comCardTwo.setIcon(gameObject.placeCard(comCard));
						comCurrentCard++;
						if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
							btnStay.setEnabled(false);
						}
					}
					
					if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 0) {
						JOptionPane.showMessageDialog(null, "The player has won!");
						playerScore += 10;
						resetGUI();
					} else if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						JOptionPane.showMessageDialog(null, "The computer has won!");
						resetGUI();
					}
					break;
				case 3:
					playerCard = gameObject.cardInfo("player");
					playerCardThree.setText(playerCard.toString());
					playerTotal.setText(gameObject.generateHandTotal("player"));	
					playerCardThree.setIcon(gameObject.placeCard(playerCard));
					playCurrentCard++;
					
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 1) {
						comCard = gameObject.cardInfo("computer");
						comCardThree.setText(comCard.toString());
						computerTotal.setText(gameObject.generateHandTotal("computer"));
						comCardThree.setIcon(gameObject.placeCard(comCard));
						comCurrentCard++;
						if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
							btnStay.setEnabled(false);
						}
					}
					
					if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 2 && checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "It was a draw!");
						playerScore += 5;
						resetGUI();
					} else if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 0 || checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "The player has won!");
						playerScore += 10;
						resetGUI();
					} else if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 2 || checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						JOptionPane.showMessageDialog(null, "The computer has won!");
						resetGUI();
					} 
					break;
				case 4:
					playerCard = gameObject.cardInfo("player");
					playerCardFour.setText(playerCard.toString());
					playerTotal.setText(gameObject.generateHandTotal("player"));		
					playerCardFour.setIcon(gameObject.placeCard(playerCard));
					playCurrentCard++;
					
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 1) {
						comCard = gameObject.cardInfo("computer");
						comCardFour.setText(comCard.toString());
						computerTotal.setText(gameObject.generateHandTotal("computer"));
						comCardFour.setIcon(gameObject.placeCard(comCard));
						comCurrentCard++;
						if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
							btnStay.setEnabled(false);
						}
					}
					
					if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 2 && checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "It was a draw!");
						playerScore += 5;
						resetGUI();
					} else if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 0 || checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "The player has won!");
						playerScore += 10;
						resetGUI();
					} else if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 2 || checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						JOptionPane.showMessageDialog(null, "The computer has won!");
						resetGUI();
					} 
					break;
				case 5:
					playerCard = gameObject.cardInfo("player");
					playerCardFive.setText(playerCard.toString());
					playerTotal.setText(gameObject.generateHandTotal("player"));
					playerCardFive.setIcon(gameObject.placeCard(playerCard));
					playCurrentCard++;
					
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 1) {
						comCard = gameObject.cardInfo("computer");
						comCardFive.setText(comCard.toString());
						computerTotal.setText(gameObject.generateHandTotal("computer"));
						comCardFive.setIcon(gameObject.placeCard(comCard));
						comCurrentCard++;
						if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
							btnStay.setEnabled(false);
						}
					}
					
					if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 2 && checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "It was a draw!");
						playerScore += 5;
						resetGUI();
					} else if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 0 || checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "The player has won!");
						playerScore += 10;
						resetGUI();
					} else if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 2 || checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						JOptionPane.showMessageDialog(null, "The computer has won!");
						resetGUI();
					} 
					break;
				case 6:
					playerCard = gameObject.cardInfo("player");
					playerCardSix.setText(playerCard.toString());
					playerTotal.setText(gameObject.generateHandTotal("player"));
					playerCardSix.setIcon(gameObject.placeCard(playerCard));
					playCurrentCard++;
					
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 1) {
						comCard = gameObject.cardInfo("computer");
						comCardSix.setText(comCard.toString());
						computerTotal.setText(gameObject.generateHandTotal("computer"));
						comCardSix.setIcon(gameObject.placeCard(comCard));
						comCurrentCard++;
						if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
							btnStay.setEnabled(false);
						}
					}
					
					if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 2 && checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "It was a draw!");
						playerScore += 5;
						resetGUI();
					} else if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 0 || checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "The player has won!");
						playerScore += 10;
						resetGUI();
					} else if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 2 || checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						JOptionPane.showMessageDialog(null, "The computer has won!");
						resetGUI();
					} 
					break;
				case 7:
					playerCard = gameObject.cardInfo("player");
					playerCardSeven.setText(playerCard.toString());
					playerTotal.setText(gameObject.generateHandTotal("player"));	
					playerCardSeven.setIcon(gameObject.placeCard(playerCard));
					playCurrentCard++;
					
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 1) {
						comCard = gameObject.cardInfo("computer");
						comCardSeven.setText(comCard.toString());
						computerTotal.setText(gameObject.generateHandTotal("computer"));
						comCardSeven.setIcon(gameObject.placeCard(comCard));
						comCurrentCard++;
						if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
							btnStay.setEnabled(false);
						}
					}
					
					if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 2 && checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "It was a draw!");
						playerScore += 5;
						resetGUI();
					} else if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 0 || checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "The player has won!");
						playerScore += 10;
						resetGUI();
					} else if(checkForBlackJack(Integer.parseInt(playerTotal.getText())) == 2 || checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						JOptionPane.showMessageDialog(null, "The computer has won!");
						resetGUI();
					} 
					break;
				default:
					break;
				}
				
			}
		});
		btnHit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnHit.setBounds(868, 460, 97, 47);
		gamePanel.add(btnHit);
		
		btnStay = new JButton("Stay");
		btnStay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(comCurrentCard){
				case 1:
					comCard = gameObject.cardInfo("computer");
					comCardOne.setText(comCard.toString());
					computerTotal.setText(gameObject.generateHandTotal("computer"));
					comCardOne.setIcon(gameObject.placeCard(comCard));
					comCurrentCard++;
					break;
				case 2:
					comCard = gameObject.cardInfo("compter");
					comCardTwo.setText(comCard.toString());
					computerTotal.setText(gameObject.generateHandTotal("computer"));	
					comCardTwo.setIcon(gameObject.placeCard(comCard));
					comCurrentCard++;
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						btnStay.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The computer has won!");
						resetGUI();
					}
					break;
				case 3:
					comCard = gameObject.cardInfo("computer");
					comCardThree.setText(comCard.toString());
					computerTotal.setText(gameObject.generateHandTotal("computer"));
					comCardThree.setIcon(gameObject.placeCard(comCard));
					comCurrentCard++;
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						btnStay.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The computer has won!");
						resetGUI();
					} else if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "The player has won!");
						playerScore += 10;
						resetGUI();
					}
					break;
				case 4:
					comCard = gameObject.cardInfo("computer");
					comCardFour.setText(comCard.toString());
					computerTotal.setText(gameObject.generateHandTotal("computer"));
					comCardFour.setIcon(gameObject.placeCard(comCard));
					comCurrentCard++;
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						btnStay.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The computer has won!");
						resetGUI();
					} else if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "The player has won!");
						playerScore += 10;
						resetGUI();
					}
					break;
				case 5:
					comCard = gameObject.cardInfo("computer");
					comCardFive.setText(comCard.toString());
					computerTotal.setText(gameObject.generateHandTotal("computer"));	
					comCardFive.setIcon(gameObject.placeCard(comCard));
					comCurrentCard++;
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						btnStay.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The computer has won!");
						resetGUI();
					} else if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "The player has won!");
						playerScore += 10;
						resetGUI();
					}
					break;
				case 6:
					comCard = gameObject.cardInfo("computer");
					comCardSix.setText(comCard.toString());
					computerTotal.setText(gameObject.generateHandTotal("computer"));	
					comCardSix.setIcon(gameObject.placeCard(comCard));
					comCurrentCard++;
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						btnStay.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The computer has won!");
						resetGUI();
					} else if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "The player has won!");
						playerScore += 10;
						resetGUI();
					}
					break;
				case 7:
					comCard = gameObject.cardInfo("computer");
					comCardSeven.setText(comCard.toString());
					computerTotal.setText(gameObject.generateHandTotal("computer"));
					comCardSeven.setIcon(gameObject.placeCard(comCard));
					comCurrentCard++;
					if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 0) {
						btnStay.setEnabled(false);
						JOptionPane.showMessageDialog(null, "The computer has won!");
						resetGUI();
					} else if(checkForBlackJack(Integer.parseInt(computerTotal.getText())) == 2) {
						JOptionPane.showMessageDialog(null, "The player has won!");
						playerScore += 10;
						resetGUI();
					}
					break;
				default:
					break;
				}
			}
		});
		btnStay.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnStay.setBounds(868, 520, 97, 47);
		gamePanel.add(btnStay);
		
		JLabel dealerDeck = new JLabel("Game");
		dealerDeck.setIcon(new ImageIcon(blackJackGUI.class.getResource("/res/card_back.png")));
		dealerDeck.setPreferredSize(new Dimension(500, 727));
		dealerDeck.setMinimumSize(new Dimension(500, 727));
		dealerDeck.setMaximumSize(new Dimension(500, 727));
		dealerDeck.setBounds(63, 230, 100, 145);
		gamePanel.add(dealerDeck);
		
		JLabel computerTotalLabel = new JLabel("Computer Total:");
		computerTotalLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		computerTotalLabel.setBackground(Color.LIGHT_GRAY);
		computerTotalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		computerTotalLabel.setBounds(333, 230, 140, 24);
		gamePanel.add(computerTotalLabel);
		
		computerTotal = new JLabel("0");
		computerTotal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		computerTotal.setBackground(Color.LIGHT_GRAY);
		computerTotal.setHorizontalAlignment(SwingConstants.LEFT);
		computerTotal.setBounds(485, 230, 34, 24);
		gamePanel.add(computerTotal);
		
		JLabel playerTotalLabel = new JLabel("Player Total:");
		playerTotalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerTotalLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		playerTotalLabel.setBackground(Color.LIGHT_GRAY);
		playerTotalLabel.setBounds(333, 351, 140, 24);
		gamePanel.add(playerTotalLabel);
		
		playerTotal = new JLabel("0");
		playerTotal.setHorizontalAlignment(SwingConstants.LEFT);
		playerTotal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		playerTotal.setBackground(Color.LIGHT_GRAY);
		playerTotal.setBounds(485, 351, 34, 24);
		gamePanel.add(playerTotal);
	}
	
	public static int checkForBlackJack(int userHand) {
		if(userHand == 21) {
			return 0;
		} else if(userHand < 21) {
			return 1;
		} else if(userHand > 21) {
			return 2;
		} else {
			return 3;
		}
	}
	
	public static void resetGUI() {
		playerCardOne.setIcon(null);
		playerCardOne.setText("");
		playerCardTwo.setIcon(null);
		playerCardTwo.setText("");
		playerCardThree.setIcon(null);
		playerCardThree.setText("");
		playerCardFour.setIcon(null);
		playerCardFour.setText("");
		playerCardFive.setIcon(null);
		playerCardFive.setText("");
		playerCardSix.setIcon(null);
		playerCardSix.setText("");
		playerCardSeven.setIcon(null);
		playerCardSeven.setText("");
		comCardOne.setIcon(null);
		comCardOne.setText("");
		comCardTwo.setIcon(null);
		comCardTwo.setText("");
		comCardThree.setIcon(null);
		comCardThree.setText("");
		comCardFour.setIcon(null);
		comCardFour.setText("");
		comCardFive.setIcon(null);
		comCardFive.setText("");
		comCardSix.setIcon(null);
		comCardSix.setText("");
		comCardSeven.setIcon(null);
		comCardSeven.setText("");
		playerTotal.setText("");
		computerTotal.setText("");
		
		playCurrentCard = 1;
		comCurrentCard = 1;
		
		playerCard = null;
		comCard = null;
		
		gameObject.resetGame();
		btnStay.setEnabled(true);
		btnHit.setEnabled(true);
	}
}
