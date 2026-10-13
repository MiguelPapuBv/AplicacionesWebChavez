package mx.edu.utez.proyecto1C.model.persona_curso;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.proyecto1C.model.cursos.Curso;
import mx.edu.utez.proyecto1C.model.persona.Persona;

@Entity
@Table(name="personas_cursos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaCurso {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private double calificacion;
    private String estado;

    @ManyToOne
    @JoinColumn(name="persona_id")
    private Persona persona;


    @ManyToOne
    @JoinColumn(name="curso_id")
    private Curso curso;



}