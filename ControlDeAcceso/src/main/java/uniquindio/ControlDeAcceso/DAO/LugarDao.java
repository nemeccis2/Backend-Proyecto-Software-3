package uniquindio.conexionDatos.DAO;

import org.springframework.data.repository.CrudRepository;
import uniquindio.conexionDatos.Model.Lugar;


public interface LugarDao extends CrudRepository<Lugar, Integer> {
    Lugar findByNombre(String nombre);
}
