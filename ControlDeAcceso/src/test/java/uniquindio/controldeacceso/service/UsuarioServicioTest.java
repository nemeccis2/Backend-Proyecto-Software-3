package uniquindio.controldeacceso.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uniquindio.controldeacceso.ControlDeAccesoApplication;
import uniquindio.controldeacceso.model.Carrera;
import uniquindio.controldeacceso.model.Rol;
import uniquindio.controldeacceso.model.Usuario;
import uniquindio.controldeacceso.services.UsuarioService;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;

@SpringBootTest(classes = ControlDeAccesoApplication.class)
@Transactional
public class UsuarioServicioTest {

    @Autowired
    public UsuarioService usuarioService;

    @Test
    public void guardarUsuario(){
        //Entidades previas a la principal probada en esta clase
        Carrera carrera = new Carrera(1, "Ingeniera de sistemas", new ArrayList<Usuario>());
        Rol rol = new Rol(1, "Estudiante", new ArrayList<Usuario>());
        Date date = new Date(System.currentTimeMillis());

        //se crea la entidad y se guarda
        Usuario nuevoUsuario = new Usuario(123, "Juan Andres", "Paredes Villamil", carrera, rol, date, "Calle 10N #20-48", "3111111111", "juan@gmail.com", "1234", new ArrayList<>());
        usuarioService.save(nuevoUsuario);

        //Se busca la entidad en la base de datos para compararla con la guardada
        Usuario usuarioEncontrado = usuarioService.findById(123);

        //se hace la comparacion
        Assert.assertEquals(nuevoUsuario, usuarioEncontrado);
    }
}
