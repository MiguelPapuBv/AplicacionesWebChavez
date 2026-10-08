package mx.edu.utez.proyecto1C.controller.model.direcciones;

import jakarta.persistence.*;
import lombok.*;
import mx.edu.utez.proyecto1C.controller.model.persona.Persona;

@Entity
@Table(name = "direcciones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String calle;
    private String colonia;
    private String municipio;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
}