package event;

import game_of_life.ImmGrid;
import simulator.ImmSimulator;

/**
 * Evènement représentant la mise à jour d'une grille du jeu de l'immigration.
 * 
 * @author Equipe 83
 *
 */
public class ImmEvent extends Event {

	private ImmGrid grid;
	private EventManager manager;
	private ImmSimulator simulator;

	/**
	 * Cr�e un objet de type ImmEvent.
	 * 
	 * @param date    La date à laquelle l'évènement sera exécuté
	 * @param balls   L'objet Balls à traiter
	 * @param gui     L'interface graphique utilisée
	 * @param manager Le manager d'évènement utilisé
	 */
	public ImmEvent(long date, ImmGrid grid, ImmSimulator simulator, EventManager manager) {
		super(date);
		this.grid = grid;
		this.simulator = simulator;
		this.manager = manager;
	}

	@Override
	public void execute() {
		ImmGrid newGrid = new ImmGrid(grid.getWidth(), grid.getHeight(), grid.getSize(), grid.getMaxState());
		for (int i = 0; i < grid.getWidth(); i++) {
			for (int j = 0; j < grid.getHeight(); j++) {
				newGrid.setState(i, j, grid.getState(i, j));
				if (grid.higherStateNeighbors(i, j) >= 3) {
					if (grid.getState(i, j) != grid.getMaxState())
						newGrid.setState(i, j, grid.getState(i, j) + 1);
					else
						newGrid.setState(i, j, 1);
				}
			}
		}
		newGrid.setMaxState(grid.getMaxState());
		this.grid = newGrid;
		simulator.setGrid(grid);
		manager.addEvent(new ImmEvent(manager.getCurrentDate() + 1, grid, simulator, manager));
	}

}
