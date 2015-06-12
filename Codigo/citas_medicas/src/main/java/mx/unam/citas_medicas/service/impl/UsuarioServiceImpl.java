package mx.unam.citas_medicas.service.impl;

import java.util.List;
import mx.unam.citas_medicas.dao.UsuarioDAO;
import mx.unam.citas_medicas.modelo.Usuario;
import mx.unam.citas_medicas.service.UsuarioService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ariadna
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private SessionFactory sessionFactory;
    private UsuarioDAO usuarioDAO;
    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    @Override
    @Transactional
    public void agregarUsuario(Usuario u) {
        this.usuarioDAO.save(u);
    }

    @Override
    @Transactional
    public void actualizarUsuario(Usuario u) {
        this.usuarioDAO.merge(u);
    }

    @Override
    @Transactional
    public void borrarUsuario(int id) {
         this.usuarioDAO.delete(getUsuarioById(id));
    }

    @Override
    @Transactional
    public List<Usuario> listaUsuarios() {
        return this.usuarioDAO.findAll();
    }

    @Override
    @Transactional
    public Usuario getUsuarioById(int id) {
        return this.usuarioDAO.findById(id);
    }

    @Override
    @Transactional
    public Usuario getUsuarioByNombre(String nombre) {
        return  (Usuario) this.usuarioDAO.findByNombre(nombre);
    }
    
}
