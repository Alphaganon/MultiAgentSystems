package event;

import java.util.ArrayList;

import boids.Boid;
import simulator.BoidSimulator;
import util.Vector2d;

/**
 * Evènement de simulation d'objets de type Boid.
 * 
 * @author Equipe 83
 *
 */
public class BoidEvent extends Event {

	private BoidSimulator simulator;
	private ArrayList<Boid> boidPool;
	private EventManager manager;

	/**
	 * Crée un objet de type BoidEvent.
	 * 
	 * @param date    La date à laquelle l'évènement sera exécuté
	 * @param balls   L'objet Balls à traiter
	 * @param manager Le manager d'évènement utilisé
	 */
	public BoidEvent(long date, ArrayList<Boid> boidPool, BoidSimulator simulator, EventManager manager) {
		super(date);
		this.simulator = simulator;
		this.boidPool = boidPool;
		this.manager = manager;
	}

	@Override
	public void execute() {
		for (Boid boid : boidPool) {
			ArrayList<Boid> neighborBoids = boid.neighbors(boidPool);
			boid.addForces(neighborBoids);
			this.bounce(boid);
			Vector2d movement = new Vector2d(boid.velocity);
			boid.position.addVect(movement);
		}
		manager.addEvent(new BoidEvent(manager.getCurrentDate() + 1, boidPool, simulator, manager));
	}

	/**
	 * Empêche les Boids de sortir de l'écran en les faisant rebondir.
	 * 
	 * @param boid Le Boid à traiter
	 */
	private void bounce(Boid boid) {
		Vector2d bounce = new Vector2d();
		int repulsionRange = Math.max(simulator.getBoidWidth(), simulator.getBoidHeight());
		int repulsionForce = 100;
		if (boid.position.x > simulator.getGUI().getPanelWidth() - repulsionRange) {
			bounce.x = -1;
			bounce.y = 0;
			if (boid.position.x != simulator.getGUI().getPanelWidth()) {
				bounce.mult(repulsionForce / Math.abs(simulator.getGUI().getPanelWidth() - boid.position.x));
			}
		}
		if (boid.position.x < repulsionRange) {
			bounce.x = 1;
			bounce.y = 0;
			if (boid.position.x != 0) {
				bounce.mult(repulsionForce / boid.position.x);
			}
		}
		if (boid.position.y > simulator.getGUI().getPanelHeight() - repulsionRange) {
			bounce.x = 0;
			bounce.y = -1;
			if (boid.position.y != simulator.getGUI().getPanelHeight()) {
				bounce.mult(repulsionForce / Math.abs(simulator.getGUI().getPanelHeight() - boid.position.y));
			}
		}
		if (boid.position.y < repulsionRange) {
			bounce.x = 0;
			bounce.y = 1;
			if (boid.position.y != 0) {
				bounce.mult(repulsionForce / boid.position.y);
			}
		}
		boid.velocity.addVect(bounce);
	}
}
