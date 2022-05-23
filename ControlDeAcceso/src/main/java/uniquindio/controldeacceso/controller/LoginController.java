package uniquindio.controldeacceso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniquindio.controldeacceso.exceptions.DatosInvalidosException;
import uniquindio.controldeacceso.exceptions.UsuarioNoEncontradoException;
import uniquindio.controldeacceso.model.Usuario;
import uniquindio.controldeacceso.services.UsuarioService;
@RestController
@CrossOrigin
@RequestMapping("/api")
public class LoginController {
    @Autowired
    UsuarioService usuarioService;

    //obtener un ingreso
    @GetMapping("/login/{correo}/{password}")
    public Usuario verificarUsuario(@PathVariable String correo, @PathVariable String password) throws UsuarioNoEncontradoException, DatosInvalidosException {
        return usuarioService.findByCorreoAndPassword(correo, password);
    }
}

