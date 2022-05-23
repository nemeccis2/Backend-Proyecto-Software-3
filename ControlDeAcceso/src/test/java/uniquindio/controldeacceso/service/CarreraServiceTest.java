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
import uniquindio.controldeacceso.services.CarreraService;

import javax.transaction.Transactional;
import java.util.ArrayList;

    @Transactional
    @RunWith(SpringJUnit4ClassRunner.class)
    @SpringBootTest(classes = ControlDeAccesoApplication.class)
public class CarreraServiceTest {

    @Autowired
    public CarreraService carreraService;

    @Test
    public void registrarCarrera(){
        //creamos el objeto a guardar
        Carrera carrera = new Carrera(4, "Ingenieria de sistemas", new ArrayList<>());

        //vemos cuantos objetos de este tipo existian antes en la base de datos
        int carrerasAntes = carreraService.findAll().size();

        //guardamos el objeto que creamos
        carreraService.save(carrera);

        //vemos cuantos objetos de este tipo existen ahora
        int carrerasDespues = carreraService.findAll().size();

        //comparamos las cantidades para ver si son distintos
        Assert.assertNotEquals(carrerasAntes,carrerasDespues);

    }

    @Test
    @Sql("classpath:carreraPrueba.sql")
    public void actualizarCarreraId(){
        //obtenemos y actualizamos la carrera
        Carrera carrera = carreraService.findById(1);
        carrera.setNombreCarrera("Ingenieria de sistemas y computacion");
        carreraService.save(carrera);

        //encontramos y comparamos la carrera editada
        Carrera carreraBuscada = carreraService.findById(1);
        Assert.assertEquals("Ingenieria de sistemas y computacion", carreraBuscada.getNombreCarrera());
    }

    @Test
    @Sql("classpath:carreraPrueba.sql")
    public void eliminarCarrera(){
        //eliminamos la carrera
        carreraService.delete(1);
        Carrera carreraBuscada = carreraService.findById(1);
        Assert.assertNull(carreraBuscada);
    }

}
