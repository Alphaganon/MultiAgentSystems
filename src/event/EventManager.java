package event;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe représentant un manager d'évènements, qui exécute tous les évènements
 * qui lui ont été donnés à la bonne date.
 * 
 * @author Equipe 83
 *
 */
public class EventManager {

	private long currentDate;
	/**
	 * Table de hachage reliant une date d'exécution à la liste de tous les
	 * évènements à exécuter à cette date.
	 */
	private HashMap<Long, ArrayList<Event>> events;

	public EventManager() {
		this.restart();
	}

	/**
	 * Ajoute l'évànement e à la liste d'évènements à exécuter.
	 * 
	 * @param e L'évènement à ajouter à la liste d'évènements à exécuter.
	 */
	public void addEvent(Event e) {
		if (events.get(e.getDate()) == null) {
			ArrayList<Event> newList = new ArrayList<Event>();
			newList.add(e);
			events.put(e.getDate(), newList);
		} else {
			events.get(e.getDate()).add(e);
		}
	}

	/**
	 * Incràmente la date courante et exécute tous les évènements à exécuter pour la
	 * nouvelle date obtenue.
	 */
	public void next() {
		if (!isFinished()) {
			currentDate++;
			// System.out.println("Next... Current Date : " + currentDate);
			ArrayList<Event> toExecute = new ArrayList<Event>();
			ArrayList<Long> dates = new ArrayList<Long>();
			for(long date : events.keySet()) {
				if (date <= currentDate) {
					for(Event event : events.get(date)) {
						toExecute.add(event);
					}
					dates.add(date);
				}
			}
			for(Event event : toExecute) {
				event.execute();
			}
			for(long date : dates) {
				events.remove(date);
			}
		}
	}

	/**
	 * @return True si le manager n'a plus d'évènements à exécuter, false sinon.
	 */
	public boolean isFinished() {
		return events.isEmpty();
	}

	/**
	 * @return La date actuelle du manager.
	 */
	public long getCurrentDate() {
		return currentDate;
	}

	/**
	 * Ràinitialise le manager.
	 */
	public void restart() {
		currentDate = 0;
		events = new HashMap<Long, ArrayList<Event>>();
	}

}
