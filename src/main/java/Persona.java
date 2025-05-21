/**
 * Clase que representa a una persona que puede ser invitada a una reunión, asistir o no.
 */
public class Persona {
    private String nombre;
    private String apellidos;
    private String correo;

    /**
     * Constructor de una nueva persona con su información correspondiente.
     * @param nombre nombre de la persona.
     * @param apellidos apellidos de la persona.
     * @param correo correo de la persona.
     */
    public Persona(String nombre,String apellidos, String correo){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.correo=correo;
    }

    /**
     *
     * @return retorna los apellidos de la persona.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *
     * @return retorna el correo de la persona.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     *
     * @return retorna el nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return retorna la información asociada a una persona.
     */
    @Override
    public String toString() {
        return
                " Apellidos= " + getApellidos()+
                ", Nombre= " + getNombre() +
                ", Correo='" + getCorreo()+"]";
    }
}
