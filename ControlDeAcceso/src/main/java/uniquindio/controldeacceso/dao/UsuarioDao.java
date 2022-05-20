package uniquindio.controldeacceso.dao;

import org.springframework.data.repository.CrudRepository;
import uniquindio.controldeacceso.model.Usuario;


import java.util.Optional;

public interface UsuarioDao extends CrudRepository<Usuario, Integer>{
    Optional<Usuario>findByCorreo(String correo);
    boolean existsByCorreo(String correo);
    Optional<Usuario> findByCorreoAndPassword(String correo,String password);
}
