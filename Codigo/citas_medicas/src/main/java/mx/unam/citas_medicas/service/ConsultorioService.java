package mx.unam.citas_medicas.service;

import java.util.List;
import mx.unam.citas_medicas.modelo.Consultorio;

public interface ConsultorioService {
    public void agregarConsultorio(Consultorio c);
    public void actualizarConsultorio(Consultorio c);
    public void borrarConsultorio(Integer consultorio);
    public List<Consultorio> listaConsultorios(); 
    public Consultorio getConsultorioById(Integer c);
}
