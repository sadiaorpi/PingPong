package pingpong;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * The Scoreboard class keeps track of points 
 * made by both players
 * 
 * @author sadiaorpi
 * @version 11/16/2021
 */
public class Scoreboard extends Rectangle {
	
	static int GAME_WIDTH;
	static int GAME_HEIGHT;
	int player1;
	int player2;
	
	/**
	 * Constructor to instantiate the fields in the Scoreboard class
	 * 
	 * @param width     Width of the scoreboard
	 * @param height    Height of the scoreboard
	 */
	public Scoreboard(int width, int height) {
		
		Scoreboard.GAME_WIDTH = width;
		Scoreboard.GAME_HEIGHT = height;
		
	}
	
	/**
	 * Displays the Scoreboard graphics
	 * 
	 * @param g     The Scoreboard
	 */
	public void draw(Graphics g) {
		
		g.setColor(Color.white);
		g.setFont(new Font("Consolas", Font.PLAIN, 60));
		
		g.drawLine(GAME_WIDTH / 2, 0, GAME_WIDTH / 2, GAME_HEIGHT);
		g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), (GAME_WIDTH / 2)-85, 50);
		g.drawString(String.valueOf(player2), (GAME_WIDTH / 2)+20, 50);
		
	}
	

}
