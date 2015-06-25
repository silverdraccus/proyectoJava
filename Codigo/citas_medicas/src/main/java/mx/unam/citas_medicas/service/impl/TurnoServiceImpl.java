package mx.unam.citas_medicas.service.impl;

import java.util.List;
import mx.unam.citas_medicas.dao.TurnoDAO;
import mx.unam.citas_medicas.modelo.Turno;
import mx.unam.citas_medicas.service.TurnoService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TurnoServiceImpl implements TurnoService{
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory=sf;
    }
    
    @Autowired
    private TurnoDAO administradorDAO;
    public void setTurnoDAO(TurnoDAO administradorDAO) {
        this.administradorDAO = administradorDAO;
    }
    
    @Override
    @Transactional
    public void agregarTurno(Turno t) {
        this.administradorDAO.save(t);
    }

    @Override
    @Transactional
    public void actualizarTurno(Turno t) {
        this.administradorDAO.merge(t);
    }

    @Override
    @Transactional
    public void borrarTurno(String turno) {
         this.administradorDAO.delete(getTurnoById(turno));
    }

    @Override
    @Transactional
    public List<Turno> listaTurnos() {
        return this.administradorDAO.findAll();
    }

    @Override
    @Transactional
    public Turno getTurnoById(String turno) {
        return this.administradorDAO.findById(turno);
    }
}
