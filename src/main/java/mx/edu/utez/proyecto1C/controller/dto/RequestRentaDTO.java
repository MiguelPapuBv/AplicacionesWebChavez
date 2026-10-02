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
public class RequestRentaDTO {



    @NotBlank(message = "El nombre debe ser obligatorio")
    private String nombre_Cliente;





    @Min(value = 18, message = "No se puede aceptar la renta si el conductor es menor de edad")
    private int edad_Conductor;




    @NotBlank(message = "El tipo del vehiculo debe ser obligatorio")
    @Pattern(regexp = "COMPACTO|SEDAN|SUV|CAMIONETA", message = "Los Tipos de vehiculo son: compacto, sedan, Suv, camioneta")
    private String tipo_Vehiculo;






    @Min(value = 1, message = "La renta como minimo debe de ser por lo menos de 1 dia")
    @Max(value = 30, message = "La renta no debe ser durar mas de 30 dias")
    private int dias_Renta;




    @Min(value = 0, message = "Los kilometros no deben de ser negativos")
    @Max(value = 5000, message = "Los kilometros no deben de superar 5,000")
    private int kilometros_Estimados;

    private boolean seguro_Completo;



}