package mx.edu.utez.proyecto1C.controller.model.persona;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "personas")
@Getter
@Setter
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;

    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;

    private Date fechaNacimiento;
    private String correo;
    private String curp;
}
