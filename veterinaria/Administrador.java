
package veterinaria;

public class Administrador extends Usuario {
    public Administrador(String nombre, String usuario, String contrasena) {
        super(nombre, usuario, contrasena);
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("Opciones Administrador:");
        System.out.println("1. Registrar Veterinario");
        System.out.println("2. Registrar Mascota");
        System.out.println("3. Ver Turnos");
        System.out.println("0. Salir");
    }
}
    

