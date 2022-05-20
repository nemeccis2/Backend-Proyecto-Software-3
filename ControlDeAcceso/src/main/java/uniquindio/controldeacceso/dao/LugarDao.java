package uniquindio.controldeacceso.dao;

import org.springframework.data.repository.CrudRepository;
import uniquindio.controldeacceso.model.Lugar;


public interface LugarDao extends CrudRepository<Lugar, Integer> {
    Lugar findByNombre(String nombre);
}
