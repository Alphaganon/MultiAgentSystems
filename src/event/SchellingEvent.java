package event;

import java.util.ArrayList;
import java.util.Random;

import game_of_life.SchellingGrid;
import simulator.SchellingSimulator;
import util.Vector2d;

/**
 * Evènement représentant la mise à jour d'une grille de Schelling.
 * 
 * @author Equipe 83
 *
 */
public class SchellingEvent extends Event {

	// Constantes de l'évènement : Seuil de voisins différents entraînant un
	// déménagement.
	private static final int K = 3;

	private SchellingGrid grid;
	private EventManager manager;
	private SchellingSimulator simulator;

	/**
	 * Crée un objet de type SchellingEvent.
	 * 
	 * @param date    La date à laquelle l'évènement sera exécuté
	 * @param balls   L'objet Balls à traiter
	 * @param gui     L'interface graphique utilisée
	 * @param manager Le manager d'évènement utilisé
	 */
	public SchellingEvent(long date, SchellingGrid grid, SchellingSimulator simulator, EventManager manager) {
		super(date);
		this.grid = grid;
		this.simulator = simulator;
		this.manager = manager;
	}

	@Override
	public void execute() {
		SchellingGrid newGrid = new SchellingGrid(grid.getWidth(), grid.getHeight(), grid.getSize(), grid.getColors());
		for (int i = 0; i < grid.getWidth(); i++) {
			for (int j = 0; j < grid.getHeight(); j++) {
				newGrid.setState(i, j, grid.getState(i, j));
			}
		}
		Random rand = new Random();
		for (int i = 0; i < grid.getWidth(); i++) {
			for (int j = 0; j < grid.getHeight(); j++) {
				if (grid.getState(i, j) != 0 && grid.differentNeighbors(i, j) > K) {
					ArrayList<Vector2d> vacantSpots = simulator.getVacantSpots();
					Vector2d vacantSpot = vacantSpots.get(rand.nextInt(vacantSpots.size()));
					newGrid.setState((int) vacantSpot.x, (int) vacantSpot.y, grid.getState(i, j));
					vacantSpots.remove(vacantSpot);
					newGrid.setState(i, j, 0);
					vacantSpots.add(new Vector2d(i, j));
				}
			}
		}
		this.grid = newGrid;
		simulator.setGrid(grid);
		manager.addEvent(new SchellingEvent(manager.getCurrentDate() + 1, grid, simulator, manager));
	}

}
