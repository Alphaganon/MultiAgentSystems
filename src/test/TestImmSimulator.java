package test;

import gui.GUISimulator;
import simulator.ImmSimulator;

/**
 * Classe de test de la classe ImmSimulator.
 * 
 * @author Equipe 83
 *
 */
public class TestImmSimulator {

	// Constantes du test : Taille de la grille, Taille des cases, Nombre d'états
	private static final int GRID_WIDTH = 100, GRID_HEIGHT = 100, SIZE = 7, STATES = 4;

	public static void main(String[] args) {
		ImmSimulator simulator = new ImmSimulator(GRID_WIDTH, GRID_HEIGHT, SIZE, STATES);
		GUISimulator gui = simulator.getGUI();
		gui.setSimulable(simulator);
		simulator.restart();
	}

}
