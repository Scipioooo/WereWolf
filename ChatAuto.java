package wereWolf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ChatAuto extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8690273240703031863L;
	
	private Document doc;
	private SimpleAttributeSet attributSet;
	private JTextPane chatPan;
	private JScrollPane scrollPane;
	
	public static void main (String[] args) {
		new ChatAuto();
	}
	
	public ChatAuto () {
		this.initComponents();
		this.displayNightSentence(2);
		this.displayPlayerDeath(0, 32);
	}
	
	public void initComponents() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(this);
		frame.setSize(490, 400);
		
		this.setLayout(new BorderLayout(15, 15)); 
		this.setBackground(Color.red); 
		this.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		
		JPanel jtextPan = new JPanel();
		jtextPan.setLayout(new BorderLayout());
		
		JLabel vide1 = new JLabel();
		JLabel vide2 = new JLabel();
		JLabel vide3 = new JLabel();
		JLabel vide4 = new JLabel();
		
		scrollPane = new JScrollPane();
		
		chatPan = new JTextPane();
		chatPan.setEditable(false);
		chatPan.add(scrollPane);
		
		attributSet = new SimpleAttributeSet();
		chatPan.setCharacterAttributes(attributSet, true);
		chatPan.setBackground(new Color(128, 139, 150));
		
		StyleConstants.setFontSize(attributSet, 16);
		
		doc = chatPan.getStyledDocument();		
		
		jtextPan.add(chatPan, BorderLayout.CENTER);
		
		//create a component at each side to be able to resize as we want the chat 
		this.add(vide1, BorderLayout.SOUTH);
		this.add(vide2, BorderLayout.EAST);
		this.add(vide3, BorderLayout.WEST);
		this.add(vide4, BorderLayout.NORTH);
		this.add(jtextPan, BorderLayout.CENTER);
		
		//able to have the jlist in foreground
		frame.repaint();
		frame.revalidate();
	}
	
	/**
	 * display a sentence to introduce the day/night
	 * @param param - 0 to display the day, 1 to display the night
	 * @param cpt - the day/night number
	 */
	protected void displayDayNight (int param, int cpt) {
		if (param == 0) {
			try {
				chatPan.setEditable(true);
				
				StyleConstants.setForeground(attributSet, Color.white);
				String str = "Le jour ";
				doc.insertString(doc.getLength(), str, attributSet);
				
				StyleConstants.setForeground(attributSet, new Color(0, 0, 200));
				StyleConstants.setBold(attributSet, true);
				str = "" + cpt;
				doc.insertString(doc.getLength(), str, attributSet);

				StyleConstants.setBold(attributSet, false);
				StyleConstants.setForeground(attributSet, Color.white);
				str = " commence !\r\n";
				doc.insertString(doc.getLength(), str, attributSet);
				
				chatPan.setEditable(false);
				
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}else if (param == 1) {
			try {
				chatPan.setEditable(true);
				
				StyleConstants.setForeground(attributSet, Color.white);
				String str = "La nuit ";
				doc.insertString(doc.getLength(), str, attributSet);
				
				StyleConstants.setForeground(attributSet, new Color(220, 0, 0));
				StyleConstants.setBold(attributSet, true);
				str = "" + cpt;
				doc.insertString(doc.getLength(), str, attributSet);

				StyleConstants.setBold(attributSet, false);
				StyleConstants.setForeground(attributSet, Color.white);
				str = " commence !\r\n";
				doc.insertString(doc.getLength(), str, attributSet);
				
				chatPan.setEditable(false);
				
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * display a sentence to describe the player that died
	 * @param param - 0 if dead in night, 1 if votes by the village
	 * @param noPlayer - player number
	 */
	protected void displayPlayerDeath (int param, int noPlayer) {
		
		if (param == 0 ) {
			try {
				chatPan.setEditable(true);
				
				StyleConstants.setForeground(attributSet, Color.white);
				String str = "Le joueur  ";
				doc.insertString(doc.getLength(), str, attributSet);
				
				StyleConstants.setForeground(attributSet, new Color(220, 0, 0));
				StyleConstants.setBold(attributSet, true);
				str = "" + noPlayer;
				doc.insertString(doc.getLength(), str, attributSet);

				StyleConstants.setBold(attributSet, false);
				StyleConstants.setForeground(attributSet, Color.white);
				str = " à été tué !\r\n";
				doc.insertString(doc.getLength(), str, attributSet);
				
				chatPan.setEditable(false);
				
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}else if (param == 1) {
			try {
				chatPan.setEditable(true);
				
				StyleConstants.setForeground(attributSet, Color.white);
				String str = "Le village à éliminé le joueur  ";
				doc.insertString(doc.getLength(), str, attributSet);
				
				StyleConstants.setForeground(attributSet, new Color(220, 0, 0));
				StyleConstants.setBold(attributSet, true);
				str = "" + noPlayer;
				doc.insertString(doc.getLength(), str, attributSet);
				
				StyleConstants.setBold(attributSet, false);
				StyleConstants.setForeground(attributSet, Color.white);
				str = " !\r\n";
				doc.insertString(doc.getLength(), str, attributSet);
				
				chatPan.setEditable(false);
				
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * display the default first night sentence
	 */
	protected void displayDefaultNightSentence () {
		try {
			chatPan.setEditable(true);
			
			StyleConstants.setForeground(attributSet, Color.white);
			String str = "Rien à faire pour le moment, rendormez-vous !\r\n";
			doc.insertString(doc.getLength(), str, attributSet);
			
			chatPan.setEditable(false);
			
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * display a sentence in function of the parameter
	 * @param nb - 0 wereWolf sentence, 1 cupid sentence, 2 guard sentence, 3 murder sentence, 4 witch sentence and 5 seer sentence
	 */
	protected void displayNightSentence (int nb) {
		if (nb == 0 ) {
			try {
				chatPan.setEditable(true);
				
				StyleConstants.setForeground(attributSet, Color.white);
				String str = "Vote pour la personne que tu veux tuer !\r\n";
				doc.insertString(doc.getLength(), str, attributSet);
				
				chatPan.setEditable(false);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
			
		}else if (nb == 1) {
			try {
				chatPan.setEditable(true);
				
				StyleConstants.setForeground(attributSet, Color.white);
				String str = "Choisis deux amoureux <3 !\r\n";
				doc.insertString(doc.getLength(), str, attributSet);

				chatPan.setEditable(false);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}else if (nb == 2) {
			try {
				chatPan.setEditable(true);
				
				StyleConstants.setForeground(attributSet, Color.white);
				String str = "Choisis une personne à protéger !\r\n";
				doc.insertString(doc.getLength(), str, attributSet);

				chatPan.setEditable(false);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}else if (nb == 3) {
			try {
				chatPan.setEditable(true);
				
				StyleConstants.setForeground(attributSet, Color.white);
				String str = "Choisis une personne à assassiner !\r\n";
				doc.insertString(doc.getLength(), str, attributSet);

				chatPan.setEditable(false);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}else if (nb == 4) {
			try {
				chatPan.setEditable(true);
				
				StyleConstants.setForeground(attributSet, Color.white);
				String str = "Choisis une personne à tuer ou protéger !\r\n";
				doc.insertString(doc.getLength(), str, attributSet);

				chatPan.setEditable(false);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}else if (nb == 5) {
			try {
				chatPan.setEditable(true);
				
				StyleConstants.setForeground(attributSet, Color.white);
				String str = "Choisis une personne pour révéler son rôle !\r\n";
				doc.insertString(doc.getLength(), str, attributSet);

				chatPan.setEditable(false);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * display the chatty werewolf sentence
	 * @param word - the word to say
	 */
	protected void displayChattyWereWolf(String word) {
		try {
			chatPan.setEditable(true);
			
			StyleConstants.setForeground(attributSet, Color.white);
			String str = "Tu dois placer \"";
			doc.insertString(doc.getLength(), str, attributSet);
			
			StyleConstants.setForeground(attributSet, new Color(0, 0, 200));
			StyleConstants.setBold(attributSet, true);
			str = "" + word;
			doc.insertString(doc.getLength(), str, attributSet);

			StyleConstants.setBold(attributSet, false);
			StyleConstants.setForeground(attributSet, Color.white);
			str = "\" dans le chat au levé du prochain jour ! \r\n";
			doc.insertString(doc.getLength(), str, attributSet);
			
			chatPan.setEditable(false);
			
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param param - 0 if the village won, 1 if the werewolves won, 2 if the fool won, 3 if the murderer won, 4 if the head hunter won
	 */
	protected void displayWinner (int param) {
		if (param == 0) {
			try {
				chatPan.setEditable(true);
				
				StyleConstants.setForeground(attributSet, new Color(220, 0, 0));
				StyleConstants.setBold(attributSet, true);
				String str = "Le village à gagné !\r\n";
				doc.insertString(doc.getLength(), str, attributSet);
				
				chatPan.setEditable(false);
				
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}else if (param == 1) {
			try {
				chatPan.setEditable(true);
				
				StyleConstants.setForeground(attributSet, new Color(220, 0, 0));
				StyleConstants.setBold(attributSet, true);
				String str = "Les loups-garous ont gagnés !\r\n";
				doc.insertString(doc.getLength(), str, attributSet);
				
				chatPan.setEditable(false);
				
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}else if (param == 2) {
			try {
				chatPan.setEditable(true);
				
				StyleConstants.setForeground(attributSet, new Color(220, 0, 0));
				StyleConstants.setBold(attributSet, true);
				String str = "Le fou à gagné !\r\n";
				doc.insertString(doc.getLength(), str, attributSet);
				
				chatPan.setEditable(false);
				
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}else if (param == 3) {
			try {
				chatPan.setEditable(true);
				
				StyleConstants.setForeground(attributSet, new Color(220, 0, 0));
				StyleConstants.setBold(attributSet, true);
				String str = "L'assassin à gagné !\r\n";
				doc.insertString(doc.getLength(), str, attributSet);
				
				chatPan.setEditable(false);
				
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}else if (param == 4) {
			try {
				chatPan.setEditable(true);
				
				StyleConstants.setForeground(attributSet, new Color(220, 0, 0));
				StyleConstants.setBold(attributSet, true);
				String str = "Le chasseur de tête à gagné !\r\n";
				doc.insertString(doc.getLength(), str, attributSet);
				
				chatPan.setEditable(false);
				
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @param nbVote - number of vote required to eliminate someone
	 */
	protected void displayVote(int nbVote) {
		try {
			chatPan.setEditable(true);
			
			StyleConstants.setForeground(attributSet, Color.white);
			String str = "Soyez prêt à voter ! (";
			doc.insertString(doc.getLength(), str, attributSet);
			
			StyleConstants.setForeground(attributSet, new Color(220, 0, 0));
			StyleConstants.setBold(attributSet, true);
			str = "" + nbVote;
			doc.insertString(doc.getLength(), str, attributSet);

			StyleConstants.setBold(attributSet, false);
			StyleConstants.setForeground(attributSet, Color.white);
			str = " votes requis !)\r\n";
			doc.insertString(doc.getLength(), str, attributSet);
			
			chatPan.setEditable(false);
			
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param noPlayer - the player killed by the hunter
	 */
	protected void displayHunterRevenge (int noPlayer) {
		try {
			chatPan.setEditable(true);
			
			StyleConstants.setForeground(attributSet, Color.white);
			String str = "Le chasseur s'est vengé sur le joueur ";
			doc.insertString(doc.getLength(), str, attributSet);
			
			StyleConstants.setForeground(attributSet, new Color(220, 0, 0));
			StyleConstants.setBold(attributSet, true);
			str = "" + noPlayer;
			doc.insertString(doc.getLength(), str, attributSet);

			StyleConstants.setBold(attributSet, false);
			StyleConstants.setForeground(attributSet, Color.white);
			str = " !)\r\n";
			doc.insertString(doc.getLength(), str, attributSet);
			
			chatPan.setEditable(false);
			
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	protected void paintComponent(Graphics g) {
		
		Insets insets = getInsets();
		int x = insets.left;
		int y = insets.top;
		int w = getWidth() - insets.left - insets.right;
		int h = getHeight() - insets.top - insets.bottom;
		g.setColor(new Color(63, 81, 181));
		g.fillRoundRect(x, y, w, h, 20, 20);
		
		g.setColor(new Color(128, 139, 150));
		g.fillRoundRect(x+10, y+10, w-20, h-20, 20, 20);

	}

}
