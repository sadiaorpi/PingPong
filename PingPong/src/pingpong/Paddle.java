package pingpong;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * The Paddle class creates two paddles used in the game. One paddle
 * will be controlled by the computer while the other will move up and
 * down by the user. 
 * 
 * @author sadiaorpi
 * @version 11/16/2021
 */
public class Paddle extends Rectangle {
	
	int id;
	int yVel;
	int speed = 10;
	
	/**
	 * Constructor to instantiate the fields in the Paddle class
	 * 
	 * @param x                X direction
	 * @param y                Y direction
	 * @param PADDLE_WIDTH     The width of the paddles
	 * @param PADDLE_HEIGHT    The height of the paddles
	 * @param id               Paddle number
	 */
	public Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
		super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
		this.id = id;
		// System.out.println("Paddle:: Paddle " + x + " " + y + " " + PADDLE_WIDTH) ;
	}
	
	/**
	 * Displays the paddle graphics
	 * 
	 * @param g     Paddle graphic
	 */
	public void draw(Graphics g) {
		
		if (id == 1) {
			
			g.setColor(Color.blue);
			
		}
		else {
			
			g.setColor(Color.red);
			
		}
		
		g.fillRect(x, y, width, height);
		
		
	}
	
	/**
	 * Sets the y direction of the paddles
	 * 
	 * @param yDir     Y direction
	 */
	public void setYDir(int yDir) {
		yVel = yDir;
	}
	
	/**
	 * Moves the paddle by setting y to the y velocity
	 */
	public void move() {
		
		y += yVel;
		
	}
	
	/**
	 * Moves the paddle when a user presses a key
	 * 
	 * @param e     Key
	 */
	public void keyPressed(KeyEvent e) {
		switch(id) {
		
		case 1:
			if (e.getKeyCode() == KeyEvent.VK_W) {
				setYDir(-speed);
				move();
			}
			if(e.getKeyCode() == KeyEvent.VK_S) {
				setYDir(speed);
				move();
			}
			break;
			
			case 2:
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				setYDir(-speed);
				move();
				
			}
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYDir(speed);
				move();
				
			}
			
			break;	
			
		
		}
	}
	
	/**
	 * Stops the paddle when a user releases a key
	 * 
	 * @param e     Key
	 */
	public void keyReleased(KeyEvent e) {
		switch(id) {
		
		case 1:
			if (e.getKeyCode() == KeyEvent.VK_W) {
				setYDir(0);
				move();
			}
			if(e.getKeyCode() == KeyEvent.VK_S) {
				setYDir(0);
				move();
			}
			break;
			
			case 2:
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				setYDir(0);
				move();
				
			}
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYDir(0);
				move();
				
			}
			
			break;	
		
		
		}
	}
	
	

}
