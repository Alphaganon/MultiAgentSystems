package event;

/**
 * Evènement représentant l'envoi d'un message dans la console.
 * 
 * @author Equipe 83
 *
 */
public class MessageEvent extends Event {

	private String message;

	/**
	 * Crée un objet de type MessageEvent.
	 * 
	 * @param date    La date à laquelle l'évènement sera exécuté
	 * @param message Le message à afficher
	 */
	public MessageEvent(long date, String message) {
		super(date);
		this.message = message;
	}

	@Override
	public void execute() {
		System.out.println(this.getDate() + this.message);
	}

}
