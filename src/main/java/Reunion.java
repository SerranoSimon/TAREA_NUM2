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
}

