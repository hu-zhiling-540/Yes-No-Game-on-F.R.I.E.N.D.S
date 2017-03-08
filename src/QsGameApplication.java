package gameApplication;

import javax.swing.JFrame;

/**
 * A class that opens an application and sets the frame size
 * @author Zhiling
 *
 */
public class QsGameApplication	{

	/**
	 * main method starts the program
	 * @param args
	 */
	public static void main( String[] args )	{
		// create a new JFrame to hold ice cream maker panel
		JFrame gameFrame = new JFrame(" Questions Game on F.R.I.E.N.D.S");
 
		// set size
		gameFrame.setSize( 500, 340 );
 
		// create a gamePanel and add it
		gameFrame.add( new QsGameGUI() );
		// exit normally on closing the window
		gameFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 
		// show frame
		gameFrame.setVisible( true );
	}

}
