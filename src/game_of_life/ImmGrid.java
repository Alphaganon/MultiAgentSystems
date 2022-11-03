package game_of_life;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe représentant une grille de jeu de l'immigration.
 * 
 * @author Equipe 83
 *
 */
public class ImmGrid extends Grid {

	// Etat maximal pouvant être atteint avant de revenir à l'état 0.
	private int maxState;

	/**
	 * Crée un objet de type ImmGrid.
	 * 
	 * @param width    La largeur de la grille
	 * @param height   La hauteur de la grille
	 * @param size     La taille d'une cellule
	 * @param maxState Le nombre d'états que peut prendre une cellule
	 */
	public ImmGrid(int width, int height, int size, int maxState) {
		super(width, height, size);
		this.maxState = maxState;
	}

	/**
	 * Compte le nombre de voisins de la cellule située en (x,y) ayant un état
	 * supérieur de 1 à l'état de cette cellule, ou ayant l'état 0 si la cellule
	 * observée est dans l'état maximal.
	 * 
	 * @param x
	 * @param y
	 * @return le nombre de voisins d'état supérieur de 1 à la cellule située en
	 *         (x,y);
	 */
	public int higherStateNeighbors(int x, int y) {
		int currentState = this.cells[y][x].state % maxState;
		int count = 0;
		ArrayList<Cell> neighbors = this.getNeighbors(x, y);
		for (Cell neighbor : neighbors) {
			if (neighbor.state == currentState + 1)
				count++;
		}
		return count;
	}

	@Override
	public void initGrid() {
		Random rand = new Random();
		this.setMaxState(maxState);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				this.setState(i, j, rand.nextInt(maxState) + 1);
			}
		}
	}

	/**
	 * @return Le nombre d'états que peut prendre une cellule
	 */
	public int getMaxState() {
		return maxState;
	}

	/**
	 * Modifie le nombre d'états que peut prendre une cellule
	 * 
	 * @param maxState Le nombre d'états que peut prendre une cellule
	 */
	public void setMaxState(int maxState) {
		this.maxState = maxState;
	}

}
