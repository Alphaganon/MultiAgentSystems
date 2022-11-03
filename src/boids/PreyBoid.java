package boids;

import java.awt.Color;
import java.util.ArrayList;

import util.Vector2d;

/**
 * Représente un Boid de type Proie.
 * 
 * @author Equipe 83
 *
 */
public class PreyBoid extends Boid {

	/**
	 * Crée un objet de type PreyBoid.
	 * 
	 * @param position
	 * @param velocity
	 * @param sight
	 * @param sightAngle
	 * @param minDist
	 * @param speed
	 */
	public PreyBoid(Vector2d position, Vector2d velocity, int sight, int sightAngle, int minDist, double speed) {
		super(position, velocity, sight, sightAngle, minDist, speed);
		this.drawColor = Color.DARK_GRAY;
		this.fillColor = Color.GREEN;
	}

	/**
	 * Calcule la force en fonction des voisins du Boid et l'ajoute au Boid.
	 * 
	 * @param neighbors
	 */
	private void addFleeForce(ArrayList<Boid> neighbors) {
		Vector2d flee = new Vector2d();
		for (Boid neighbor : neighbors) {
			if (neighbor instanceof PredatorBoid) {
				Vector2d vec = new Vector2d(this.position);
				vec.subVect(neighbor.position);
				flee.addVect(vec);
			}
		}
		flee = this.limitVelocity(flee, 90);
		this.velocity.addVect(flee);
	}

	@Override
	public void addAlignmentForce(ArrayList<Boid> neighborBoids) {
		ArrayList<Boid> preyNeighbors = this.preyNeighbors(neighborBoids);
		super.addAlignmentForce(preyNeighbors);
	}

	@Override
	public void addCohesionForce(ArrayList<Boid> neighborBoids) {
		ArrayList<Boid> preyNeighbors = this.preyNeighbors(neighborBoids);
		super.addCohesionForce(preyNeighbors);
	}

	@Override
	public void addSeparationForce(ArrayList<Boid> neighborBoids) {
		ArrayList<Boid> preyNeighbors = this.preyNeighbors(neighborBoids);
		super.addSeparationForce(preyNeighbors);
	}

	@Override
	public void addForces(ArrayList<Boid> neighborBoids) {
		if (!neighborBoids.isEmpty()) {
			this.addSeparationForce(neighborBoids);
			this.addAlignmentForce(neighborBoids);
			this.addCohesionForce(neighborBoids);
			this.addFleeForce(neighborBoids);
		}
		this.velocity = this.limitVelocity(this.velocity, this.getSpeed());
	}

	/**
	 * Renvoie une liste des proies voisines à partir de la liste des Boids voisins.
	 * 
	 * @param neighborBoids La liste des Boids voisins
	 * @return La liste des proies voisines
	 */
	private ArrayList<Boid> preyNeighbors(ArrayList<Boid> neighborBoids) {
		ArrayList<Boid> preyNeighbors = new ArrayList<Boid>();
		for (Boid neighbor : neighborBoids) {
			if (neighbor instanceof PreyBoid) {
				preyNeighbors.add(neighbor);
			}
		}
		return preyNeighbors;
	}

}
