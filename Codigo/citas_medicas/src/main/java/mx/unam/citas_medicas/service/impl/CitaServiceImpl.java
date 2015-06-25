package mx.unam.citas_medicas.service.impl;

import java.util.List;
import mx.unam.citas_medicas.dao.CitaDAO;
import mx.unam.citas_medicas.modelo.Cita;
import mx.unam.citas_medicas.modelo.Doctor;
import mx.unam.citas_medicas.modelo.Paciente;
import mx.unam.citas_medicas.service.CitaService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CitaServiceImpl implements CitaService{
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory=sf;
    }
    
    @Autowired
    private CitaDAO citaDAO;
    public void setCitaDAO(CitaDAO citaDAO) {
        this.citaDAO = citaDAO;
    }
    
    @Override
    @Transactional
    public void agregarCita(Cita a) {
        this.citaDAO.save(a);
    }

    @Override
    @Transactional
    public void actualizarCita(Cita a) {
        this.citaDAO.merge(a);
    }

    @Override
    @Transactional
    public void borrarCita(Integer citId) {
         this.citaDAO.delete(getCitaById(citId));
    }

    @Override
    @Transactional
    public List<Cita> listaCitas() {
        return this.citaDAO.findAll();
    }

    @Override
    @Transactional
    public Cita getCitaById(Integer id) {
        return this.citaDAO.findById(id);
    }

    @Override
    @Transactional
    public Cita getCitaByDoctor(Doctor d) {
       List<Cita> citasList =this.citaDAO.findByProperty("doctor", d);
       if (citasList.size()>0){
           return citasList.iterator().next();
       }
       return null;
    }
    
    @Override
    @Transactional
    public Cita getCitaByPaciente(Paciente p) {
       List<Cita> citasList =this.citaDAO.findByProperty("paciente", p);
       if (citasList.size()>0){
           return citasList.iterator().next();
       }
       return null;
    }

}
