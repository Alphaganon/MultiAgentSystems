package event;

import game_of_life.GoLGrid;
import simulator.GoLSimulator;

/**
 * Evènement représentant la mise à jour d'une grille du jeu de la vie.
 * 
 * @author Equipe 83
 *
 */
public class GoLEvent extends Event {

	private GoLGrid grid;
	private EventManager manager;
	private GoLSimulator simulator;

	/**
	 * Crée un objet de type GoLEvent.
	 * 
	 * @param date    La date à laquelle l'évènement sera exécuté
	 * @param balls   L'objet Balls à traiter
	 * @param gui     L'interface graphique utilisée
	 * @param manager Le manager d'évènement utilisé
	 */
	public GoLEvent(long date, GoLGrid grid, GoLSimulator simulator, EventManager manager) {
		super(date);
		this.grid = grid;
		this.manager = manager;
		this.simulator = simulator;
	}

	@Override
	public void execute() {
		GoLGrid newGrid = new GoLGrid(grid.getWidth(), grid.getHeight(), grid.getSize());
		for (int i = 0; i < grid.getWidth(); i++) {
			for (int j = 0; j < grid.getHeight(); j++) {
				if (grid.aliveNeighbors(i, j) == 3 && !grid.isAlive(i, j))
					newGrid.setAlive(i, j, true);
				else if ((grid.aliveNeighbors(i, j) == 2 || grid.aliveNeighbors(i, j) == 3) && grid.isAlive(i, j))
					newGrid.setAlive(i, j, true);
				else
					newGrid.setAlive(i, j, false);
			}
		}
		this.grid = newGrid;
		simulator.setGrid(newGrid);
		manager.addEvent(new GoLEvent(manager.getCurrentDate() + 1, grid, simulator, manager));
	}

}
