package mx.unam.citas_medicas.service;

import java.util.List;
import mx.unam.citas_medicas.modelo.Cita;
import mx.unam.citas_medicas.modelo.Doctor;
import mx.unam.citas_medicas.modelo.Paciente;

public interface CitaService {
    public void agregarCita(Cita c);
    public void actualizarCita(Cita c);
    public void borrarCita(Integer idCit);
    public List<Cita> listaCitas(); 
    public Cita getCitaById(Integer idCit);
    public Cita getCitaByDoctor(Doctor d);
    public Cita getCitaByPaciente(Paciente p);
}
