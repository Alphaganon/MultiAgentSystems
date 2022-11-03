package event;

/**
 * Classe abstraite définissant un évènement.
 * 
 * @author Equipe 83
 *
 */
public abstract class Event {

	private long date;

	/**
	 * Crée un objet de type Event.
	 * 
	 * @param date La date à laquelle l'évènement sera exécuté.
	 */
	public Event(long date) {
		this.date = date;
	}

	/**
	 * @return La date à laquelle l'évènement doit être exécuté.
	 */
	public long getDate() {
		return date;
	}

	/**
	 * Fonction appelée lors de l'exécution d'un évènement, et définie pour chaque
	 * évènement existant.
	 */
	public abstract void execute();

}
