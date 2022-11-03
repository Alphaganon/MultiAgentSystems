package game_of_life;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe représentant une grille du jeu de la vie.
 * 
 * @author Equipe 83
 *
 */
public class GoLGrid extends Grid {

	// Constantes de la classe : Numéros d'état correspondant à l'état Vivant et à
	// l'état Mort.
	private static final int ALIVE_STATE = 0, DEAD_STATE = 1;

	/**
	 * Crée un objet de type GoLGrid
	 * 
	 * @param width  La largeur de la grille
	 * @param height La hauteur de la grille
	 * @param size   La taille d'une cellule
	 */
	public GoLGrid(int width, int height, int size) {
		super(width, height, size);
	}

	/**
	 * Passe la cellule située en (x,y) dans l'état {@code alive}.
	 * 
	 * @param x     La colonne de la cellule choisie
	 * @param y     La ligne de la cellule choisie
	 * @param alive
	 */
	public void setAlive(int x, int y, boolean alive) {
		this.cells[y][x].state = alive ? ALIVE_STATE : DEAD_STATE;
	}

	public boolean isAlive(int x, int y) {
		return this.cells[y][x].state == ALIVE_STATE ? true : false;
	}

	public boolean isAlive(Cell cell) {
		return cell.state == ALIVE_STATE ? true : false;
	}

	/**
	 * @param x La colonne de la cellule étudiée
	 * @param y La ligne de la cellule étudiée
	 * @return le nombre de voisins vivants de la cellule située en (x,y).
	 */
	public int aliveNeighbors(int x, int y) {
		int count = 0;
		ArrayList<Cell> neighbors = this.getNeighbors(x, y);
		for (Cell neighbor : neighbors) {
			if (isAlive(neighbor))
				count++;
		}
		return count;
	}

	@Override
	public void initGrid() {
		Random rand = new Random();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				boolean alive = rand.nextBoolean();
				this.setAlive(i, j, alive);
			}
		}
		// Création d'un "Vaisseau" à l'état initial (forme stable qui se déplace).
		/*
		 * this.setAlive(3, 1, true); this.setAlive(1, 2, true); this.setAlive(3, 2,
		 * true); this.setAlive(2, 3, true); this.setAlive(3, 3, true);
		 */
	}

}
