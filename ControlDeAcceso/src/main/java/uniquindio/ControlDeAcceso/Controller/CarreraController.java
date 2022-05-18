package uniquindio.ControlDeAcceso.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniquindio.ControlDeAcceso.Model.Carrera;
import uniquindio.ControlDeAcceso.Services.CarreraService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    //listar
    @GetMapping("/carreras")
    public List<Carrera> listar() {
        return carreraService.findAll();
    }

    //guardar
    @PostMapping("/carreras")
    public Carrera guardar(@RequestBody Carrera carrera) {
        return carreraService.save(carrera);
    }

    //obtener un usuario
    @GetMapping("/carreras/{id}")
    public Carrera obtenerCarrera(@PathVariable Integer id) {
        return carreraService.findById(id);
    }

    //modificar un usuario
    @PutMapping("/carreras/{id}")
    public Carrera modificar(@RequestBody Carrera carrera, @PathVariable Integer id) {
        Carrera carreraActual = carreraService.findById(id);
        carreraActual.setCarrera(carrera);

        return carreraService.save(carreraActual);
    }

    @DeleteMapping("/carreras/{id}")
    public void eliminar(@PathVariable Integer id) {
        carreraService.delete(id);
    }
}
