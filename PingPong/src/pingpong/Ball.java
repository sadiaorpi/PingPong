package pingpong;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*; 

/**
 * The Ball class creates a ball used in the game. The
 * ball will move randomly with an initial speed of 2.
 * 
 * @author sadiaorpi
 * @version 11/16/2021
 */
public class Ball extends Rectangle {
	
	Random random;
	int xVelocity;
	int yVelocity;
	int initialSpeed = 2;
	
	/**
	 * Constructor to instantiate the fields in the Ball class
	 * 
	 * @param x            The x direction of the ball
	 * @param y            The y direction of the ball
	 * @param width        The width of the ball
	 * @param height       The height of the ball
	 */
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		random = new Random();
		int randomXDirection = random.nextInt(2);
		if (randomXDirection == 0) {
			randomXDirection--;
		}
		
		SetXDir(randomXDirection * initialSpeed);
		
		int randomYDirection = random.nextInt(2);
		
		if(randomYDirection == 0) {
			
			randomYDirection--;
			
		}
		
		SetYDir(randomYDirection * initialSpeed);
		
		
	}
		
		/**
		 * Sets the x direction of the ball
		 * 
		 * @param randomDir       The x velocity will move in a random direction
		 */
		public void SetXDir(int randomDir) {
			xVelocity = randomDir;
		}
		
		/**
		 * Sets the y direction of the ball
		 * 
		 * @param randomDir      The y velocity will move in a random direction
		 */
		public void SetYDir(int randomDir) {
			yVelocity = randomDir;
		}
		
		/**
		 * Sets the x and y values to their velocities
		 */
		public void move() {
			
			x += xVelocity;
			y += yVelocity;
			
		}
		
		/**
		 * Displays the ball on the screen
		 * 
		 * @param g     The ball graphic
		 */
		public void draw(Graphics g) {
			
			g.setColor(Color.white);
			g.fillOval(x, y, height, width);
			
		
	}
	
	

	
}
