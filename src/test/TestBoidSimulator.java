package test;

import boids.Boid;
import boids.CommonBoid;
import gui.GUISimulator;
import simulator.CommonBoidSimulator;
import util.Vector2d;

/**
 * Classe de test de la classe BoidSimulator.
 * 
 * @author Equipe 83
 *
 */
public class TestBoidSimulator {

	/*
	 * Constantes du test : Taille de la fenêtre, Taille des Boids, Nombre de Boids,
	 * Distance et angle de vision des Boids, Distance critique entre deux Boids,
	 * Vitesse des Boids, Boid modèle ayant les caractéristiques désirées.
	 */
	private static final int WIDTH = 800, HEIGHT = 600, BOID_WIDTH = 10, BOID_HEIGHT = 6, NB_BOIDS = 20;
	private static final int BOID_SIGHT = 100, SIGHT_ANGLE = 120, MIN_DIST = 40;
	private static final double BOID_SPEED = 6;
	private static final Boid MODEL = new CommonBoid(new Vector2d(), new Vector2d(), BOID_SIGHT, SIGHT_ANGLE, MIN_DIST,
			BOID_SPEED);

	public static void main(String[] args) {
		CommonBoidSimulator simulator = new CommonBoidSimulator(WIDTH, HEIGHT, BOID_WIDTH, BOID_HEIGHT, MODEL,
				NB_BOIDS);
		GUISimulator gui = simulator.getGUI();
		gui.setSimulable(simulator);
		simulator.restart();
	}

}
