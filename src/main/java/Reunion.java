import java.io.IOException;
import java.util.ArrayList;
import java.time.*;
/**
 * Clase abstracta que representa una reunión.
 */
public abstract class Reunion {
    private tipoReunion tipoReunion;
    private LocalDate fecha;
    private Instant horaPrevista;
    private float duracionPrevistaHoras;
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
     * @param duracionPrevistaHoras se refiere a la duración estimada de la reunión.
     * @param organizador se refiere a un empleado que actuará como organizador en la reunión.
     * @throws IOException excepción que sirve para evitar errores referentes a las notas.
     */

    public Reunion(tipoReunion tipoReunion, LocalDate fecha, Instant horaPrevista, float duracionPrevistaHoras, Organizador organizador) throws IOException {
        this.tipoReunion=tipoReunion;
        this.fecha=fecha;
        this.horaPrevista=horaPrevista;
        this.duracionPrevistaHoras=duracionPrevistaHoras;
        this.invitacion= new Invitacion(horaPrevista,fecha,duracionPrevistaHoras,tipoReunion);
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

    public float getDuracionPrevista() {
        return duracionPrevistaHoras;
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
     * @return retorna la lista de asistencia  de la reunión.
     */
    public ArrayList<Persona> obtenerAsistencias() {
        return asistencia.getListaDeAsistencia();
    }

    /**
     * metodo para obtener una lista de las personas invitadas a la reunión.
     * @return retorna la lista de invitados de la reunión.
     */
    public ArrayList<Persona> obtenerInvitados() {
        return invitacion.getListaDeInvitados();
    }


    /**
     *metodo para obtener una lista de ausencias en la reunión.
     * @return retorna la lista de ausentes de la reunión.
     */
    public ArrayList<Persona> obtenerAusencias() {
        ArrayList<Persona> ausentes = new ArrayList<>(obtenerInvitados());
        ausentes.removeAll(obtenerAsistencias());
        return ausentes;
    }

    /**
     *metodo para obtener la cantidad total de empleados que asistieron.
     * @return retorna un número  referente a la cantidad de empleados que asistieron a la reunión.
     */
    public int obtenerTotalAsistencia() {
        return asistencia.getListaDeAsistencia().size();
    }

    /**
     *metodo para obtener un número entre 0 y 100 referente al porcentaje de asistencia de la reunión.
     * @return retorna el porcentaje de asistencia.
     */
    public float obtenerPorcentajeAsistencia() {
        int NumeroInvitados = obtenerInvitados().size(); //nunca es 0 porque siempre hay un organizador.
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
     *metodo que inicia la reunion a cierta hora
     * @param horaInicio se refiere a la hora de inicio de la reunion
     */
    public void iniciar(Instant horaInicio){
        this.horaInicio=horaInicio;
    }

    /**
     *metodo que finaliza la reunion a cierta hora
     * @param horaFin se refiere a la hora en la que la reunión se terminó.
     */
    public void finalizar(Instant horaFin) throws FinalizarSinIniciar{
        if(horaInicio==null){
            throw new FinalizarSinIniciar("No se puede finalizar la reunión si aún no ha iniciado");
        }
        this.horaFin=horaFin;

    }
    /**
     * metodo para calcular la duración total de una reunión en horas.
     * @return retorna la duración entre la hora de inicio y la hora final de la reunión.
     */
    public float calcularTiempoReal() throws NullPointerException{
        if(horaInicio==null || horaFin==null){
            throw new NullPointerException("La reunion aún no ha empezado o terminado");
        }
        else{
            Duration duracionReal=Duration.between(horaInicio,horaFin);
             return duracionReal.toMinutes()/60f;}
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
                        ", Duracion Prevista= "+duracionPrevistaHoras+"h"+
                ", Fecha= "+fecha+
                ", organizada por "+ organizador.toString()+
                ", Hora de inicio: "+horaInicioTemp+
                ", Hora de termino: "+horaFinalTemp;

    }


}

