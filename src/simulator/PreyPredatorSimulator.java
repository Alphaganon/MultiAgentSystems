package simulator;

import java.util.ArrayList;
import java.util.Random;

import boids.Boid;
import boids.PredatorBoid;
import boids.PreyBoid;
import event.BoidEvent;
import event.EventManager;
import util.Vector2d;

/**
 * Classe permettant d'effectuer une simulation proie-prédateur à l'aide de
 * Boids.
 * 
 * @author Equipe 83
 *
 */
public class PreyPredatorSimulator extends BoidSimulator {

	private int nbPreys, nbPredators;
	private Boid model;

	/**
	 * Cr�e un simulateur proie-prédateur à l'aide de Boids.
	 * 
	 * @param width       La largeur de l'écran
	 * @param height      La hauteur de l'écran
	 * @param boidWidth   La largeur des Boids
	 * @param boidHeight  La hauteur des Boids
	 * @param model       Le modèle de Boid duquel récupérer les attributs
	 * @param nbPreys     Le nombre de proies
	 * @param nbPredators Le nombre de prédateurs
	 */
	public PreyPredatorSimulator(int width, int height, int boidWidth, int boidHeight, Boid model, int nbPreys,
			int nbPredators) {
		super(width, height, boidWidth, boidHeight);
		this.model = model;
		this.nbPreys = nbPreys;
		this.nbPredators = nbPredators;
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
		for (int i = 0; i < nbPreys; i++) {
			Vector2d position = new Vector2d(rand.nextInt(gui.getPanelWidth() - boidWidth),
					rand.nextInt(gui.getPanelHeight() - boidHeight));
			Vector2d velocity = new Vector2d(rand.nextInt(21) - 10, rand.nextInt(21) - 10);
			Boid boid = new PreyBoid(position, velocity, model.getSight(), model.getSightAngle(), model.getMinDist(),
					model.getSpeed());
			boidPool.add(boid);
		}
		for (int i = 0; i < nbPredators; i++) {
			Vector2d position = new Vector2d(rand.nextInt(gui.getPanelWidth() - boidWidth),
					rand.nextInt(gui.getPanelHeight() - boidHeight));
			Vector2d velocity = new Vector2d(rand.nextInt(21) - 10, rand.nextInt(21) - 10);
			Boid boid = new PredatorBoid(position, velocity, model.getSight(), model.getSightAngle(),
					model.getMinDist(), model.getSpeed());
			boidPool.add(boid);
		}
	}

}
