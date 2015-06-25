
package mx.unam.citas_medicas.service.impl;

import java.util.List;
import mx.unam.citas_medicas.dao.ConsultorioDAO;
import mx.unam.citas_medicas.modelo.Consultorio;
import mx.unam.citas_medicas.service.ConsultorioService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ConsultorioServiceImpl implements ConsultorioService{

    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory=sf;
    }
    
    @Autowired
    private ConsultorioDAO consultorioDAO;
    public void setConsultorioDAO(ConsultorioDAO consultorioDAO) {
        this.consultorioDAO = consultorioDAO;
    }
    
    @Override
    @Transactional
    public void agregarConsultorio(Consultorio c) {
        this.consultorioDAO.save(c);
    }

    @Override
    @Transactional
    public void actualizarConsultorio(Consultorio c) {
        this.consultorioDAO.merge(c);
    }

    @Override
    @Transactional
    public void borrarConsultorio(Integer c) {
        this.consultorioDAO.delete(getConsultorioById(c));
    }

    @Override
    @Transactional
    public List<Consultorio> listaConsultorios() {
        return this.consultorioDAO.findAll();
    }

    @Override
    @Transactional
    public Consultorio getConsultorioById(Integer c) {
        return this.consultorioDAO.findById(c);
    }
    
}
