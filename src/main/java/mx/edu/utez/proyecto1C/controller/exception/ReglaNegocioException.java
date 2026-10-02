package mx.edu.utez.proyecto1C.controller.dto;

// Excepción personalizada: se lanza cuando no se cumple una regla de negocio
public class ReglaNegocioException extends RuntimeException {

    public ReglaNegocioException(String mensaje) {
        super(mensaje);
    }
}