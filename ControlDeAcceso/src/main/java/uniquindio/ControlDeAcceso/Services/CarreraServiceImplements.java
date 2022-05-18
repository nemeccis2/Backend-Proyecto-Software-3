package uniquindio.conexionDatos.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniquindio.conexionDatos.DAO.CarreraDao;
import uniquindio.conexionDatos.Model.Carrera;


import java.util.List;

@Service
public class CarreraServiceImplements implements CarreraService {
    @Autowired
    private CarreraDao carreraDao;

    @Override
    @Transactional(readOnly=true)
    public List<Carrera> findAll(){
        return (List<Carrera>) carreraDao.findAll();
    }
    @Override
    @Transactional(readOnly=false)
    public Carrera save(Carrera carrera){
        return carreraDao.save(carrera);
    }
    @Override
    @Transactional(readOnly=true)
    public Carrera findById(Integer id){
        return carreraDao.findById(id).orElse(null);
    }
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id){
        carreraDao.deleteById(id);
    }
}
