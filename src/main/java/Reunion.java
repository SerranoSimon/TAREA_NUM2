import java.util.ArrayList;
import java.time.*;
//Cambiamos Date por localDate que es de java.time

public abstract class Reunion {
    private LocalDate fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private Invitacion invitacion;
    private Asistencia asistencia;


    public Reunion(LocalDate fecha, Instant horaPrevista, Duration duracionPrevista){
        this.fecha=fecha;
        this.horaPrevista=horaPrevista;
        this.duracionPrevista=duracionPrevista;
        this.invitacion= new Invitacion(this.horaPrevista);
        this.asistencia=new Asistencia(this.horaPrevista);


    }
    public Invitacion getInvitacion(){
        return invitacion;
    }
    public Asistencia getAsistencia(){
        return asistencia;
    }
    public Instant getHoraPrevista(){
        return horaPrevista;
    }
    public Instant getHoraInicio(){
        return horaInicio;
    }
    public Instant getHoraFin() {
        return horaFin;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }
    public ArrayList<Empleado> obtenerAsistencias() {
        return asistencia.getListaDeAsistencia();
    }
    public ArrayList<Empleado> obtenerAusencias() {
        ArrayList<Empleado> ausentes = new ArrayList<>(invitacion.getListaDeInvitados());
        ausentes.removeAll(asistencia.getListaDeAsistencia());
        return ausentes;
    }
    public int obtenerTotalAsistencia() {
        return asistencia.getListaDeAsistencia().size();
    }
    public float obtenerPorcentajeAsistencia() {
        int NumeroInvitados = invitacion.getListaDeInvitados().size();
        return (float) obtenerTotalAsistencia() / NumeroInvitados * 100;
    }
    public ArrayList<String> obtenerRetrasos() {
        return asistencia.getInformacionRetrasos();
    }
}

