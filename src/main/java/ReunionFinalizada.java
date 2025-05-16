/**
 * Excepción que representa el fin de una reunión.
 */
public class ReunionFinalizada extends Exception {
    /**
     *Indica que la reunión ha finalizado con un mensaje personalizado.
     * @param message mensaje personalizado que indica que la reunión ha terminado.
     */
    public ReunionFinalizada(String message) {
        super(message);
    }
}
