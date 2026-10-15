package mx.edu.utez.proyecto1C.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCrearUsuarioDTO {
    @NotBlank(message="El username es obligatorio" )
    @Size(min=4, max=20, message = "el username debe ser entre 4 y 20 caracteres")
    private String username;

    @NotBlank(message="la contraseña es obligatoria")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d).{8,}$",
            message = "La contraseña debe tener al menos 8 caracteres, una mayúscula y un número"
    )
    private String password;

    @NotBlank(message="el rol es obligatoriio")
    @Pattern(
            regexp = "^(ADMIN|GESTOR|ESTUDIANTE)$",
            message = "El rol debe ser ADMIN, GESTOR o ESTUDIANTE"
    )

    private String rol;

    private String descripcion;

    // datos de persona
    @NotBlank(message="el nombre es obligatorio")
    private String nombres;

    @NotBlank(message="el apellido es obligatorio")
    private String primerApellido;


    private String segundoApellido;

    @Past
    @JsonFormat(pattern="yyy-MM-dd")
    private Date fechaNacimiento;

    @NotBlank(message="el correo es obligatorio")
    @Email(message="el correo es invalido")
    private String email;

    @NotBlank(message ="el curp es obligatorio")
    private String curp;



}