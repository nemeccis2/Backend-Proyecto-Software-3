package uniquindio.ControlDeAcceso.DAO;

import org.springframework.data.repository.CrudRepository;
import uniquindio.ControlDeAcceso.Model.Lugar;


public interface LugarDao extends CrudRepository<Lugar, Integer> {
    Lugar findByNombre(String nombre);
}
