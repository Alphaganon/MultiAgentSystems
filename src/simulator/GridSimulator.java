package simulator;

/**
 * Classe abstraite représentant un Simulateur utilisant une grille de cellules.
 * 
 * @author Equipe 83
 *
 */
public abstract class GridSimulator extends Simulator {

	protected int width, height, size;

	public GridSimulator(int width, int height, int size) {
		this.width = width;
		this.height = height;
		this.size = size;
	}

}
