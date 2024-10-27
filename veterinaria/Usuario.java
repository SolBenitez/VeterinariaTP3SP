
package veterinaria;

public abstract class Usuario {
    protected String nombre; 
    protected String usuario; 
    protected String contraseña; 
    
    public Usuario(String nombre, String usuario, String contraseña){
        this.nombre = nombre; 
        this.usuario = usuario; 
        this.contraseña = contraseña; 
    }
    public abstract void mostrarOpciones(); 
    
    public String getNombre(){
        return nombre; 
    }
}
 

    

