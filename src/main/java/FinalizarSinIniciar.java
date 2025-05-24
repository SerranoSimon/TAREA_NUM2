/**
 * Excepción que aparece si se intenta finalizar la reunión sin haberla iniciado.
 */
public class FinalizarSinIniciar extends RuntimeException {
    /**
     *
     * @param message mensaje personalizado para indicar que se intentó finalizar la reunión no iniciada.
     */
    public FinalizarSinIniciar(String message) {
        super(message);
    }
}
