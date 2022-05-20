package uniquindio.controldeacceso.dao;

import org.springframework.data.repository.CrudRepository;
import uniquindio.controldeacceso.model.Ingreso;

public interface IngresoDao extends CrudRepository<Ingreso, Integer> {
    
}
