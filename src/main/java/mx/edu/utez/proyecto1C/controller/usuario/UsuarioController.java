package mx.edu.utez.proyecto1C.controller.usuario;

import jakarta.validation.Valid;
import mx.edu.utez.proyecto1C.controller.dto.RequestActualizarUsuarioDTO;
import mx.edu.utez.proyecto1C.model.usuario.Usuario;
import mx.edu.utez.proyecto1C.service.usuario.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin({"*"})
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers(){
        return ResponseEntity
                .status(200)
                .body(this.usuarioService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(this.usuarioService.getUserById(id));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Usuario> changeStatus(@PathVariable Long id, @RequestParam boolean enable) {
        return ResponseEntity.ok(this.usuarioService.changeStatus(id, enable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable Long id, @Valid @RequestBody RequestActualizarUsuarioDTO payload) {
        return ResponseEntity.ok(this.usuarioService.updateUser(id, payload));
    }
}