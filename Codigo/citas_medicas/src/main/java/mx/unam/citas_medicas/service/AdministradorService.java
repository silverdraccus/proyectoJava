package mx.unam.citas_medicas.service;

import java.util.List;
import mx.unam.citas_medicas.modelo.Administrador;
import mx.unam.citas_medicas.modelo.Usuario;

public interface AdministradorService {
    public void agregarAdministrador(Administrador a);
    public void actualizarAdministrador(Administrador a);
    public void borrarAdministrador(String rfc);
    public List<Administrador> listaAdministradors(); 
    public Administrador getAdministradorById(String rfc);
    public Administrador getAdministradorByNombre(String nombre);
    public Administrador getAdministradorByUsuario(Usuario u);
}
