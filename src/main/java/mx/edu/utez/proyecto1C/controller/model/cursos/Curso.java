package mx.edu.utez.proyecto1C.controller.model.cursos;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "cursos")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Curso {


    @
            Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;


    private String nombre;


}