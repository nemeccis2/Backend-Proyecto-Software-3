package uniquindio.ControlDeAcceso.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uniquindio.ControlDeAcceso.Model.Usuario;
import uniquindio.ControlDeAcceso.Services.UsuarioService;

import java.util.List;

public class LoginController {
    @Autowired
    UsuarioService usuarioService;

    //obtener un ingreso
    @GetMapping("/login/{correo}/{password}")
    public Usuario obtenerIngreso(@PathVariable String correo, @PathVariable String password) throws Exception {
        return usuarioService.findByCorreoAndPassword(correo, password);
    }
}

