package uniquindio.conexionDatos.DAO;

import org.springframework.data.repository.CrudRepository;
import uniquindio.conexionDatos.Model.Rol;

import java.util.Optional;

public interface RolDao extends CrudRepository<Rol, Integer> {
    Optional<Rol>findByNombreRol(String nombreRol);
}
