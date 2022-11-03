package simulator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import event.EventManager;
import event.SchellingEvent;
import game_of_life.SchellingGrid;
import gui.GUISimulator;
import gui.Rectangle;
import util.Vector2d;

/**
 * Classe permettant d'effectuer une simulation de Schelling.
 * 
 * @author Equipe 83
 *
 */
public class SchellingSimulator extends GridSimulator {

	private SchellingGrid grid;
	private ArrayList<Vector2d> vacantSpots;
	private EventManager manager;
	private Color[] colors;

	/**
	 * Crée un simulateur de Schelling.
	 * 
	 * @param width  La largeur de la grille
	 * @param height La hauteur de la grille
	 * @param size   La taille d'une cellule
	 * @param colors La liste des couleurs que peut prendre une cellule
	 */
	public SchellingSimulator(int width, int height, int size, Color[] colors) {
		super(width, height, size);
		this.gui = new GUISimulator(width * size, height * size, Color.BLACK);
		this.grid = new SchellingGrid(width, height, size, colors);
		this.vacantSpots = new ArrayList<Vector2d>();
		this.colors = colors;
		init();
	}

	@Override
	public void next() {
		manager.next();
		repaint();
	}

	@Override
	public void restart() {
		vacantSpots.clear();
		init();
		manager = new EventManager();
		manager.addEvent(new SchellingEvent(1, grid, this, manager));
		repaint();
	}

	@Override
	protected void repaint() {
		gui.reset();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				gui.addGraphicalElement(new Rectangle(i * size + size / 2, j * size + size / 2, Color.DARK_GRAY,
						colors[grid.getState(i, j)], size));
			}
		}
	}

	@Override
	protected void init() {
		Random rand = new Random();
		grid.initGrid();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (grid.getState(i, j) == 0)
					vacantSpots.add(new Vector2d(i, j));
			}
		}
		// On met au moins un emplacement vide
		if (vacantSpots.size() == 0)
			this.setColor(rand.nextInt(width), rand.nextInt(height), 0);
	}

	/**
	 * Modifie la couleur d'une cellule de la grille actuelle et met à jour la liste
	 * des emplacements vides.
	 * 
	 * @param x
	 * @param y
	 * @param color
	 */
	private void setColor(int x, int y, int color) {
		this.grid.setState(x, y, color);
		if (color != 0)
			vacantSpots.remove(new Vector2d(x, y));
		else
			vacantSpots.add(new Vector2d(x, y));
	}

	/**
	 * @return La liste des emplacements vides.
	 */
	public ArrayList<Vector2d> getVacantSpots() {
		return vacantSpots;
	}

	/**
	 * Modifie la grille actuelle
	 * 
	 * @param grid La nouvelle grille
	 */
	public void setGrid(SchellingGrid grid) {
		this.grid = grid;
	}

}
