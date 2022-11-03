package boids;

import java.util.ArrayList;

import util.Vector2d;

/**
 * Classe représentant un Boid simple.
 * 
 * @author Equipe 83
 *
 */
public class CommonBoid extends Boid {

	/**
	 * Crée un objet de type CommonBoid.
	 * 
	 * @param position
	 * @param velocity
	 * @param sight
	 * @param sightAngle
	 * @param minDist
	 * @param speed
	 */
	public CommonBoid(Vector2d position, Vector2d velocity, int sight, int sightAngle, int minDist, double speed) {
		super(position, velocity, sight, sightAngle, minDist, speed);
	}

	@Override
	public void addForces(ArrayList<Boid> neighborBoids) {
		if (!neighborBoids.isEmpty()) {
			this.addSeparationForce(neighborBoids);
			this.addAlignmentForce(neighborBoids);
			this.addCohesionForce(neighborBoids);
		}
		this.velocity = this.limitVelocity(this.velocity, this.getSpeed());
	}

}
