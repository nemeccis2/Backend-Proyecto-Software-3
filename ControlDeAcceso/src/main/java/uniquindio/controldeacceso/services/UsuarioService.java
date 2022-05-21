package uniquindio.controldeacceso.services;


import uniquindio.controldeacceso.exceptions.DatosInvalidosException;
import uniquindio.controldeacceso.exceptions.UsuarioNoEncontradoException;
import uniquindio.controldeacceso.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public List<Usuario> findAll();
    public Usuario save(Usuario usuario);
    public Usuario findById(Integer id);
    public void delete(Integer id);
    public Optional<Usuario> findbyCorreo(String correo);
    public boolean existsByEmail(String email);
    public Usuario findByCorreoAndPassword(String correo, String password) throws UsuarioNoEncontradoException, DatosInvalidosException;
}
