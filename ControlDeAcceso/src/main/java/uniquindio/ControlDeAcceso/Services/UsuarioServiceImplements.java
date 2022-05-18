package uniquindio.ControlDeAcceso.Services;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import uniquindio.ControlDeAcceso.DAO.UsuarioDao;
import uniquindio.ControlDeAcceso.Model.Usuario;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImplements implements UsuarioService {
    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Usuario save(Usuario usuario) {

        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        usuario.setPassword( passwordEncryptor.encryptPassword(usuario.getPassword()));
        return usuarioDao.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        usuarioDao.deleteById(id);
    }

    @Override
    public Optional<Usuario> findbyCorreo(String correo) {
        return usuarioDao.findByCorreo(correo);
    }

    @Override
    public boolean existsByEmail(String email) {
        return usuarioDao.existsByCorreo(email);
    }

    @Override
    public Usuario findByCorreoAndPassword(String correo, String password) throws Exception{
        Usuario usuarioCorreo = usuarioDao.findByCorreo(correo).orElseThrow(() -> new Exception("Usuario incorrecto"));
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

        if(passwordEncryptor.checkPassword(password, usuarioCorreo.getPassword())){
            return usuarioCorreo;
        }else{
            throw new Exception("Contraseña incorrecta");
        }
    }
}
