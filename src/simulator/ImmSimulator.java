package simulator;

import java.awt.Color;

import event.EventManager;
import event.ImmEvent;
import game_of_life.ImmGrid;
import gui.GUISimulator;
import gui.Rectangle;

/**
 * Classe permettant de simuler une partie de jeu de l'immigration.
 * 
 * @author Equipe 83
 *
 */
public class ImmSimulator extends GridSimulator {

	private ImmGrid grid;
	private EventManager manager;
	private int maxState;

	/**
	 * Crée un simulateur de jeu de l'immigration.
	 * 
	 * @param width    La largeur de la grille
	 * @param height   La hauteur de la grille
	 * @param size     La taille d'une cellule
	 * @param maxState Le nombre d'états que peut prendre une cellule
	 */
	public ImmSimulator(int width, int height, int size, int maxState) {
		super(width, height, size);
		this.maxState = maxState;
		this.gui = new GUISimulator(width * size, height * size, Color.BLACK);
		this.grid = new ImmGrid(width, height, size, maxState);
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
		manager.addEvent(new ImmEvent(1, grid, this, manager));
		repaint();
	}

	@Override
	protected void repaint() {
		gui.reset();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (grid.getState(i, j) == 1)
					gui.addGraphicalElement(new Rectangle(i * size + size / 2, j * size + size / 2, Color.DARK_GRAY,
							Color.WHITE, size));
				else {
					int colorIndex = (int) (255 * (((float) maxState - grid.getState(i, j)) / (float) (maxState - 1)));
					gui.addGraphicalElement(new Rectangle(i * size + size / 2, j * size + size / 2, Color.DARK_GRAY,
							new Color(colorIndex, colorIndex, colorIndex), size));
				}
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
	public void setGrid(ImmGrid grid) {
		this.grid = grid;
	}

}
