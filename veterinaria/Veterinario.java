
package veterinaria;

public class Veterinario extends Usuario{ 
  
    public Veterinario(String nombre, String usuario, String contrasena) {
        super(nombre, usuario, contrasena);
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("Opciones Veterinario:");
        System.out.println("1. Registrar Mascota");
        System.out.println("2. Ver Turnos");
        System.out.println("3. Ver Historial Médico");
        System.out.println("4. Generar Receta Electrónica");
        System.out.println("5. Agendar Turno");
        System.out.println("0. Salir");
    }
}

    

