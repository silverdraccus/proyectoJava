package mx.unam.citas_medicas.service.impl;

import java.util.List;
import mx.unam.citas_medicas.dao.DoctorDAO;
import mx.unam.citas_medicas.modelo.Doctor;
import mx.unam.citas_medicas.modelo.Usuario;
import mx.unam.citas_medicas.service.DoctorService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory=sf;
    }
    
    @Autowired
    private DoctorDAO doctorDAO;
    public void setDoctorDAO(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }
    
    @Override
    @Transactional
    public void agregarDoctor(Doctor u) {
        this.doctorDAO.save(u);
    }

    @Override
    @Transactional
    public void actualizarDoctor(Doctor u) {
        this.doctorDAO.merge(u);
    }

    @Override
    @Transactional
    public void borrarDoctor(String id) {
         this.doctorDAO.delete(getDoctorById(id));
    }

    @Override
    @Transactional
    public List<Doctor> listaDoctors() {
        return this.doctorDAO.findAll();
    }

    @Override
    @Transactional
    public Doctor getDoctorById(String rfc) {
        return this.doctorDAO.findById(rfc);
    }

    @Override
    @Transactional
    public Doctor getDoctorByNombre(String nombre) {
        return  (Doctor) this.doctorDAO.findByNombre(nombre);
    }
    
    @Override
    @Transactional
    public Doctor getDoctorByUsuario(Usuario u) {
       List<Doctor> doctorsList =this.doctorDAO.findByProperty("usuario", u);
       if (doctorsList.size()>0){
           return doctorsList.iterator().next();
       }
       return null;
    }

}
