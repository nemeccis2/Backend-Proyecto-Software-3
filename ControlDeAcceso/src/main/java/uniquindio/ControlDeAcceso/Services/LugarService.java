package uniquindio.ControlDeAcceso.Services;

import uniquindio.ControlDeAcceso.Model.Lugar;

import java.util.List;

public interface LugarService {
    public List<Lugar> findAll();
    public Lugar save(Lugar lugar);
    public Lugar findById(Integer id);
    public void delete(Integer id);
    public Lugar findByNombre(String nombre);
}
