package mx.edu.utez.proyecto1C.service.usuario;

import jakarta.transaction.Transactional;
import mx.edu.utez.proyecto1C.controller.dto.RequestActualizarUsuarioDTO;
import mx.edu.utez.proyecto1C.controller.dto.RequestCrearUsuarioDTO;
import mx.edu.utez.proyecto1C.controller.exception.customException.BadRequestException;
import mx.edu.utez.proyecto1C.model.persona.Persona;
import mx.edu.utez.proyecto1C.model.usuario.Roles;
import mx.edu.utez.proyecto1C.model.usuario.Usuario;
import mx.edu.utez.proyecto1C.repositoryusuario.UsuarioRepository;
import mx.edu.utez.proyecto1C.repositoryusuario.persona.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PersonaRepository personaRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, PersonaRepository personaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.personaRepository = personaRepository;
    }

    public List<Usuario> getAllUsers(){
        return usuarioRepository.findAll();
    }

    @Transactional
    public Usuario createUser(RequestCrearUsuarioDTO payload){
        if(usuarioRepository.findByUsername(payload.getUsername()).isPresent()){
            throw new BadRequestException("El usuario ya existe");
        }

        Persona newPersona= new Persona();
        newPersona.setNombres(payload.getNombres());
        newPersona.setPrimerApellido(payload.getPrimerApellido());
        newPersona.setSegundoApellido(payload.getSegundoApellido());
        newPersona.setFechaNacimiento(payload.getFechaNacimiento());
        newPersona.setEmail(payload.getEmail());
        newPersona.setCurp(payload.getCurp());

        newPersona=personaRepository.save(newPersona);

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

    public Usuario getUserById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("El usuario con ID " + id + " no existe"));
    }

    @Transactional
    public Usuario changeStatus(Long id, boolean status) {
        Usuario usuario = getUserById(id);
        usuario.setEnable(status);
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Usuario updateUser(Long id, RequestActualizarUsuarioDTO payload) {
        Usuario usuario = getUserById(id);

        Optional<Usuario> usuarioExistente = usuarioRepository.findByUsername(payload.getUsername());
        if (usuarioExistente.isPresent() && usuarioExistente.get().getId() != id) {
            throw new BadRequestException("El nombre de usuario " + payload.getUsername() + " ya esta en uso");
        }

        usuario.setUsername(payload.getUsername());
        usuario.setDescripcion(payload.getDescripcion());

        return usuarioRepository.save(usuario);
    }
}