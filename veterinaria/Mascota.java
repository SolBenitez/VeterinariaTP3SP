
package veterinaria;

public class Mascota {
    private String nombre; 
    private String animal; 
    private int edad; 
    private Propietario p; 
    
    public Mascota(String nombre, String animal, int edad, Propietario p) {
        this.nombre = nombre; 
        this.animal = animal; 
        this.edad = edad; 
        this.p = p; 
    }
    public String getNombre() { 
        return nombre; 
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Propietario getP() {
        return p;
    }

    public void setP(Propietario p) {
        this.p = p;
    }
    
    public void mostrarInfo(){
        System.out.println("Mascota: " + nombre + ", Animal: " + animal + ", Edad: " + edad);
        System.out.println("Propietario: " + p.getNombre());
    }
    
}
