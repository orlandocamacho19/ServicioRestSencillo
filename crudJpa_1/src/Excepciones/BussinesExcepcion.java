package Excepciones;

public class BussinesExcepcion extends Exception {

    public BussinesExcepcion() {
    }

    public BussinesExcepcion(String message) {
        super(message);
    }

    public BussinesExcepcion(String message, Throwable cause) {
        super(message, cause);
    }

    public BussinesExcepcion(Throwable cause) {
        super(cause);
    }

}
