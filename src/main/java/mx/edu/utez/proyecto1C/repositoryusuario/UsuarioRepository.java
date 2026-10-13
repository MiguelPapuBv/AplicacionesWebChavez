package mx.edu.utez.proyecto1C.repositoryusuario;

import mx.edu.utez.proyecto1C.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}



