package mx.unam.citas_medicas.service.impl;

import java.util.List;
import mx.unam.citas_medicas.dao.AdministradorDAO;
import mx.unam.citas_medicas.modelo.Administrador;
import mx.unam.citas_medicas.modelo.Usuario;
import mx.unam.citas_medicas.service.AdministradorService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdministradorServiceImpl implements AdministradorService{
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory=sf;
    }
    
    @Autowired
    private AdministradorDAO administradorDAO;
    public void setAdministradorDAO(AdministradorDAO administradorDAO) {
        this.administradorDAO = administradorDAO;
    }
    
    @Override
    @Transactional
    public void agregarAdministrador(Administrador a) {
        this.administradorDAO.save(a);
    }

    @Override
    @Transactional
    public void actualizarAdministrador(Administrador a) {
        this.administradorDAO.merge(a);
    }

    @Override
    @Transactional
    public void borrarAdministrador(String rfc) {
         this.administradorDAO.delete(getAdministradorById(rfc));
    }

    @Override
    @Transactional
    public List<Administrador> listaAdministradors() {
        return this.administradorDAO.findAll();
    }

    @Override
    @Transactional
    public Administrador getAdministradorById(String rfc) {
        return this.administradorDAO.findById(rfc);
    }

    @Override
    @Transactional
    public Administrador getAdministradorByNombre(String nombre) {
        return  (Administrador) this.administradorDAO.findByNombre(nombre);
    }
    
    @Override
    @Transactional
    public Administrador getAdministradorByUsuario(Usuario u) {

       List<Administrador> administradorsList =this.administradorDAO.findByProperty("usuario", u);
       if (administradorsList.size()>0){
           return administradorsList.iterator().next();
       }
       return null;
    }

}
