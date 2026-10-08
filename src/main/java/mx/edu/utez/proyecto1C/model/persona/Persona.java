package mx.edu.utez.proyecto1C.model.persona;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.proyecto1C.model.cursos.Curso;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;


import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Personas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nombres;
    private String primerA;
    private String SegundoA;


    private Date fecha;
    private String Correo;
    private String Curp;




    @ManyToMany
    @JoinTable(
            name = "persona_cursos",
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursos;

}