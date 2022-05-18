package uniquindio.conexionDatos.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uniquindio.conexionDatos.Model.Usuario;

import java.util.Optional;

public interface UsuarioDao extends CrudRepository<Usuario, Integer>{
    Optional<Usuario>findByCorreo(String correo);
    boolean existsByCorreo(String correo);
    Optional<Usuario> findByCorreoAndPassword(String correo,String password);
}
