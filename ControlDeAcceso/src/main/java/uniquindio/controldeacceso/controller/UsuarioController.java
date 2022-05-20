package uniquindio.controldeacceso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniquindio.controldeacceso.model.Usuario;
import uniquindio.controldeacceso.services.UsuarioService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    //listar
    @GetMapping("/usuarios")
    public List<Usuario> listar(){
        return usuarioService.findAll();
    }

    //guardar
    @PostMapping("/usuarios")
    public Usuario guardar(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    //obtener un usuario
    @GetMapping("/usuarios/{id}")
    public Usuario obtenerUsuario(@PathVariable Integer id){
        return usuarioService.findById(id);
    }

    //modificar un usuario
    @PutMapping("/usuarios/{id}")
    public Usuario modificar(@RequestBody Usuario usuario, @PathVariable Integer id){
        Usuario usuarioActual = usuarioService.findById(id);
        usuarioActual.setUsuario(usuario);

        return usuarioService.save(usuarioActual);
    }

    @DeleteMapping("/usuarios/{id}")
    public void eliminar(@PathVariable Integer id){
        usuarioService.delete(id);
    }
}
