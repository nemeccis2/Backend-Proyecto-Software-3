package uniquindio.controldeacceso.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uniquindio.controldeacceso.ControlDeAccesoApplication;
import uniquindio.controldeacceso.model.Ingreso;
import uniquindio.controldeacceso.model.Lugar;
import uniquindio.controldeacceso.services.IngresoService;
import uniquindio.controldeacceso.services.LugarService;

import javax.transaction.Transactional;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ControlDeAccesoApplication.class)
public class IngresoServiceTest {

    @Autowired
    public IngresoService ingresoService;
    @Autowired
    public LugarService lugarService;

    @Test
    @Sql("classpath:lugarPrueba.sql")
    @Sql("classpath:carreraPrueba.sql")
    @Sql("classpath:rolPrueba.sql")
    @Sql("classpath:usuarioPrueba.sql")
    @Sql("classpath:ingresoPrueba.sql")
    public void modificarIngreso(){
        Ingreso ingreso = ingresoService.findById(1);
        Lugar nuevoLugar = lugarService.findById(2);
        ingreso.setLugar(nuevoLugar);
        ingresoService.save(ingreso);

        Assert.assertEquals(nuevoLugar,ingreso.getLugar());
    }
}
