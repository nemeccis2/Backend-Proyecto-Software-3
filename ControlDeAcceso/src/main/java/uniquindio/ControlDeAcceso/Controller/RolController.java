package uniquindio.ControlDeAcceso.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniquindio.ControlDeAcceso.Model.Rol;
import uniquindio.ControlDeAcceso.Services.RolService;;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RolController {
    @Autowired
    private RolService rolService;

    //listar
    @GetMapping("/roles")
    public List<Rol> listar(){
        return rolService.findAll();
    }

    //guardar
    @PostMapping("/roles")
    public Rol guardar(@RequestBody Rol rol){
        return rolService.save(rol);
    }

    //obtener un rol
    @GetMapping("/roles/{id}")
    public Rol obtenerRol(@PathVariable Integer id){
        return rolService.findById(id);
    }

    //modificar un rol
    @PutMapping("/roles/{id}")
    public Rol modificar(@RequestBody Rol rol, @PathVariable Integer id){
        Rol rolActual = rolService.findById(id);
        rolActual.setRol(rol);

        return rolService.save(rolActual);
    }

    @DeleteMapping("/roles/{id}")
    public void eliminar(@PathVariable Integer id){
        rolService.delete(id);
    }
}
