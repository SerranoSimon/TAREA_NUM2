/**
 * Excepción que indica que una reunión todavía no ha comenzado.
 */
public class ReunionNoEmpieza extends Exception {
    /**
     *Indica que la reunión todavía no inicia con un mensaje personalizado.
     * @param message mensaje personalizado que indica que la reunión aún no ha empezado.
     */
    public ReunionNoEmpieza(String message) {
        super(message);
    }
}
