package mx.edu.utez.proyecto1C.service.usuario;
import java.util.List;
import org.springframework.stereotype.Service;
import mx.edu.utez.proyecto1C.model.usuario.Usuario;
import mx.edu.utez.proyecto1C.model.repository.usuario.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAllUsers() {
        return null; // El cuerpo del método no es totalmente visible o está incompleto en pantalla
    }
}