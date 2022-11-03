package simulator;

import java.awt.Color;

import event.EventManager;
import event.GoLEvent;
import game_of_life.GoLGrid;
import gui.GUISimulator;
import gui.Rectangle;

/**
 * Classe permettant d'effectuer une simulation d'une partie de jeu de la vie.
 * 
 * @author Equipe 83
 *
 */
public class GoLSimulator extends GridSimulator {

	private GoLGrid grid;
	private EventManager manager;

	/**
	 * Crée un simulateur de jeu de la vie.
	 * 
	 * @param width  La largeur de la grille
	 * @param height La hauteur de la grille
	 * @param size   La taille d'une cellule
	 */
	public GoLSimulator(int width, int height, int size) {
		super(width, height, size);
		this.grid = new GoLGrid(width, height, size);
		this.gui = new GUISimulator(width * size, height * size, Color.BLACK);
		init();
	}

	@Override
	public void next() {
		manager.next();
		repaint();
	}

	@Override
	public void restart() {
		init();
		manager = new EventManager();
		manager.addEvent(new GoLEvent(1, grid, this, manager));
		repaint();
	}

	@Override
	public void repaint() {
		gui.reset();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!grid.isAlive(i, j))
					gui.addGraphicalElement(new Rectangle(i * size + size / 2, j * size + size / 2, Color.DARK_GRAY,
							Color.WHITE, size));
				else
					gui.addGraphicalElement(new Rectangle(i * size + size / 2, j * size + size / 2, Color.DARK_GRAY,
							new Color(0, 172, 215), size));
			}
		}

	}

	@Override
	protected void init() {
		grid.initGrid();
	}

	/**
	 * Modifie la grille actuelle
	 * 
	 * @param grid La nouvelle grille
	 */
	public void setGrid(GoLGrid grid) {
		this.grid = grid;
	}

}
