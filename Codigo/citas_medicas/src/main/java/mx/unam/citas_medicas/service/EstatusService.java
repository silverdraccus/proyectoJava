package mx.unam.citas_medicas.service;

import java.util.List;
import mx.unam.citas_medicas.modelo.Estatus;

public interface EstatusService {
    public void agregarEstatus(Estatus e);
    public void actualizarEstatus(Estatus e);
    public void borrarEstatus(int id);
    public List<Estatus> listaEstatuss(); 
    public Estatus getEstatusById(int id);
    public Estatus getEstatusByDescripcion(String desc);
}
