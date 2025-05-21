/**
 *Exception que aparece cuando un organizador intenta escribir una nota sobre una reunión a la que no asistió.
 */
public class EscribeSinAsistir extends RuntimeException {
    /**
     *
     * @param message mensaje personalizado para indicar que este organizador no asistió a la reunión.
     */
    public EscribeSinAsistir(String message) {
        super(message);
    }
}
