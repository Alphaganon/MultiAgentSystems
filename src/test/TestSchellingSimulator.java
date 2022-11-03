package test;

import java.awt.Color;

import gui.GUISimulator;
import simulator.SchellingSimulator;

/**
 * Classe de test de la classe SchellingSimulator.
 * 
 * @author Equipe 83
 *
 */
public class TestSchellingSimulator {

	// Constantes du test : Taille de la grille, taille des cases, couleurs
	// possibles (la 1ère étant la couleur d'un emplacement vide)
	private static final int GRID_WIDTH = 100, GRID_HEIGHT = 100, SIZE = 7;
	private static final Color[] COLORS = { Color.WHITE, Color.BLUE, Color.GREEN, Color.RED, Color.CYAN };

	public static void main(String[] args) {
		SchellingSimulator simulator = new SchellingSimulator(GRID_WIDTH, GRID_HEIGHT, SIZE, COLORS);
		GUISimulator gui = simulator.getGUI();
		gui.setSimulable(simulator);
		simulator.restart();
	}

}
