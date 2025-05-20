public class Persona {
    private String nombre;
    private String apellidos;
    private String correo;
    public Persona(String nombre,String apellidos, String correo){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.correo=correo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }
}
