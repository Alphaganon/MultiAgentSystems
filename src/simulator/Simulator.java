package simulator;

import gui.GUISimulator;
import gui.Simulable;

/**
 * Classe abstraite représentant un simulateur.
 * 
 * @author Equipe 83
 *
 */
public abstract class Simulator implements Simulable {

	/**
	 * L'interface graphique du simulateur.
	 */
	protected GUISimulator gui;

	/**
	 * Fait passer le simulateur de l'état t à l'état t+1.
	 */
	@Override
	public abstract void next();

	/**
	 * Réinitialise le simulateur.
	 */
	@Override
	public abstract void restart();

	/**
	 * Redessine l'interface graphique du simulateur.
	 */
	protected abstract void repaint();

	/**
	 * Initialise le simulateur.
	 */
	protected abstract void init();

	/**
	 * @return L'interface graphique utilisée
	 */
	public GUISimulator getGUI() {
		return gui;
	}

}
