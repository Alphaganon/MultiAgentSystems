package game_of_life;

import java.util.ArrayList;

/**
 * Classe abstraite représentant une grille de jeu composée d'objets Cell.
 * 
 * @author Equipe 83
 *
 */
public abstract class Grid {

	/*
	 * La matrice de cellules est protected, ainsi seules les classes représentant
	 * des grilles pourront agir sur cette matrice. De même, il faut que les grilles
	 * aient accès à leur taille.
	 */
	protected Cell[][] cells;
	protected int width, height;
	private int size;

	/**
	 * Constructeur de base d'une grille, crée une matrice de cellules de taille
	 * (width*height), chaque cellule de taille size.
	 * 
	 * @param width
	 * @param height
	 * @param size
	 */
	public Grid(int width, int height, int size) {
		this.width = width;
		this.height = height;
		this.size = size;
		this.cells = new Cell[height][width];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				this.cells[j][i] = new Cell();
			}
		}
	}

	/**
	 * Fonction permettant de renvoyer l'ensemble des voisins d'une cellule. La
	 * grille est considérée comme circulaire.
	 * 
	 * @param x Colonne de la cellule étudiée
	 * @param y Ligne de la cellule étudiée
	 * @return une liste de cellules contenant toutes les cellules voisines de la
	 *         cellule située en (x,y).
	 */
	public ArrayList<Cell> getNeighbors(int x, int y) {
		ArrayList<Cell> neighbors = new ArrayList<Cell>();
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				// On ajoute le nombre de lignes/colonnes au cas où y+i ou x+j soient négatifs.
				int col = (y + i + cells.length) % cells.length;
				int row = (x + j + cells[0].length) % cells[0].length;
				if (col != y || row != x) {
					neighbors.add(cells[col][row]);
				}
			}
		}
		return neighbors;
	}

	/**
	 * Initialise la grille.
	 */
	public abstract void initGrid();

	/**
	 * Modifie l'état de la cellule située en (x,y) sans donner d'accès direct à
	 * cette cellule.
	 * 
	 * @param x
	 * @param y
	 * @param state
	 */
	public void setState(int x, int y, int state) {
		this.cells[y][x].state = state;
	}

	/**
	 * Renvoie l'état de la cellule située en (x,y) sans donner d'accès direct à
	 * cette cellule.
	 * 
	 * @param x
	 * @param y
	 * @return l'état de la cellule située en (x,y).
	 */
	public int getState(int x, int y) {
		return this.cells[y][x].state;
	}

	/**
	 * @return La taille d'une cellule
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @return La largeur de la grille
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return La hauteur de la grille
	 */
	public int getHeight() {
		return height;
	}

}
