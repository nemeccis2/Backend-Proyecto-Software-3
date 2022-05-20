package uniquindio.controldeacceso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uniquindio.controldeacceso.exceptions.UsuarioNoEncontradoException;
import uniquindio.controldeacceso.model.Usuario;
import uniquindio.controldeacceso.services.UsuarioService;

public class LoginController {
    @Autowired
    UsuarioService usuarioService;

    //obtener un ingreso
    @GetMapping("/login/{correo}/{password}")
    public Usuario obtenerIngreso(@PathVariable String correo, @PathVariable String password) throws UsuarioNoEncontradoException {
        return usuarioService.findByCorreoAndPassword(correo, password);
    }
}

