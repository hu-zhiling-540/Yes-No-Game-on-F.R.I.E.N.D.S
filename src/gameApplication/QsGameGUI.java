package gameApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import datastructures.QsGameNode;
import datastructures.QsGameTree;

/**
 * A panel that holds all the gui elements
 * @author Zhiling
 */
public class QsGameGUI extends JPanel implements ActionListener
{
	// panels
	JPanel qsPanel;
	JPanel buttonPanel;
	JPanel logPanel;
	JPanel picPanel = new JPanel();
	
	JButton yesButton;
	JButton noButton;
	
	JLabel question;
	JLabel log;
	
	protected QsGameTree tree = new QsGameTree(); 
	protected QsGameNode currParent = new QsGameNode(); 
	protected QsGameNode current = new QsGameNode();
	
	private static Font font = new Font("Monospaced", Font.BOLD, 14);
	
	
	/**
	 * Constructor
	 */
	public QsGameGUI()
	{
		super();
		
		// take in the xml file
		tree = QsGameFileReader.readXML( "twentyquestions.xml");
	    current = tree.getRoot();
	    
	    initGUI();
		
	}

	/**
	 * Starts building up GUI elements 
	 */
	private void initGUI() {
		setLayout(new BorderLayout());
		add(createPicPanel(), BorderLayout.NORTH );
		add(createQsPanel(), BorderLayout.CENTER );
		add(createButtonPanel(),BorderLayout.SOUTH);
	}

	
	
	/**
	 * A panel that contains yes and no buttons
	 * @return
	 */
	private JPanel createButtonPanel() {
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,2));
		
		buttonPanel.add(createYesButton());
		buttonPanel.add(createNoButton());
		
		return buttonPanel;
	}
	
	
	
	/**
	 * Creates a panel that holds the picture
	 * @return
	 */
	public JPanel createPicPanel()	{
		JLabel picLabel = new JLabel(" ");
		ImageIcon icon = new ImageIcon(this.getClass().getResource("friends.jpg"), "friends");
		Image image = icon.getImage();
		Image newimg = image.getScaledInstance(500, 250, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		picLabel.setIcon(icon);
		picPanel.add(picLabel);
		
		return picPanel;
	}
	
	
	/**
	 * Creates a button for yes
	 * @return
	 */
	private JButton createYesButton()	{
		yesButton = new JButton("Yes.");
		yesButton.addActionListener(this);
        
		return yesButton;
	}
	
	
	
	/**
	 * Creates a button for no
	 * @return
	 */
	private JButton createNoButton()	{
		noButton = new JButton("No.");
		noButton.addActionListener(this);
		return noButton;
	}
	
	
	
	/**
	 * A panel that displays the question
	 * @return
	 */
	private JPanel createQsPanel()	{
		qsPanel = new JPanel();
		qsPanel.setBackground(Color.LIGHT_GRAY);
		
		question = new JLabel(current.getData());
		question.setFont(font);
		qsPanel.add(question);
		
		return qsPanel;
	}
	
	
	/**
	 * Updates the question label
	 * @return
	 */
	private void updateQs()	{
		String q = current.getData();
		question.setText("<html>"+ q + "</html>");
	}
	
	
	
	/**
	 * Ask questions to the user if this is right answer
	 * @param character
	 */
	private void confirmAnswer(String character)	{
		question.setText("It looks like it is " + character + "." );
	}
	
	
	
	/**
	 * When the buttons are hit, they perform certain action
	 */
	@Override
	public void actionPerformed(ActionEvent e)	{
		String answer = "";
		
		// if hit yes button, go left
		if (e.getSource().equals(yesButton))	{
			currParent = current;
			current = current.getLeftChild();
			if (!current.isLeaf())	{
				updateQs();
	            repaint();
			}
			
			// if it is leaf, hit the bottom, gonna ask if this is correct
			else	{
				answer = current.getData();
				confirmAnswer(answer);
				newChar(answer);
				repaint();
			}
		}
		
		// if no button, go right
		if (e.getSource().equals(noButton))	{
			currParent = current;
			current = current.getRightChild();
			
			// if it is not leaf, keep asking
			if (!current.isLeaf())	{
				updateQs();
	            repaint();
			}
			// if it is leaf, hit the bottom, gonna ask if this is correct
			else if (current.isLeaf())	{
				answer = current.getData();
				confirmAnswer(answer);
				newChar(answer);
				repaint();	
			}
		}
		
	}
	
	/**
	 * asking the user 
	 * check if this answer is correct
	 * @param answer
	 */
	private void newChar(String answer)	{
		Object[] options = {"Yes!",
                "No!",
                "I forgot!"};
		// create an option dialog
		int n = JOptionPane.showOptionDialog(this,
			    "Is the charcter " + answer + " ?", "Confirmation", 
			    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
			    null, //do not use a custom Icon
			    options, //the titles of buttons
			    options[0]); //default button title
		
		// if the guess is correct
		if (n == JOptionPane.YES_OPTION)	{
			JOptionPane.showMessageDialog(null, // frame
				    "I know I am right!!");
			
			// restarts the game
	    	current = tree.getRoot();
	    	updateQs(); // update the display label
		}
		
		// if the guess is incorrect
		else if (n == JOptionPane.NO_OPTION)	{
			// tap in answer
			String newAnswer = JOptionPane.showInputDialog(this, "If not "
					+ answer + ", Who you are?");
			// create a new node that represents this answer
			QsGameNode newAnsNode = new QsGameNode();
			newAnsNode.setData(newAnswer);
			
			// tap in questions
			String newQuestion = JOptionPane.showInputDialog(this, "What's you question?");
			// create a new node that represents this new question
			QsGameNode newQNode = new QsGameNode();
		    newQNode.setData(newQuestion);
		    
		    if (currParent.getLeftChild().equals(current))	{
		    	newQNode.setLeftChild(current);
		    	// new game node is no to the new answer
		    	newQNode.setRightChild(newAnsNode);
		    	
		    	currParent.setLeftChild(newQNode);
		    	
		    	// restarts the game
		    	current = tree.getRoot();
		    	updateQs(); // update the display label
		    	logPanel.add(new JLabel(newAnswer));	
		    }
		    
		    else if (currParent.getRightChild().equals(current))	{
		    	newQNode.setLeftChild(current);
		    	// new game node is no to the new answer
		    	newQNode.setRightChild(newAnsNode);
		    	
		    	currParent.setRightChild(newQNode);
		    	
		    	// restarts the game
		    	current = tree.getRoot();
		    	updateQs();
		    	logPanel.add(new JLabel(newAnswer));
		    	
		    }
			
		}
		
	}

}
