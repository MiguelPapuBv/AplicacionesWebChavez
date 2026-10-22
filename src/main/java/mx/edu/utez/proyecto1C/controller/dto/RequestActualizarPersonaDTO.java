package mx.edu.utez.proyecto1C.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestActualizarPersonaDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombres;

    @NotBlank(message = "El primer apellido es obligatorio")
    private String primerApellido;

    private String segundoApellido;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private Date fechaNacimiento;

    @NotBlank(message = "El correo electronico es obligatorio")
    @Email(message = "El correo electronico debe tener un formato valido")
    private String email;

    @NotBlank(message = "El CURP es obligatorio")
    @Pattern(
        regexp = "^[A-Z]{4}\\d{6}[HM][A-Z]{5}[0-9A-Z]\\d$",
        message = "El formato de la CURP no es valido"
    )
    private String curp;
}