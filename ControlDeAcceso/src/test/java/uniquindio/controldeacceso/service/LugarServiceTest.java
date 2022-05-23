package uniquindio.controldeacceso.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uniquindio.controldeacceso.ControlDeAccesoApplication;
import uniquindio.controldeacceso.model.Lugar;
import uniquindio.controldeacceso.services.LugarService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ControlDeAccesoApplication.class)
public class LugarServiceTest {

    @Autowired
    public LugarService lugarService;

    @Test
    public void registrarLugar() {
        Lugar lugar = new Lugar(5, "Facultad de ingenieria", "Calle 10N#00", "Bloque", new ArrayList<>());

        int lugaresAntes = lugarService.findAll().size();

        lugarService.save(lugar);

        int lugaresDespues = lugarService.findAll().size();

        Assert.assertNotEquals(lugaresDespues, lugaresAntes);
    }

    @Test
    @Sql("classpath:lugarPrueba.sql")
    public void actualizarLugar() {
        Lugar lugar = lugarService.findById(1);
        lugar.setNombre("Bloque de topografia");
        lugarService.save(lugar);

        Lugar lugarBusacado = lugarService.findById(1);
        Assert.assertEquals("Bloque de topografia", lugarBusacado.getNombre());

    }

    @Test
    @Sql("classpath:lugarPrueba.sql")
    public void eliminarLugar() {
        //eliminamos el lugar
        lugarService.delete(1);
        Lugar lugarBuscado = lugarService.findById(1);
        Assert.assertNull(lugarBuscado);
    }

    @Test
    @Sql("classpath:lugarPrueba.sql")
    public void encontrarPorNombre() {
        Lugar lugarBuscado = lugarService.findByNombre("Ingenieria");
        int idBuscado = lugarBuscado.getCodigoLugar();
        Assert.assertEquals(3, idBuscado);
    }
}
