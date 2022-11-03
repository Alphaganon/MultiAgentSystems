package event;

import balls.Balls;
import gui.GUISimulator;

/**
 * Evènement représentant le mouvement d'objets de type Ball.
 * 
 * @author Equipe 83
 *
 */
public class BallMoveEvent extends Event {

	private Balls balls;
	private GUISimulator gui;
	private EventManager manager;

	/**
	 * Cr�e un objet de type BallMoveEvent.
	 * 
	 * @param date    La date à laquelle l'évènement sera exécuté
	 * @param balls   L'objet Balls à traiter
	 * @param gui     L'interface graphique utilisée
	 * @param manager Le manager d'évènement utilisé
	 */
	public BallMoveEvent(long date, Balls balls, GUISimulator gui, EventManager manager) {
		super(date);
		this.balls = balls;
		this.gui = gui;
		this.manager = manager;
	}

	@Override
	public void execute() {
		balls.translate();
		manager.addEvent(new BallMoveEvent(manager.getCurrentDate() + 1, balls, gui, manager));
	}

}
