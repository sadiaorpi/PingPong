package pingpong;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * The GamePanel class creates and adds all the attributes to the game,
 * including the ball, paddles, and scoreboard.
 * 
 * @author sadiaorpi
 * @version 11/16/2021
 */
public class GamePanel extends JPanel implements Runnable {
	
	Thread gameThread;
	
	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int)(GAME_WIDTH * 0.5555555);
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	static final int BALL_DIAMETER = 20;
	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 100;
	
	Paddle paddle1;
	Paddle paddle2;
	
	Image image;
	Graphics graphics;
	
	Ball ball;
	
	Scoreboard score;
	
	
	/**
	 * Constructor to instantiate fields in the GamePanel class
	 */
	public GamePanel() {  
	this.setFocusable(true);
	this.addKeyListener(new myActionListener());
	this.setPreferredSize(SCREEN_SIZE);
	
	gameThread = new Thread(this);
	gameThread.start();
	
	newPaddles();
	newBall();
	
	score = new Scoreboard(GAME_WIDTH, GAME_HEIGHT);
	
	}
	
	/**
	 * Creates a new ball in the game
	 */
	public void newBall() {
		ball = new Ball((GAME_WIDTH/2) - (BALL_DIAMETER/2), (GAME_HEIGHT/2) - (BALL_DIAMETER/2), BALL_DIAMETER, BALL_DIAMETER);
	}
	
	/**
	 * Creates two paddles in the game
	 */
	public void newPaddles() {
		
		paddle1 = new Paddle(0, (GAME_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
		paddle2 = new Paddle(GAME_WIDTH - PADDLE_WIDTH, (GAME_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 2);
		
	}
	
	/**
	 * 
	 */
	public void paint(Graphics g) {
		
		//System.out.println("Enter GamePane::Paint()");
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
		
	}
	
	/**
	 * Displays the paddles, ball, and scoreboard on the game panel
	 * 
	 * @param g     Graphics for each object
	 */
	public void draw(Graphics g) {
		
		//System.out.println("Enter GamePanel():: draw()");
		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);
		score.draw(g);
		
	}
	
	/**
	 * Moves the paddles and balls
	 */
	public void  move() {
		
		paddle1.move();
		paddle2.move();
		ball.move();
		
	}
	
	/**
	 * Checks for collisions between the paddles
	 * and balls then adds points on to the scoreboard
	 */
	public void CheckForCollisions() {
		
		if(paddle1.y <= 0) {
			paddle1.y = 0;
		}
		if(paddle1.y >= (GAME_HEIGHT - PADDLE_HEIGHT)){
			paddle1.y = (GAME_HEIGHT - PADDLE_HEIGHT);
		}
		if(paddle2.y <= 0) {
			paddle2.y = 0;
		}
		if(paddle2.y >= (GAME_HEIGHT - PADDLE_HEIGHT)){
			paddle2.y = (GAME_HEIGHT - PADDLE_HEIGHT);
		}
		
		// Check Ball collisions for top and bottom 
		
		if (ball.y <= 0) {
			ball.SetYDir(-ball.yVelocity);
		}
		if(ball.y >= (GAME_HEIGHT - BALL_DIAMETER)) {
			ball.SetYDir(-ball.yVelocity);
		}
		
		//Impulse with paddle
		if(ball.intersects(paddle1)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++;
			
			
		if(ball.yVelocity > 0) {
			ball.yVelocity++;
		}
		else {
			ball.yVelocity--;
		}
		ball.SetXDir(ball.xVelocity);
		ball.SetYDir(ball.yVelocity);
			
		}
		
		if(ball.intersects(paddle2)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++;
			
			
		if(ball.yVelocity > 0) {
			ball.yVelocity++;
		}
		else {
			ball.yVelocity--;
		}
		ball.SetXDir(-ball.xVelocity);
		ball.SetYDir(ball.yVelocity);
			
		}
		
		if(ball.x <= 0) {
			score.player2++;
			newPaddles();
			newBall();
			System.out.println("Player2 " + score.player2);
		}
		
		if(ball.x >= GAME_WIDTH - BALL_DIAMETER) {
			score.player1++;
			newPaddles();
			newBall();
			System.out.println("Player1 " + score.player1);
		}
		
	
	}
	
	/**
	 * Runs the game loop
	 */
	public void run() {
	long lastTime = System.nanoTime();
	double amoutOfTicks = 60.0;
	double ns = 1000000000 / amoutOfTicks;
	double delta = 0;
	
		while(true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
				if (delta >= 1) {
				move();
				CheckForCollisions();
				repaint();
				delta--;
				//System.out.println("TEST");
			}
		}
		
	}
	
	/**
	 * The myActionListener class handles all events
	 * when the user clicks a key to move the paddles
	 * 
	 * @author sadiaorpi
	 * @version 11/16/2021
	 */
	public class myActionListener extends KeyAdapter {
		
		/**
		 * User presses a key to move the paddle
		 */
		public void keyPressed(KeyEvent e) {
		paddle1.keyPressed(e);
		paddle2.keyPressed(e);
		}
	
		/**
		 * User releases a key to stop the paddle
		 */
		public void keyReleased(KeyEvent e){
		paddle1.keyReleased(e);
		paddle2.keyReleased(e);
		}
	
	}
	

}
