package boids;

import java.awt.Color;
import java.util.ArrayList;

import util.Vector2d;

/**
 * Représente un Boid de type prédateur.
 * 
 * @author Equipe 83
 *
 */
public class PredatorBoid extends Boid {

	/**
	 * Crée un objet de type PredatorBoid.
	 * 
	 * @param position
	 * @param velocity
	 * @param sight
	 * @param sightAngle
	 * @param minDist
	 * @param speed
	 */
	public PredatorBoid(Vector2d position, Vector2d velocity, int sight, int sightAngle, int minDist, double speed) {
		super(position, velocity, sight, sightAngle, minDist, speed);
		this.drawColor = Color.DARK_GRAY;
		this.fillColor = Color.RED;
	}

	/**
	 * Calcule la force de poursuite en fonction des voisins du Boid et l'ajoute au
	 * Boid.
	 * 
	 * @param neighbors
	 */
	private void addChaseForce(ArrayList<Boid> neighbors) {
		Vector2d centroid = new Vector2d();
		for (Boid neighbor : neighbors) {
			if (neighbor instanceof PreyBoid) {
				Vector2d vec = new Vector2d(neighbor.position);
				vec.subVect(this.position);
				centroid.addVect(vec);
			}
		}
		Vector2d chase = this.limitVelocity(centroid, 10);
		this.velocity.addVect(chase);
	}

	@Override
	public void addSeparationForce(ArrayList<Boid> neighborBoids) {
		ArrayList<Boid> predatorNeighbors = new ArrayList<Boid>();
		for (Boid neighbor : neighborBoids) {
			if (neighbor instanceof PredatorBoid) {
				predatorNeighbors.add(neighbor);
			}
		}
		super.addSeparationForce(predatorNeighbors);
	}

	@Override
	public void addForces(ArrayList<Boid> neighborBoids) {
		if (!neighborBoids.isEmpty()) {
			this.addSeparationForce(neighborBoids);
			this.addChaseForce(neighborBoids);
		}
		this.velocity = this.limitVelocity(this.velocity, this.getSpeed());
	}

}
