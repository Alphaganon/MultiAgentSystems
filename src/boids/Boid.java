package boids;

import java.awt.Color;
import java.util.ArrayList;

import util.Vector2d;

/**
 * Classe représentant un Boid ayant une certaine position initiale et une
 * certaine vitesse initiale.
 * 
 * @author Equipe 83
 *
 */
public abstract class Boid {

	public Vector2d position, velocity;
	public Color drawColor, fillColor;

	private int sight, sightAngle, minDist;
	private double speed;

	public Boid(int sight, int sightAngle, int minDist, double speed) {
		this.sight = sight;
		this.sightAngle = sightAngle;
		this.minDist = minDist;
		this.speed = speed;
		drawColor = Color.BLUE;
		fillColor = Color.CYAN;
		position = new Vector2d(0, 0);
		velocity = new Vector2d(0, 0);
	}

	public Boid(Vector2d pos, Vector2d vel, int sight, int sightAngle, int minDist, double speed) {
		this(sight, sightAngle, minDist, speed);
		this.position = pos;
		this.velocity = vel;
	}

	/**
	 * Fonction permettant d'obtenir la liste des Boids voisins du Boid étudié.
	 * 
	 * @param boidPool La liste de tous les Boids à traiter.
	 * @return La liste des voisins du Boid.
	 */
	public ArrayList<Boid> neighbors(ArrayList<Boid> boidPool) {
		ArrayList<Boid> neighborBoids = new ArrayList<Boid>();
		for (Boid neighbor : boidPool) {
			if (!neighbor.equals(this)) {
				Vector2d boidToNeighbor = new Vector2d(neighbor.position.x - this.position.x,
						neighbor.position.y - this.position.y);
				double neighborAngle;
				if (this.velocity.getNorm() == 0) {
					neighborAngle = Math.acos(boidToNeighbor.x / boidToNeighbor.getNorm());
				} else {
					neighborAngle = Math.acos((this.velocity.x * boidToNeighbor.x + this.velocity.y * boidToNeighbor.y)
							/ (this.velocity.getNorm() * boidToNeighbor.getNorm()));
				}
				if (this.position.distanceTo(neighbor.position) < sight && neighborAngle < Math.toRadians(sightAngle))
					neighborBoids.add(neighbor);
			}
		}
		return neighborBoids;
	}

	/**
	 * Définit la norme d'un vecteur en gardant sa direction et son sens, à
	 * condition que la norme de ce vecteur soit supérieure à la norme passée en
	 * argument.
	 * 
	 * @param vec  Le vecteur à normer
	 * @param norm La norme maximale autorisée
	 * @return Un vecteur de même direction et de même sens que vec, de norme
	 *         min(norm, vec.getNorm()).
	 */
	public Vector2d limitVelocity(Vector2d vec, double norm) {
		if (vec.getNorm() > norm) {
			Vector2d new_vec = new Vector2d();
			new_vec.x = vec.x * norm / vec.getNorm();
			new_vec.y = vec.y * norm / vec.getNorm();
			return new_vec;
		} else
			return vec;
	}

	/**
	 * Calcule la force de cohésion en fonction des voisins du Boid et l'ajoute au
	 * Boid.
	 * 
	 * @param neighborBoids Les Boids voisins
	 */
	public void addCohesionForce(ArrayList<Boid> neighborBoids) {
		Vector2d centroid = new Vector2d();
		for (Boid neighbor : neighborBoids) {
			Vector2d vec = new Vector2d(neighbor.position);
			vec.subVect(this.position);
			centroid.addVect(vec);
		}
		Vector2d cohesion = this.limitVelocity(centroid, 5);
		this.velocity.addVect(cohesion);
	}

	/**
	 * Calcule la force d'alignement en fonction des voisins du Boid et l'ajoute au
	 * Boid.
	 * 
	 * @param neighborBoids Les Boids voisins
	 */
	public void addAlignmentForce(ArrayList<Boid> neighborBoids) {
		Vector2d neighborsVelocity = new Vector2d();
		for (Boid neighbor : neighborBoids) {
			neighborsVelocity.addVect(neighbor.velocity);
		}
		Vector2d alignment = this.limitVelocity(neighborsVelocity, 30);
		this.velocity.addVect(alignment);
	}

	/**
	 * Calcule la force de séparation en fonction des voisins du Boid et l'ajoute au
	 * Boid.
	 * 
	 * @param neighborBoids Les Boids voisins
	 */
	public void addSeparationForce(ArrayList<Boid> neighborBoids) {
		Vector2d separation = new Vector2d();
		for (Boid neighbor : neighborBoids) {
			if (this.position.distanceTo(neighbor.position) < minDist) {
				Vector2d vec = new Vector2d(this.position);
				vec.subVect(neighbor.position);
				separation.addVect(vec);
			}
		}
		separation = this.limitVelocity(separation, 20);
		this.velocity.addVect(separation);
	}

	/**
	 * Ajoute les forces correspondant au Boid.
	 * 
	 * @param neighborBoids Les Boids voisins
	 */
	public abstract void addForces(ArrayList<Boid> neighborBoids);

	/**
	 * @return L'angle du Boid défini par la direction de sa vitesse
	 */
	public double getAngle() {
		double angle;
		if (velocity.x > 0 && velocity.y != 0)
			angle = Math.atan(velocity.y / velocity.x);
		else if (velocity.x < 0 && velocity.y != 0)
			angle = Math.PI + Math.atan(velocity.y / velocity.x);
		else if (velocity.x == 0)
			angle = Math.toRadians(90) * Math.signum(velocity.y);
		else if (velocity.y == 0 && velocity.x < 0)
			angle = Math.PI;
		else
			angle = 0;
		return angle;
	}

	/**
	 * @return La vitesse du Boid
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * @return La distance de vision du Boid
	 */
	public int getSight() {
		return sight;
	}

	/**
	 * @return L'angle de vision du Boid
	 */
	public int getSightAngle() {
		return sightAngle;
	}

	/**
	 * @return La distance critique entre deux Boids
	 */
	public int getMinDist() {
		return minDist;
	}

}
