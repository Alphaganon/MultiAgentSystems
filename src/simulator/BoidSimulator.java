package simulator;

import java.awt.Color;
import java.util.ArrayList;

import boids.Boid;
import event.EventManager;
import gui.GUISimulator;
import gui.Rectangle;
import util.Triangle;

/**
 * Classe abstraite représentant un Simulateur utilisant des Boids.
 * 
 * @author Equipe 83
 *
 */
public abstract class BoidSimulator extends Simulator {

	protected ArrayList<Boid> boidPool;
	protected EventManager manager;
	protected int width, height, boidWidth, boidHeight;

	public BoidSimulator(int width, int height, int boidWidth, int boidHeight) {
		this.width = width;
		this.height = height;
		this.boidWidth = boidWidth;
		this.boidHeight = boidHeight;
		this.gui = new GUISimulator(width, height, Color.BLACK);
		this.manager = new EventManager();
	}

	@Override
	public void next() {
		manager.next();
		repaint();
	}

	@Override
	protected void repaint() {
		gui.reset();
		gui.addGraphicalElement(new Rectangle(gui.getPanelWidth() / 2, gui.getPanelHeight() / 2, Color.red,
				Color.LIGHT_GRAY, gui.getPanelWidth(), gui.getPanelHeight()));
		for(Boid boid : boidPool) {
			Triangle boidTri = new Triangle((int) boid.position.x, (int) boid.position.y, boid.drawColor,
					boid.fillColor, boidWidth, boidHeight);
			double angle = boid.getAngle();
			if (angle != 0)
				boidTri.rotate(angle);
			gui.addGraphicalElement(boidTri);
		}
	}

	/**
	 * @return La largeur de l'écran
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return La hauteur de l'écran
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return La largeur d'un Boid
	 */
	public int getBoidWidth() {
		return boidWidth;
	}

	/**
	 * @return La hauteur d'un Boid
	 */
	public int getBoidHeight() {
		return boidHeight;
	}

	/**
	 * @return L'interface graphique utilisée.
	 */
	public GUISimulator getGUI() {
		return gui;
	}

}
