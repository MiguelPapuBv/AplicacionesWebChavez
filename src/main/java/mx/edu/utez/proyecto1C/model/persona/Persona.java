package mx.edu.utez.proyecto1C.model.persona;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.proyecto1C.model.cursos.Curso;

import java.sql.Date;
import java.util.List;


@Entity
@Table(name="personas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String nombres;
    private String primerApellido;
    private String segundoApellido;



    private Date fechaNacimiento;

    private String email;
    private String curp;

    /*
    @ManyToMany
    @JoinTable(
            name="personas_cursos",
            joinColumns = @JoinColumn(name="pesona_id"),
            inverseJoinColumns = @JoinColumn(name="cusos_id")
    )
    private List<Curso> cursos;
*/


}