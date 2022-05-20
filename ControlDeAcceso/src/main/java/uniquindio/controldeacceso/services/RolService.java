package uniquindio.controldeacceso.services;

import uniquindio.controldeacceso.model.Rol;

import java.util.List;
import java.util.Optional;

public interface RolService {

    public List<Rol> findAll();
    public Rol save(Rol rol);
    public Rol findById(Integer id);
    public void delete(Integer id);
    Optional<Rol> findByNombreRol(String nombreRol);
}
