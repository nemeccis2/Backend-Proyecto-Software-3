package uniquindio.ControlDeAcceso.DAO;

import org.springframework.data.repository.CrudRepository;
import uniquindio.ControlDeAcceso.Model.Ingreso;

public interface IngresoDao extends CrudRepository<Ingreso, Integer> {
    
}
