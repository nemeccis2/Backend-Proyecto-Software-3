package uniquindio.conexionDatos.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniquindio.conexionDatos.DAO.LugarDao;
import uniquindio.conexionDatos.Model.Lugar;

import java.util.List;

@Service
public class LugarServiceImplements implements LugarService {
    @Autowired
    private LugarDao lugarDao;

    @Override
    @Transactional(readOnly = true)
    public List<Lugar> findAll() {
        return (List<Lugar>) lugarDao.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Lugar save(Lugar lugar) {
        return lugarDao.save(lugar);
    }

    @Override
    @Transactional(readOnly = true)
    public Lugar findById(Integer id) {
        return lugarDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        lugarDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Lugar findByNombre(String nombre){
        return lugarDao.findByNombre(nombre);
    }
}
