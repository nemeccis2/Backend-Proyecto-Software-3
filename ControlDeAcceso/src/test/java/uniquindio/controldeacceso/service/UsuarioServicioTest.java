package uniquindio.controldeacceso.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uniquindio.controldeacceso.ControlDeAccesoApplication;
import uniquindio.controldeacceso.exceptions.DatosInvalidosException;
import uniquindio.controldeacceso.exceptions.UsuarioNoEncontradoException;
import uniquindio.controldeacceso.model.Carrera;
import uniquindio.controldeacceso.model.Rol;
import uniquindio.controldeacceso.model.Usuario;
import uniquindio.controldeacceso.services.CarreraService;
import uniquindio.controldeacceso.services.LugarService;
import uniquindio.controldeacceso.services.RolService;
import uniquindio.controldeacceso.services.UsuarioService;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;

@SpringBootTest(classes = ControlDeAccesoApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UsuarioServicioTest {

    @Autowired
    public UsuarioService usuarioService;
    @Autowired
    public CarreraService carreraService;
    @Autowired
    public RolService rolService;

    @Test
    public void guardarUsuario(){

        Usuario nuevoUsuario = inicializarUsuario(123);
        Usuario usuarioGuardado = usuarioService.save(nuevoUsuario);

        //se hace la comparacion
        Assert.assertEquals(nuevoUsuario, usuarioGuardado);
    }

    @Test
    public void encontrarUsuarioId(){
        //Creamos y guardamos el usuario
        Usuario nuevoUsuario = inicializarUsuario(123);
        usuarioService.save(nuevoUsuario);

        //buscamos el usuario en la base de datos
        Usuario usuarioEncontrado = usuarioService.findById(123);

        //comprobamos que el usuario encontrado exista
        Assert.assertEquals(usuarioEncontrado, nuevoUsuario);
    }

    @Test
    public void encontrarCorreoContrasenia(){
        Usuario nuevoUsuario = inicializarUsuario(123);
        usuarioService.save(nuevoUsuario);

        try {
            Usuario usuarioEncontrado = usuarioService.findByCorreoAndPassword("juan@gmail.com","1234");
            Assert.assertEquals(nuevoUsuario,usuarioEncontrado);
        } catch (UsuarioNoEncontradoException | DatosInvalidosException e) {
            Assert.fail();
        }
    }

    public Usuario inicializarUsuario(Integer cedula){
        //Entidades previas a la principal probada en esta clase
        Carrera carrera = new Carrera(1, "Ingeniera de sistemas", new ArrayList<Usuario>());
        carreraService.save(carrera);

        Rol rol = new Rol(1, "Estudiante", new ArrayList<Usuario>());
        rolService.save(rol);

        Date date = new Date(System.currentTimeMillis());

        //se crea la entidad y se guarda
        Usuario nuevoUsuario = new Usuario(cedula, "Juan Andres", "Paredes Villamil", carrera, rol, date, "Calle 10N #20-48", "3111111111", "juan@gmail.com", "1234", new ArrayList<>());

        return nuevoUsuario;
    }
    @Test
    public void encontrarUsuarioEmail(){
        Usuario usuario = inicializarUsuario(123);

        //Se busca el usuario dando el email
        boolean encontrado1 = usuarioService.existsByEmail("juan@gmail.com");
        boolean encontrado2 = usuarioService.existsByEmail("juan2@gmail.com");

        //buscamos si el usuario se encontró con un correo real y esperamos que el resultado sea true
        Assert.assertTrue(encontrado1);
        //buscamos si el usuario se encontró con un correo falso y esperamos que el resultado sea false
        //Assert.assertFalse(encontrado2);

    }


}
