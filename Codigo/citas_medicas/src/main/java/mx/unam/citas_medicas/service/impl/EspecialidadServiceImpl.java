package mx.unam.citas_medicas.service.impl;

import java.util.List;
import mx.unam.citas_medicas.dao.EspecialidadDAO;
import mx.unam.citas_medicas.modelo.Especialidad;
import mx.unam.citas_medicas.service.EspecialidadService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class EspecialidadServiceImpl implements EspecialidadService{
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory=sf;
    }
    
    @Autowired
    private EspecialidadDAO especialidadDAO;
    public void setEspecialidadDAO(EspecialidadDAO especialidadDAO) {
        this.especialidadDAO = especialidadDAO;
    }
    
    @Override
    @Transactional
    public void agregarEspecialidad(Especialidad a) {
        this.especialidadDAO.save(a);
    }

    @Override
    @Transactional
    public void actualizarEspecialidad(Especialidad a) {
        this.especialidadDAO.merge(a);
    }

    @Override
    @Transactional
    public void borrarEspecialidad(String e) {
         this.especialidadDAO.delete(getEspecialidadById(e));
    }

    @Override
    @Transactional
    public List<Especialidad> listaEspecialidads() {
        return this.especialidadDAO.findAll();
    }

    @Override
    @Transactional
    public Especialidad getEspecialidadById(String e) {
        return this.especialidadDAO.findById(e);
    }

}
