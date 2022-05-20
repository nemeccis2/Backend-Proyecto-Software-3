package uniquindio.controldeacceso.dao;

import org.springframework.data.repository.CrudRepository;
import uniquindio.controldeacceso.model.Rol;

import java.util.Optional;

public interface RolDao extends CrudRepository<Rol, Integer> {
    Optional<Rol>findByNombreRol(String nombreRol);
}
