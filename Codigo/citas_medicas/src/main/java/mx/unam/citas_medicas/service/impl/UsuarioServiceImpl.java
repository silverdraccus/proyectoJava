package mx.unam.citas_medicas.service.impl;

import java.util.List;
import mx.unam.citas_medicas.dao.UsuarioDAO;
import mx.unam.citas_medicas.modelo.Usuario;
import mx.unam.citas_medicas.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ariadna
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    private UsuarioDAO usuarioDAO;
    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    @Override
    @Transactional
    public void agregarUsuario(Usuario u) {
        this.usuarioDAO.agregarUsuario(u);
    }

    @Override
    @Transactional
    public void actualizarUsuario(Usuario u) {
        this.usuarioDAO.actualizarUsuario(u);
    }

    @Override
    @Transactional
    public void borrarUsuario(int id) {
         this.usuarioDAO.borrarUsuario(id);
    }

    @Override
    @Transactional
    public List<Usuario> listaUsuarios() {
        return this.usuarioDAO.listaUsuarios();
    }

    @Override
    @Transactional
    public Usuario getUsuarioById(int id) {
        return this.usuarioDAO.getUsuarioById(id);
    }

    @Override
    @Transactional
    public Usuario getUsuarioByNombre(String nombre) {
        return  this.usuarioDAO.getUsuarioByNombre(nombre);
    }
    
}
