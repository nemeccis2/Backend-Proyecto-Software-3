package uniquindio.controldeacceso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uniquindio.controldeacceso.dao.IngresoDao;
import uniquindio.controldeacceso.model.Ingreso;


import java.util.List;

@Service
public class IngresoServiceImplements implements IngresoService{
    @Autowired
    private IngresoDao ingresoDao;

    @Override
    @Transactional(readOnly=true)
    public List<Ingreso> findAll(){
        return (List<Ingreso>) ingresoDao.findAll();
    }
    @Override
    @Transactional(readOnly=false)
    public Ingreso save(Ingreso ingreso){
        return ingresoDao.save(ingreso);
    }
    @Override
    @Transactional(readOnly=true)
    public Ingreso findById(Integer id){
        return ingresoDao.findById(id).orElse(null);
    }
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id){
        ingresoDao.deleteById(id);
    }
}
