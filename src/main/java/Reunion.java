import java.util.ArrayList;
import java.time.*;
//Cambiamos Date por localDate que es de java.time

public abstract class Reunion {
    private LocalDate fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private ArrayList<Asistencia> asistentes;
    private ArrayList<Invitacion> invitados;

    public Reunion(LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, ArrayList<Invitacion> invitados){
        this.fecha=fecha;
        this.horaPrevista=horaPrevista;
        this.duracionPrevista=duracionPrevista;
        this.invitados=invitados;
    }
    public ArrayList<Asistencia> obtenerAsistencia(){
           return asistentes;
    }
}

