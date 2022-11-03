package simulator;

import java.util.ArrayList;
import java.util.Random;

import boids.Boid;
import boids.CommonBoid;
import event.BoidEvent;
import event.EventManager;
import util.Vector2d;

/**
 * Classe permettant d'effectuer une simulation de Boids.
 * 
 * @author Equipe 83
 *
 */
public class CommonBoidSimulator extends BoidSimulator {

	private int nbBoids;
	private Boid model;

	/**
	 * Crée un simulateur de Boids communs.
	 * 
	 * @param width      La largeur de l'écran
	 * @param height     La hauteur de l'écran
	 * @param boidWidth  La largeur des Boids
	 * @param boidHeight La hauteur des Boids
	 * @param model      Le modèle de Boid duquel récupérer les attributs
	 * @param nbBoids    Le nombre de Boids à afficher
	 */
	public CommonBoidSimulator(int width, int height, int boidWidth, int boidHeight, Boid model, int nbBoids) {
		super(width, height, boidWidth, boidHeight);
		this.nbBoids = nbBoids;
		this.model = model;
	}

	@Override
	public void restart() {
		init();
		manager = new EventManager();
		manager.addEvent(new BoidEvent(1, boidPool, this, manager));
		repaint();
	}

	@Override
	protected void init() {
		boidPool = new ArrayList<Boid>();
		Random rand = new Random();
		for (int i = 0; i < nbBoids; i++) {
			Vector2d position = new Vector2d(rand.nextInt(gui.getPanelWidth() - boidWidth),
					rand.nextInt(gui.getPanelHeight() - boidHeight));
			Vector2d velocity = new Vector2d(rand.nextInt(21) - 10, rand.nextInt(21) - 10);
			Boid boid = new CommonBoid(position, velocity, model.getSight(), model.getSightAngle(), model.getMinDist(),
					model.getSpeed());
			boidPool.add(boid);
		}
	}

}
