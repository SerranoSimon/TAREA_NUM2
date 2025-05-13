import java.time.Instant;
import java.util.ArrayList;

public class Invitacion {
    private Instant hora;
    private ArrayList<Empleado> listaDeInvitados;
    public Invitacion(Instant hora){
        this.hora=hora;
        this.listaDeInvitados=new ArrayList<>();
    }
    public Instant getHora(){
        return hora;
    }
    public ArrayList<Empleado> getListaDeInvitados() {
        return listaDeInvitados;
    }
}
