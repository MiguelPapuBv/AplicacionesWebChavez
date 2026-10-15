package mx.edu.utez.proyecto1C.service.usuario;

import jakarta.transaction.Transactional;
import mx.edu.utez.proyecto1C.controller.dto.RequestCrearUsuarioDTO;
import mx.edu.utez.proyecto1C.controller.exception.customException.BadRequestException;
import mx.edu.utez.proyecto1C.model.persona.Persona;
import mx.edu.utez.proyecto1C.model.usuario.Roles;
import mx.edu.utez.proyecto1C.model.usuario.Usuario;
import mx.edu.utez.proyecto1C.repositoryusuario.UsuarioRepository;
import mx.edu.utez.proyecto1C.repositoryusuario.persona.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PersonaRepository personaRepository;
    public UsuarioService(UsuarioRepository usuarioRepository, PersonaRepository personaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.personaRepository = personaRepository;
    }

    //servicios
    public List<Usuario> getAllUsers(){
        return usuarioRepository.findAll();
    }

    @Transactional
    public Usuario createUser(RequestCrearUsuarioDTO payload){
        //validar si el username ya existe
        if(usuarioRepository.findByUsername(payload.getUsername()).isPresent()){
            throw new BadRequestException("El usuario ya existe");
        }

        //registrar persona
        Persona newPersona= new Persona();
        newPersona.setNombres(payload.getNombres());
        newPersona.setPrimerApellido(payload.getPrimerApellido());
        newPersona.setSegundoApellido(payload.getSegundoApellido());
        newPersona.setFechaNacimiento(payload.getFechaNacimiento());
        newPersona.setEmail(payload.getEmail());
        newPersona.setCurp(payload.getCurp());

        //creando registro de persona y obtener sus datos como registro existente
        newPersona=personaRepository.save(newPersona);


        //crear instancia de usuario y llenarla en base a la info de payload
        Usuario newUser = new Usuario();
        newUser.setUsername(payload.getUsername());
        newUser.setPassword(payload.getPassword());
        newUser.setDescripcion(payload.getDescripcion());
        newUser.setEnable(true);
        newUser.setRol(
                Roles.valueOf(payload.getRol())
        );

        newUser.setPersona(newPersona);

        return usuarioRepository.save(newUser);




    }


}
