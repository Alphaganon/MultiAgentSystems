package game_of_life;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Classe représentant une grille de Schelling.
 * 
 * @author Equipe 83
 *
 */
public class SchellingGrid extends Grid {

	private Color[] colors;

	/**
	 * Crée un objet de type SchellingGrid.
	 * 
	 * @param width  La largeur de la grille
	 * @param height La hauteur de la grille
	 * @param size   La taille d'une cellule
	 * @param colors La liste des couleurs que peut prendre une cellule
	 */
	public SchellingGrid(int width, int height, int size, Color[] colors) {
		super(width, height, size);
		this.colors = colors;
	}

	/**
	 * Compte le nombre de voisins de la cellule située en (x,y) ayant une couleur
	 * différente (c'est-à-dire un état différent), en ignorant les cases vides
	 * (ayant l'état 0).
	 * 
	 * @param x
	 * @param y
	 * @return le nombre de voisins de la cellule située en (x,y) ayant une couleur
	 *         différente de cette cellule.
	 */
	public int differentNeighbors(int x, int y) {
		int currentState = this.getState(x, y);
		int count = 0;
		ArrayList<Cell> neighbors = this.getNeighbors(x, y);
		for (Cell neighbor : neighbors) {
			if (neighbor.state != 0 && neighbor.state != currentState)
				count++;
		}
		return count;
	}

	@Override
	public void initGrid() {
		Random rand = new Random();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				this.setState(i, j, rand.nextInt(colors.length));
			}
		}
	}

	/**
	 * @return La liste des couleurs que peut prendre une cellule
	 */
	public Color[] getColors() {
		return colors;
	}

}
