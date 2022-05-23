package uniquindio.controldeacceso.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uniquindio.controldeacceso.ControlDeAccesoApplication;
import uniquindio.controldeacceso.model.Rol;
import uniquindio.controldeacceso.services.RolService;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ControlDeAccesoApplication.class)
public class RolServiceTest {

    @Autowired
    public RolService rolService;

    @Test
    public void registrarRol() {
        Rol rol = new Rol(5, "Personal administrativo", new ArrayList<>());

        int rolesAntes = rolService.findAll().size();

        rolService.save(rol);

        int rolesDespues = rolService.findAll().size();

        Assert.assertNotEquals(rolesDespues, rolesAntes);
    }

    @Test
    @Sql("classpath:rolPrueba.sql")
    public void actualizarRol() {
        Rol rol = rolService.findById(1);
        rol.setNombreRol("Obrero");
        rolService.save(rol);

        Rol rolBusacado = rolService.findById(1);
        Assert.assertEquals("Obrero", rolBusacado.getNombreRol());

    }

    @Test
    @Sql("classpath:rolPrueba.sql")
    public void eliminarRol() {
        //eliminamos el rol
        rolService.delete(1);
        Rol rolBuscado = rolService.findById(1);
        Assert.assertNull(rolBuscado);
    }

    @Test
    @Sql("classpath:rolPrueba.sql")
    public void encontrarPorNombre() {
            Rol rolBuscado = rolService.findByNombreRol("Estudiante").orElse(null);
            if(rolBuscado==null){
                Assert.fail();
            }else{
                int idBuscado = rolBuscado.getCodigoRol();
                Assert.assertEquals(1, idBuscado);
            }

    }


}
