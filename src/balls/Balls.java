package balls;

import java.util.ArrayList;
import java.util.Random;

import util.Vector2d;

/**
 * Une classe représentant une groupe de Ball.
 * 
 * @author Equipe 83
 *
 */
public class Balls {

	private ArrayList<Ball> balls, initBalls;
	private int xMax, yMax;
	private Vector2d velocity;

	/**
	 * Crée un objet de type Balls.
	 * 
	 * @param xMax     Le x maximal possible
	 * @param yMax     Le y maximal possible
	 * @param nbBalls  Le nombre de balles
	 * @param ballSize La taille des balles
	 * @param velocity La vitesse des balles
	 */
	public Balls(int xMax, int yMax, int nbBalls, int ballSize, Vector2d velocity) {
		this.xMax = xMax;
		this.yMax = yMax;
		this.velocity = velocity;
		balls = new ArrayList<Ball>();
		initBalls = new ArrayList<Ball>();

		Random rand = new Random();
		for (int i = 0; i < nbBalls; i++) {
			Ball ball = new Ball(new Vector2d(rand.nextInt(xMax - ballSize) + ballSize / 2,
					rand.nextInt(yMax - ballSize) + ballSize / 2), new Vector2d(velocity), ballSize);
			balls.add(ball);
			initBalls.add(new Ball(new Vector2d(ball.position), new Vector2d(ball.velocity), ball.getSize()));
		}
	}

	/**
	 * La fonction translate permet de déplacer toutes les balles d'une même
	 * distance et dans la même direction. Les balles sont indépendantes et
	 * rebondissent sur les bords de l'écran.
	 */
	public void translate() {
		for (Ball ball : balls) {
			if (ball.position.x + ball.velocity.x > xMax - ball.getSize() / 2) {
				ball.position.x = xMax - ball.getSize() / 2;
				ball.velocity.x = -ball.velocity.x;
			} else if (ball.position.x + ball.velocity.x < 0) {
				ball.position.x = ball.getSize() / 2;
				ball.velocity.x = -ball.velocity.x;
			} else {
				ball.position.x += ball.velocity.x;
			}
			if (ball.position.y + ball.velocity.y > yMax - ball.getSize() / 2) {
				ball.position.y = yMax - ball.getSize() / 2;
				ball.velocity.y = -ball.velocity.y;
			} else if (ball.position.y + ball.velocity.y < 0) {
				ball.position.y = ball.getSize() / 2;
				ball.velocity.y = -ball.velocity.y;
			} else {
				ball.position.y += ball.velocity.y;
			}
		}
	}

	/**
	 * Replace les balles dans leur état initial.
	 */
	public void reInit() {
		balls.clear();
		for (Ball ball : initBalls) {
			Ball initBall = new Ball(new Vector2d(ball.position), new Vector2d(ball.velocity), ball.getSize());
			balls.add(initBall);
		}
	}

	@Override
	public String toString() {
		String ballsStr = "";
		for (int i = 0; i < balls.size() - 1; i++) {
			ballsStr += "Pt " + (i + 1) + ":(" + balls.get(i).position.x + "," + balls.get(i).position.y + ") / ";
		}
		ballsStr += "Pt " + balls.size() + ":(" + balls.get(balls.size() - 1).position.x + ","
				+ balls.get(balls.size() - 1).position.y + ")";
		return ballsStr;
	}

	/**
	 * @return La liste des balles de l'objet Balls.
	 */
	public ArrayList<Ball> getBalls() {
		return balls;
	}

	/**
	 * @return La vitesse des balles de l'objet Balls
	 */
	public Vector2d getVelocity() {
		return velocity;
	}

}
