package uniquindio.controldeacceso.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uniquindio.controldeacceso.ControlDeAccesoApplication;
import uniquindio.controldeacceso.model.Carrera;
import uniquindio.controldeacceso.model.Rol;
import uniquindio.controldeacceso.model.Usuario;
import uniquindio.controldeacceso.services.CarreraService;
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

        int usuariosAntes = usuarioService.findAll().size();

        usuarioService.save(nuevoUsuario);

        int personasDespues = usuarioService.findAll().size();

        Assert.assertNotEquals(personasDespues, usuariosAntes);
    }

    @Test
    @Sql("classpath:rolPrueba.sql")
    @Sql("classpath:carreraPrueba.sql")
    @Sql("classpath:usuarioPrueba.sql")
    public void encontrarUsuarioId(){
        Usuario usuario = usuarioService.findById(123);

        if(usuario.equals(null)){
            Assert.fail();
        }
        Assert.assertEquals("David Alberto",usuario.getNombres());
    }

    @Sql("classpath:rolPrueba.sql")
    @Sql("classpath:carreraPrueba.sql")
    public Usuario inicializarUsuario(Integer cedula){
        //Entidades previas a la principal probada en esta clase
        Carrera carrera = carreraService.findById(1);
        Rol rol = rolService.findById(1);
        Date date = new Date(System.currentTimeMillis());

        //se crea la entidad y se guarda
        Usuario nuevoUsuario = new Usuario(cedula, "Juan Andres", "Paredes Villamil", carrera, rol, date, "Calle 10N #20-48", "3111111111", "juan@gmail.com", "1234", new ArrayList<>());

        return nuevoUsuario;
    }
    @Test
    @Sql("classpath:rolPrueba.sql")
    @Sql("classpath:carreraPrueba.sql")
    @Sql("classpath:usuarioPrueba.sql")
    public void encontrarUsuarioEmail(){
        try{
            Usuario usuarioEncontrado = usuarioService.findbyCorreo("davida.martinezg@uqvirtual.edu.co").orElse(null);
            int cedulaEncontrada = usuarioEncontrado.getCedula();
            Assert.assertEquals(123,cedulaEncontrada);
        }catch (Exception e){
            Assert.fail();
        }

    }


}
