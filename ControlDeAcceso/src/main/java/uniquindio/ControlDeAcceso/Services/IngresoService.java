package uniquindio.ControlDeAcceso.Services;


import uniquindio.ControlDeAcceso.Model.Ingreso;

import java.util.List;

public interface IngresoService {
    public List<Ingreso> findAll();
    public Ingreso save(Ingreso ingreso);
    public Ingreso findById(Integer id);
    public void delete(Integer id);
}