package mx.edu.utez.proyecto1C.service.persona;

import jakarta.transaction.Transactional;
import mx.edu.utez.proyecto1C.controller.dto.RequestActualizarPersonaDTO;
import mx.edu.utez.proyecto1C.controller.exception.customException.BadRequestException;
import mx.edu.utez.proyecto1C.model.persona.Persona;
import mx.edu.utez.proyecto1C.repositoryusuario.persona.PersonaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public Persona getPersonaById(Integer id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("La persona con ID " + id + " no existe"));
    }

    @Transactional
    public Persona updatePersona(Integer id, RequestActualizarPersonaDTO payload) {
        Persona persona = getPersonaById(id);

        persona.setNombres(payload.getNombres());
        persona.setPrimerApellido(payload.getPrimerApellido());
        persona.setSegundoApellido(payload.getSegundoApellido());
        persona.setFechaNacimiento(payload.getFechaNacimiento());
        persona.setEmail(payload.getEmail());
        persona.setCurp(payload.getCurp());

        return personaRepository.save(persona);
    }
}