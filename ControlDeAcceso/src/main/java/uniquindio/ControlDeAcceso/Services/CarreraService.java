package uniquindio.conexionDatos.Services;

import uniquindio.conexionDatos.Model.Carrera;

import java.util.List;

public interface CarreraService {
    public List<Carrera> findAll();
    public Carrera save(Carrera carrera);
    public Carrera findById(Integer id);
    public void delete(Integer id);
}
