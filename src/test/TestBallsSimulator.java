package test;

import gui.GUISimulator;
import simulator.BallsSimulator;
import util.Vector2d;

/**
 * Classe de test pour la classe BallsSimulator.
 * 
 * @author Equipe 83
 *
 */
public class TestBallsSimulator {

	// Constantes du test : Taille de la fenêtre, Diamètre de la balle, Vecteur
	// vitesse des balles.
	private static final int WIDTH = 500, HEIGHT = 500, SIZE = 10, NB_BALLS = 3, DX = 10, DY = 10;

	public static void main(String[] args) {
		BallsSimulator simulator = new BallsSimulator(WIDTH, HEIGHT, NB_BALLS, SIZE, new Vector2d(DX, DY));
		GUISimulator gui = simulator.getGUI();
		gui.setSimulable(simulator);
		simulator.restart();
	}

}
