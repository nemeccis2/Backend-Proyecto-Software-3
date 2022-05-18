package uniquindio.ControlDeAcceso.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniquindio.ControlDeAcceso.Model.Lugar;
import uniquindio.ControlDeAcceso.Services.LugarService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LugarController {
    @Autowired
    private LugarService lugarService;

    //listar
    @GetMapping("/lugares")
    public List<Lugar> listar(){
        return lugarService.findAll();
    }

    //guardar
    @PostMapping("/lugares")
    public Lugar guardar(@RequestBody Lugar lugar){
        return lugarService.save(lugar);
    }

    //obtener un lugar
    @GetMapping("/lugares/{id}")
    public Lugar obtenerLugar(@PathVariable Integer id){
        return lugarService.findById(id);
    }

    //obtener un lugar por nombre
    @GetMapping("/lugar/{nombre}")
    public Lugar obtenerLugarNombre(@PathVariable String nombre){
        return lugarService.findByNombre(nombre);
    }

    //modificar un lugar
    @PutMapping("/lugares/{id}")
    public Lugar modificar(@RequestBody Lugar lugar, @PathVariable Integer id){
        Lugar lugarActual = lugarService.findById(id);
        lugarActual.setLugar(lugar);

        return lugarService.save(lugarActual);
    }

    @DeleteMapping("/lugares/{id}")
    public void eliminar(@PathVariable Integer id){
        lugarService.delete(id);
    }
}
