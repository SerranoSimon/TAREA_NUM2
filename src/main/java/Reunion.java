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


    public Reunion(LocalDate fecha, Instant horaPrevista, Duration duracionPrevista){
        this.fecha=fecha;
        this.horaPrevista=horaPrevista;
        this.duracionPrevista=duracionPrevista;
        this.invitacion= new Invitacion(this.horaPrevista);
        Asistencia asistencia=new Asistencia();


    }
    public Invitacion getInvitacion(){
        return invitacion;
    }
}

