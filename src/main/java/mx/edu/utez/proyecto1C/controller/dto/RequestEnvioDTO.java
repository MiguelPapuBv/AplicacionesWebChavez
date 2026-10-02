package mx.edu.utez.proyecto1C.controller.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
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
public class RequestEnvioDTO {


    @NotBlank(message = "Por favor el C.P. debe ser obligatorio")
    @Pattern(regexp = "^\\d{5}$", message = "Error El C.P. debe tener solo 5 digitos")
    private String codPost;




    @DecimalMax(value = "50", message = "Lo siento tu paquete no debe de pesar mas de 50 kg")
    private double peso_Kg;





    @DecimalMax(value = "150", message = "La dimension de tu paquete no puede ser mayor a 150 cm")
    private double largo_Cm;




    @DecimalMax(value = "150", message = "EL ancho de tu paquete no puede ser mayor a 150 cm")
    private double ancho_Cm;






    @DecimalMax(value = "150", message = "El largo de tu paquete no puede ser mayor a 150 cm")
    private double alto_Cm;


    @NotBlank(message = "Selecciona el tipo de envio, es obligatorio")
    @Pattern(regexp = "ESTANDAR|EXPRESS|MISMO_DIA", message = "Tipo de envio: estandar express o mismo_dia")
    private String tipo_Envio;






    @DecimalMin(value = "0", message = "Error el valor declarado no debe de ser negativo")
    private double valor_Declarado;



}