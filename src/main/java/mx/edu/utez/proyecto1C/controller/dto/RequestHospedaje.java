package mx.edu.utez.proyecto1C.controller.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestHospedajeDTO {




    @NotBlank(message = "El nombre debe ser obligatorio")
    private String nombre_Huesped;



    @NotBlank(message = "El tipo de habitacion debe ser obligatorio")
    @Pattern(regexp = "INDIVIDUAL|DOBLE|SUITE", message = "Los tipos de habitacion son: individual, Doble o Suite")
    private String tipo_Habitacion;





    @Min(value = 1, message = "Rentar la habitacion debe ser al menos por 1 noche")
    @Max(value = 30, message = "NO ouede haber reservaciones de más de 30 noches")
    private int numero_Noches;


    @Min(value = 1, message = "No puede haber 0 huespedes al menos debe haber 1 huesped")
    private int numero_Huespedes;




    @NotBlank(message = "La temporada debe ser obligatoria")
    @Pattern(regexp = "BAJA|REGULAR|ALTA", message = "Las temporadsa son : Baja, Regular, Alta")
    private String temporada;




    private boolean incluye_Desayuno;


    private boolean incluye_Estacionamiento;
}