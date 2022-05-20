package uniquindio.controldeacceso.services;


import uniquindio.controldeacceso.model.Carrera;

import java.util.List;

public interface CarreraService {
    public List<Carrera> findAll();
    public Carrera save(Carrera carrera);
    public Carrera findById(Integer id);
    public void delete(Integer id);
}
