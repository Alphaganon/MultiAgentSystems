package simulator;

import java.awt.Color;

import balls.Ball;
import balls.Balls;
import event.BallMoveEvent;
import event.EventManager;
import gui.GUISimulator;
import gui.Oval;
import gui.Rectangle;
import util.Vector2d;

/**
 * Une classe permettant d'effectuer une simulation d'objets Balls.
 * 
 * @author Equipe 83
 *
 */
public class BallsSimulator extends Simulator {

	private Balls balls;
	private EventManager manager;
	private int size;

	/**
	 * Crée un simulateur graphique de balles.
	 * 
	 * @param width    La largeur de l'écran
	 * @param height   La hauteur de l'écran
	 * @param nbBalls  Le nombre de balles à afficher
	 * @param size     La taille des balles à afficher
	 * @param velocity La vitesse des balles
	 */
	public BallsSimulator(int width, int height, int nbBalls, int size, Vector2d velocity) {
		this.size = size;
		this.gui = new GUISimulator(width, height, Color.BLACK);
		this.balls = new Balls(width, height, nbBalls, size, velocity);
		this.manager = new EventManager();
	}

	@Override
	public void next() {
		manager.next();
		repaint();
	}

	@Override
	public void restart() {
		init();
		manager = new EventManager();
		manager.addEvent(new BallMoveEvent(1, balls, gui, manager));
		repaint();
	}

	@Override
	protected void repaint() {
		gui.reset();
		gui.addGraphicalElement(new Rectangle(gui.getPanelWidth() / 2, gui.getPanelHeight() / 2, Color.red,
				Color.LIGHT_GRAY, gui.getPanelWidth(), gui.getPanelHeight()));
		for(Ball ball : balls.getBalls()) {
			gui.addGraphicalElement(
					new Oval((int) ball.position.x, (int) ball.position.y, Color.BLUE, Color.CYAN, size));
		}
	}

	@Override
	protected void init() {
		balls.reInit();
	}

}
