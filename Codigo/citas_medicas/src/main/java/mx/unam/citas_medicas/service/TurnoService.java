package mx.unam.citas_medicas.service;

import java.util.List;
import mx.unam.citas_medicas.modelo.Turno;

public interface TurnoService {
    public void agregarTurno(Turno a);
    public void actualizarTurno(Turno a);
    public void borrarTurno(String turno);
    public List<Turno> listaTurnos(); 
    public Turno getTurnoById(String turno);
}
