import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.time.*;
//Cambiamos Date por localDate que es de java.time

/**
 * Clase abstracta que representa una reunión.
 */
public abstract class Reunion {
    private tipoReunion tipoReunion;
    private LocalDate fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private Invitacion invitacion;
    private Asistencia asistencia;
    private Organizador organizador;
    private Nota nota;

    /**
     * Constructor de la reunión con sus respectivos datos.
     * @param tipoReunion es el tipo de reunión (TECNICA, MARKETING, OTRO).
     * @param fecha se refiere a la fecha de la reunión.
     * @param horaPrevista se refiere a la hora en la que se debería comenzar la reunión.
     * @param duracionPrevista se refiere a la duración estimada de la reunión.
     * @param organizador se refiere a un empleado que actuará como organizador en la reunión.
     * @throws IOException excepción que sirve para evitar errores referentes a las notas.
     */

    public Reunion(tipoReunion tipoReunion, LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, Organizador organizador) throws IOException {
        this.tipoReunion=tipoReunion;
        this.fecha=fecha;
        this.horaPrevista=horaPrevista;
        this.duracionPrevista=duracionPrevista;
        this.invitacion= new Invitacion(horaPrevista,fecha,duracionPrevista,tipoReunion);
        this.asistencia=new Asistencia(this.horaPrevista);
        this.organizador=organizador;
        this.nota=new Nota("nota.txt");


    }

    /**
     *metodo para obtener la invitacion.
     * @return retorna la invitacion  de la reunión.
     */
    public Invitacion getInvitacion(){
        return invitacion;
    }

    /**
     *metodo para obtener el registro de asistencias.
     * @return retorna las asistencias.
     */
    public Asistencia getAsistencia(){
        return asistencia;
    }

    /**
     *metodo para obtener la hora prevista de la reunión.
     * @return retorna la hora prevista de la reunión.
     */
    public Instant getHoraPrevista(){
        return horaPrevista;
    }

    /**
     *metodo  para obtener la hora de inicio real de la reunión.
     * @return retorna la hora de inicio real de la reunión.
     */
    public Instant getHoraInicio(){
        return horaInicio;
    }

    /**
     *metodo para obtener la hora en la que se terminó la reunión.
     * @return retorna la hora del fin de la reunión.
     */
    public Instant getHoraFin() {
        return horaFin;
    }

    /**
     *metodo para obtener la fecha de la reunión.
     * @return retorna la fecha de la reunión.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     *metodo para obtener la duración estimada de la reunión.
     * @return retorna la duración estimada de la reunión.
     */

    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    /**
     * metodo para obtener las notas respectivas a una reunión.
     * @return retorna un archivo de notas.
     */
    public Nota getNota(){
        return nota;
    }

    /**
     *metodo para obtener una lista referente a los empleados que asistieron a la reunión.
     * @return retorna los asistentes de la reunión.
     */
    public ArrayList<Persona> obtenerAsistencias() {
        return asistencia.getListaDeAsistencia();
    }

    /**
     *metodo para obtener una lista de ausencias en la reunión.
     * @return retorna la lista de ausentes de la reunión.
     */
    public ArrayList<Persona> obtenerAusencias() {
        ArrayList<Persona> ausentes = new ArrayList<>(invitacion.getListaDeInvitados());
        ausentes.removeAll(asistencia.getListaDeAsistencia());
        return ausentes;
    }

    /**
     *metodo para obtener la cantidad total de empleados que asistieron.
     * @return retorna un número referente a la cantidad de empleados que asistieron a la reunión.
     */
    public int obtenerTotalAsistencia() {
        return asistencia.getListaDeAsistencia().size();
    }

    /**
     *metodo para obtener un número entre 0 y 100 referente al porcentaje de asistencia de la reunión.
     * @return retorna el porcentaje de asistencia.
     */
    public float obtenerPorcentajeAsistencia() {
        int NumeroInvitados = invitacion.getListaDeInvitados().size();
        return (float) obtenerTotalAsistencia() / NumeroInvitados * 100;
    }

    /**
     *metodo para obtener la información acerca de los retrasos de los empleados a la reunión.
     * @return retorna la información de los retrasos.
     */
    public ArrayList<String> obtenerRetrasos() {
        return asistencia.getInformacionRetrasos();
    }

    /**
     *
     * @param horaInicio se refiere a la hora de inicio de la reunion
     */
    public void iniciar(Instant horaInicio){
        this.horaInicio=horaInicio;
    }

    /**
     *
     * @param horaFin se refiere a la hora en la que la reunión se terminó.
     */
    public void finalizar(Instant horaFin){
        this.horaFin=horaFin;

    }

    /**
     *
     * @return retorna la información de la reunión (tipo, hora prevista, duracion prevista, fecha, organizador, hora de inicio, hora de fin).
     */

    @Override
    public String toString() {
        String horaInicioTemp="";
        String horaFinalTemp="";
        if(horaInicio==null){
            horaInicioTemp="La reunion no ha empezado";
        }
        else{
            horaInicioTemp=horaInicio.toString();
        }
        if(horaFin==null){
            horaFinalTemp="La reunion no ha finalizado";
        }
        else{
            horaFinalTemp=horaFin.toString();
        }
        return
                "Tipo Reunion= "+ tipoReunion+
                ", Hora Prevista= "+ horaPrevista+
                        "Duracion Prevista= "+duracionPrevista+
                ", Fecha= "+fecha+
                ", organizada por "+ organizador.toString()+
                ", Hora de inicio: "+horaInicioTemp+
                ", Hora de termino: "+horaFinalTemp;

    }
    /**
     * metodo para calcular la duración total de una reunión en minutos.
     * @return retorna la duración entre la hora de inicio y la hora final de la reunión.
     */
    public float getDuracionTotal() {
        Duration duracion = Duration.between(horaInicio, horaFin);
        return duracion.toMillis() / 60000f;
    }
}

