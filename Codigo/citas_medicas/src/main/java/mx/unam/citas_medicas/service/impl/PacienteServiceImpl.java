package mx.unam.citas_medicas.service.impl;

import java.util.List;
import mx.unam.citas_medicas.modelo.Paciente;
import mx.unam.citas_medicas.modelo.Usuario;
import mx.unam.citas_medicas.service.PacienteService;
import mx.unam.citas_medicas.dao.PacienteDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteServiceImpl implements PacienteService{
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory=sf;
    }
    
    @Autowired
    private PacienteDAO pacienteDao;   
    public void setPacienteDAO(PacienteDAO pacienteDAO){
        this.pacienteDao=pacienteDAO;
    }
    
    @Override
    @Transactional
    public void agregarPaciente(Paciente paciente) {
       this.pacienteDao.save(paciente);  
    }
    
    @Override
    @Transactional
    public void actualizarPaciente(Paciente p) {
        this.pacienteDao.merge(p);
    }

    @Override
    @Transactional
    public void borrarPaciente(int id) {
        this.pacienteDao.delete(getPacienteById(id));
    }

    @Override
    @Transactional
    public List<Paciente> listaPacientes() {
        return this.pacienteDao.findAll();        
    }

    @Override
    @Transactional
    public Paciente getPacienteById(int rfc) {
        return this.pacienteDao.findById(rfc);
    }

    @Override
    @Transactional
    public Paciente getPacienteByNombre(String nombre) {
        List<Paciente>list= this.pacienteDao.findByNombre(nombre);
        if(list.size()>0){
            return list.iterator().next();
        }
        return null;
    }

    @Override
    @Transactional
    public Paciente getPacienteByUsuario(Usuario u) {
        System.out.println("usuario: "+u);
        List<Paciente> lp=this.pacienteDao.findByProperty("usuario", u);
        if(lp.size()>0){
            return lp.iterator().next();
        }
        return null;
    }

  
    
}
