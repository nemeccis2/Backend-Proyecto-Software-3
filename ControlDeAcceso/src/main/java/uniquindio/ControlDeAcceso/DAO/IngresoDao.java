package uniquindio.conexionDatos.DAO;

import org.springframework.data.repository.CrudRepository;
import uniquindio.conexionDatos.Model.Ingreso;

public interface IngresoDao extends CrudRepository<Ingreso, Integer> {
    
}
