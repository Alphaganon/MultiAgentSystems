package test;

import balls.Balls;
import util.Vector2d;

/**
 * Classe de test pour la classe Balls.
 * 
 * @author Equipe 83
 *
 */
public class TestBalls {

	// Constantes du test : x maximum et y maximum simulant des bordures de fenêtre,
	// Taille des balles, Nombre de balles, Vitesse en x et en y des balles
	private static final int X_MAX = 800, Y_MAX = 600, SIZE = 10, NB_BALLS = 3, DX = 10, DY = 10;

	public static void main(String[] args) {
		Balls ballTest = new Balls(X_MAX, Y_MAX, NB_BALLS, SIZE, new Vector2d(DX, DY));
		System.out.println(ballTest.toString());
		ballTest.translate();
		System.out.println(ballTest.toString());
		ballTest.reInit();
		System.out.println(ballTest.toString());
	}

}
