/**
 * Exception que aparece cuando una persona intenta asistir a una reunión sin estar en la lista de invitados.
 */
public class AsisteSinSerInvitado extends RuntimeException {
    /**
     *
     * @param message mensaje personalizado para avisar que esta persona no fue invitada a la reunión.
     */
    public AsisteSinSerInvitado(String message) {
        super(message);
    }
}
