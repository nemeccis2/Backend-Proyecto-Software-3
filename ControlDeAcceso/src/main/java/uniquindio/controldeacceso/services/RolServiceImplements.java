package uniquindio.controldeacceso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniquindio.controldeacceso.dao.RolDao;
import uniquindio.controldeacceso.model.Rol;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImplements implements RolService{
    @Autowired
    private RolDao rolDao;

    @Override
    @Transactional(readOnly=true)
    public List<Rol> findAll(){
        return (List<Rol>) rolDao.findAll();
    }
    @Override
    @Transactional(readOnly=false)
    public Rol save(Rol rol){
        return rolDao.save(rol);
    }
    @Override
    @Transactional(readOnly=true)
    public Rol findById(Integer id){
        return rolDao.findById(id).orElse(null);
    }
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id){
        rolDao.deleteById(id);
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<Rol> findByNombreRol(String nombreRol) {
        return rolDao.findByNombreRol(nombreRol);
    }
}
