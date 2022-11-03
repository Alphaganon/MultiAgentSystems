package test;

import gui.GUISimulator;
import simulator.GoLSimulator;

/**
 * Classe de test de la classe GoLSimulator.
 * 
 * @author Equipe 83
 *
 */
public class TestGoLSimulator {

	// Constantes du test : Taille de la grille, taille des cases
	private static final int GRID_WIDTH = 100, GRID_HEIGHT = 100, SIZE = 7;

	public static void main(String[] args) {
		GoLSimulator simulator = new GoLSimulator(GRID_WIDTH, GRID_HEIGHT, SIZE);
		GUISimulator gui = simulator.getGUI();
		gui.setSimulable(simulator);
		simulator.restart();
	}

}
