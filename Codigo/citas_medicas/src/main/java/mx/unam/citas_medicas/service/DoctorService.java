package mx.unam.citas_medicas.service;

import java.util.List;
import mx.unam.citas_medicas.modelo.Doctor;
import mx.unam.citas_medicas.modelo.Usuario;

public interface DoctorService {
    public void agregarDoctor(Doctor d);
    public void actualizarDoctor(Doctor d);
    public void borrarDoctor(String id);
    public List<Doctor> listaDoctors(); 
    public Doctor getDoctorById(String rfc);
    public Doctor getDoctorByNombre(String nombre);
    public Doctor getDoctorByUsuario(Usuario u);
}
