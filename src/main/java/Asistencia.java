import java.time.Instant;
import java.util.ArrayList;
public class Asistencia {
    private Instant horaPrevista;
    private ArrayList<Empleado> listaDeAsistencia;
    private ArrayList<String> informacionRetrasos;

    public Asistencia(Instant horaPrevista){
        this.horaPrevista=horaPrevista;
        this.listaDeAsistencia=new ArrayList<>();
        this.informacionRetrasos=new ArrayList<>();
    }
    public ArrayList<Empleado> getListaDeAsistencia() {
        return listaDeAsistencia;
    }
    public void setLlegada(Instant horaLLegada){
        if(horaLLegada.isAfter(horaPrevista)){
            informacionRetrasos.add(listaDeAsistencia.getLast().toString()+" llegó a las "+ horaLLegada);
        }
    }
    public ArrayList<String> getInformacionRetrasos(){
        return informacionRetrasos;
    }


}
