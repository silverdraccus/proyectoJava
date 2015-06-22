package mx.unam.citas_medicas.service;

import java.util.List;
import mx.unam.citas_medicas.modelo.Paciente;
import mx.unam.citas_medicas.modelo.Usuario;


/**
 *
 * @author julio
 */
public interface PacienteService {     
//    public void agregarPaciente(Paciente d);
    public void actualizarPaciente(Paciente p);
    public void borrarPaciente(int id);
    public List<Paciente> listaPacientes(); 
    public Paciente getPacienteById(int rfc);
    public Paciente getPacienteByNombre(String nombre);
    public Paciente getPacienteByUsuario(Usuario u);
    public void agregarPaciente(Paciente doctor);
}
