package practica.excepciones;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String mensaje) {
        super (mensaje);
    }

    public ResourceNotFoundException() {
        super ();
    }
}
