
package veterinaria;

import java.util.Date;

public class Receta {
    private String nomVet;
    private String  detalles; 
    private Date fecha; 
    
    public Receta(String nomVet, String detalles, Date fecha){
        this.nomVet = nomVet; 
        this.detalles = detalles; 
        this.fecha = fecha; 
    }

    public String getNomVet() {
        return nomVet;
    }

    public void setNomVet(String nomVet) {
        this.nomVet = nomVet;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public void mostrarReceta() {
        System.out.println("Receta Electrónica: ");
        System.out.println("Veterinario: " + nomVet);
        System.out.println("Fecha: " + fecha);
        System.out.println("Detalles: " + detalles);
    }
    
}
