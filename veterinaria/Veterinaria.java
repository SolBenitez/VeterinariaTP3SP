
package veterinaria;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Veterinaria {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        //Listas para almacenar las diferentes entidades como mascotas, turnos, recetas, veterinarios y propietarios. 
        List<Mascota> m = new ArrayList<>();
        List<Turnos> t = new ArrayList<>();
        List<Receta> r = new ArrayList<>();
        List<Veterinario> v = new ArrayList<>();
        List<Propietario> p = new ArrayList<>();

        //Utilizaremos el bloque try para manejar potenciales excepciones. 
        try {
            //Este bloque permitirá la selección de rol del usuario. 
            System.out.println("Seleccione un rol");
            System.out.println("1. Veterinario");
            System.out.println("2. Administrador");

            int o = leer.nextInt();
            leer.nextLine();

            //Dependiendo de la elección del usuario el objeto se almacenará en la variable u.  
            Usuario u;

            //Utilizaremos el condicional if else para asignar el rol de usuario en función de la opción seleccionada.
            if (o == 1) {
                u = new Veterinario("vet1", "usuarVet", "contraVet");
            } else if (o == 2) {
                u = new Administrador("admin1", "usuarAdmin", "contraAdmin");
            } else {
                System.out.println("Error");
                return;
            }

            boolean continuar = true;

            //Utilizaremos un bloque while para que se ejecute de forma continua mientras la variable continuar sea true. 
            while (continuar) {
                u.mostrarOpciones();
                System.out.println("Seleccione una opción");
                int seleccion = leer.nextInt();
                leer.nextLine();

                //Utilizaremos un switch para las pciones del menú basadas en la selección del usuario. 
                switch (seleccion) {
                    case 1:
                        if (u instanceof Veterinario) {
                            registrarMascota(leer, m);
                        } else if (u instanceof Administrador) {
                            System.out.println("Registrar Veterinario");
                            registrarVeterinario(leer, v);
                        }
                        break;
                    case 2:
                        if (u instanceof Veterinario) {
                            System.out.println("Ver turnos");
                            mostrarTurnos(t);
                        } else if (u instanceof Administrador) {
                            registrarMascota(leer, m);
                        }
                        break;
                    case 3:
                        if (u instanceof Veterinario) {
                            System.out.println("Ver Historial Médico");
                        } else if (u instanceof Administrador) {
                            System.out.println("Registrar Propietario");
                        }
                        break;
                    case 4:
                        if (u instanceof Veterinario) {
                            System.out.println("Generar Receta Electrónica");
                            generarReceta(leer, r, u);
                        } else if (u instanceof Administrador) {
                            System.out.println("Ver Turnos");
                        }
                        break;
                    case 5:
                        System.out.println("Agendar Turno: ");
                        agendarTurno(leer, m, t);
                        break;
                    //Si el usuario selecciona 0, se establece continuar como false lo que permite la salida del bucle y la finalización del programa.
                    case 0:
                        continuar = false;
                        System.out.println("Saliendo del sistema");
                        break;
                    //Si el usuario ingresa un número que no corresponde a ninguna opción válida se mostrará un mensaje de error.
                    default:
                        System.out.println("Opción incorrecta: Intente nuevamente");
                        break;
                }
            }
        } //Utilizaremos un InputMismatchException para mostrar un mensaje de error si se capturar valores no numéricos en lugar de un número entero. 
        catch (InputMismatchException e) {
            System.out.println("Error: Por favor, ingrese un número");
            leer.nextLine();
        } finally {
            leer.close();
        }
    }

    //Método para registrar un Veterinario. 
    private static void registrarVeterinario(Scanner leer, List<Veterinario> veterinariosList) {
        try {
            System.out.print("Ingrese el nombre del veterinario: ");
            String nombreVet = leer.nextLine();
            System.out.print("Ingrese el usuario del veterinario: ");
            String usuarioVet = leer.nextLine();
            System.out.print("Ingrese la contraseña del veterinario: ");
            String contrasenaVet = leer.nextLine();

            Veterinario nuevoVeterinario = new Veterinario(nombreVet, usuarioVet, contrasenaVet);
            veterinariosList.add(nuevoVeterinario);

            System.out.println("Veterinario registrado exitosamente.");
        } catch (InputMismatchException e) {
            System.out.println("Error en los datos, intente nuevamente.");
            leer.nextLine();
        }
    }

    //Método para registrar Mascotas y sus popietarios. 
    private static void registrarMascota(Scanner leer, List<Mascota> m) {
        try {
            System.out.println("Registrar nueva mascota");
            System.out.println("Nombre: ");
            String nombrem = leer.nextLine();
            System.out.println("Animal: ");
            String animal = leer.nextLine();
            System.out.println("Edad: ");
            int edadm = leer.nextInt();
            leer.nextLine();

            //Registro del propietario de la mascota.
            System.out.println("Nombre del propietario: ");
            String nombrep = leer.nextLine();
            System.out.println("Dirección: ");
            String direccionp = leer.nextLine();
            System.out.println("Teléfono: ");
            String telefonop = leer.nextLine();

            Propietario p = new Propietario(nombrep, direccionp, telefonop);
            Mascota mascota = new Mascota(nombrem, animal, edadm, p);
            m.add(mascota);

            System.out.println("Mascota registrada exitosamente");
        } catch (InputMismatchException e) {
            System.out.println("Error: edad inválida, ingrese un número entero");
            leer.nextLine();
        }
    }

    //Método para agendar Turnos a Mascotas. 
    private static void agendarTurno(Scanner leer, List<Mascota> m, List<Turnos> t) {
        System.out.println("Agendar Turno para una mascota:");
        if (m.isEmpty()) {
            System.out.println("No existe una mascota registrada");
            return;
        }
        System.out.println("Seleccione una mascota: ");
        for (int i = 0; i < m.size(); i++) {
            System.out.println((i + 1) + ". " + m.get(i).getNombre());
        }
        int index = leer.nextInt() - 1;
        leer.nextLine();
        if (index < 0 || index >= m.size()) {
            System.out.println("Selección inválida");
            return;
        }
        System.out.print("Ingrese la fecha (formato: dd/MM/yyyy): ");
        String fechaString = leer.nextLine();
        Date fecha = new Date();

        Mascota mascota = m.get(index);

        System.out.println("Motivo del turno: ");
        String motivo = leer.nextLine();

        Turnos turno = new Turnos(mascota, fecha, motivo);
        t.add(turno);

        System.out.println("Turno asignado exitosamente");

    }

    //Método para mostrar Turnos.
    private static void mostrarTurnos(List<Turnos> turnos) {
        if (turnos.isEmpty()) {
            System.out.println("No hay turnos agendados.");
        } else {
            for (Turnos turno : turnos) {
                turno.mostrarTurno();
            }
        }
    }

    //Método para Generar Recetas Electrónicas.  
    private static void generarReceta(Scanner leer, List<Receta> r, Usuario u) {
        System.out.print("Ingrese los detalles de la receta: ");
        String detalles = leer.nextLine();

        Date fecha = new Date();
        Receta receta = new Receta(u.getNombre(), detalles, fecha);
        r.add(receta);

        System.out.println("Receta generada exitosamente.");
        receta.mostrarReceta();
    }
}
