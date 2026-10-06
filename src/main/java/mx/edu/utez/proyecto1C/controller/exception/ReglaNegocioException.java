package mx.edu.utez.proyecto1C.controller.exception;

// Excepción personalizada: se lanza cuando no se cumple una regla de negocio
public class ReglaNegocioException extends RuntimeException {

    public ReglaNegocioException(String mensaje) {
        super(mensaje);
    }
}