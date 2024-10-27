
package veterinaria;

import java.util.Date;

public class Turnos {
    private Mascota mascota; 
    private Date fecha; 
    private String motivo; 
    
    public Turnos(Mascota mascota, Date fecha, String motivo){
     this.mascota = mascota; 
     this.fecha = fecha; 
     this.motivo = motivo; 
    }
    public void mostrarTurno() {
        System.out.println("El turno es para: " + mascota.getNombre()); 
        System.out.println("Fecha: " + fecha);
        System.out.println("Motivo: " + motivo);      
    }
    
}
