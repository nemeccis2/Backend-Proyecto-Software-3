package uniquindio.controldeacceso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniquindio.controldeacceso.exceptions.DatosInvalidosException;
import uniquindio.controldeacceso.model.Ingreso;
import uniquindio.controldeacceso.model.Lugar;
import uniquindio.controldeacceso.model.Usuario;
import uniquindio.controldeacceso.services.IngresoService;
import uniquindio.controldeacceso.services.LugarService;
import uniquindio.controldeacceso.services.UsuarioService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class IngresoController {
    @Autowired
    private IngresoService ingresoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private LugarService lugarService;

    //listar
    @GetMapping("/ingresos")
    public List<Ingreso> listar(){
        return ingresoService.findAll();
    }

    //obtener un ingreso
    @GetMapping("/ingresos/{id}")
    public Ingreso obtenerIngreso(@PathVariable Integer id){
        return ingresoService.findById(id);
    }


    //modificar un ingreso
    @PutMapping("/ingresos/{id}")
    public Ingreso modificar(@RequestBody Ingreso ingreso, @PathVariable Integer id){
        Ingreso ingresoActual = ingresoService.findById(id);
        ingresoActual.setIngreso(ingreso);

        return ingresoService.save(ingresoActual);
    }

    @DeleteMapping("/ingresos/{id}")
    public void eliminar(@PathVariable Integer id){
        ingresoService.delete(id);
    }

    //Generar un ingreso
    @PostMapping("/ingresos/{cedula}/{codigoLugar}")
    public void generarIngreso(@PathVariable Integer cedula, @PathVariable Integer codigoLugar) throws DatosInvalidosException{
        Usuario usuario = usuarioService.findById(cedula);

        Lugar lugar = lugarService.findById(codigoLugar);
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        Ingreso ingreso = new Ingreso(lugar, usuario, sqlDate);

        if(usuario!=null&&lugar!=null){
            ingresoService.save(ingreso);
        }else{
            throw new DatosInvalidosException("Datos invalidos");
        }
    }

    //obtener un ingreso por cedula de usuario
    @GetMapping("/ingresos/{cedula}-user")
    public List<Ingreso> obtenerIngresosCedula(@PathVariable Integer cedula){
        return ingresoService.findByCedula(cedula);
    }
}
