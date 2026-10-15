package mx.edu.utez.proyecto1C.controller.exception.customException;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message){
        super(message);

    }
}