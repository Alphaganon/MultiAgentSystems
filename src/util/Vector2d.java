package util;

/**
 * Classe représentant un vecteur à deux dimensions.
 * 
 * @author Equipe 83
 *
 */
public class Vector2d {

	public double x, y;

	public Vector2d() {
		x = 0;
		y = 0;
	}

	public Vector2d(Vector2d vec) {
		this.x = vec.x;
		this.y = vec.y;
	}

	public Vector2d(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void addVect(Vector2d vector) {
		this.x += vector.x;
		this.y += vector.y;
	}

	public void subVect(Vector2d vector) {
		this.x -= vector.x;
		this.y -= vector.y;
	}

	public void mult(double mult) {
		this.x *= mult;
		this.y *= mult;
	}

	public void div(double div) {
		this.x /= div;
		this.y /= div;
	}

	/**
	 * @return La norme du vecteur.
	 */
	public double getNorm() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	/**
	 * @param vector
	 * @return La distance entre deux vecteurs.
	 */
	public double distanceTo(Vector2d vector) {
		return Math.sqrt(Math.pow(vector.x - this.x, 2) + Math.pow(vector.y - this.y, 2));
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Vector2d) {
			Vector2d vector = (Vector2d) o;
			if (vector.x == this.x && vector.y == this.y)
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}
