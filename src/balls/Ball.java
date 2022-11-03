package balls;

import util.Vector2d;

/**
 * Une classe représentant une balle située au point (x,y).
 * 
 * @author Equipe 83
 *
 */
public class Ball {

	public Vector2d position, velocity;

	private int size;

	/**
	 * Crée un objet de type Ball.
	 * 
	 * @param position La position de la Balle
	 * @param velocity La vitesse de la Balle
	 * @param size     La taille de la Balle
	 */
	public Ball(Vector2d position, Vector2d velocity, int size) {
		this.position = position;
		this.velocity = velocity;
		this.size = size;
	}

	/**
	 * @return La taille de la balle.
	 */
	public int getSize() {
		return size;
	}

}
