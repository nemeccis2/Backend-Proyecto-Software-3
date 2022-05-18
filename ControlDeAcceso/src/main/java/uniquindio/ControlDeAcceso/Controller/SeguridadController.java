package uniquindio.conexionDatos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniquindio.conexionDatos.Model.Usuario;
import uniquindio.conexionDatos.Services.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class SeguridadController {

    @Autowired
    private UsuarioService usuarioService;

    //obtener un usuario por correo y contraseña
    @GetMapping("/login/{correo}/{password}")
    public Usuario verificarUsuario(@PathVariable String correo, @PathVariable String password) throws Exception {
        return usuarioService.findByCorreoAndPassword(correo, password);
    }
}
