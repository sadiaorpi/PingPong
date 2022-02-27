package pingpong;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * The GameFrame class creates the window for the game
 * 
 * @author sadiaorpi
 * @version 11/16/2021
 */
public class GameFrame extends JFrame {
	
	GamePanel panel;    
	GameFrame()
	{

	panel = new GamePanel();
	this.add(panel);                                        // add the game panel to the frame
	this.setTitle("Pong");                                  // window title
	this.setResizable(false);                               // can not be re-sized
	this.setBackground(Color.black);                        // Background color
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // closes app when x button is enabled
	this.pack();                                            // adjust 
	this.setVisible(true);                                  // make the frame visible
	this.setLocationRelativeTo(null);                       // appear in middle of screen


	}
} 
