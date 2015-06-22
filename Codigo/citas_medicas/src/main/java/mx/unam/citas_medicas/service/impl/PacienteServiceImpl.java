/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.citas_medicas.service.impl;

import java.util.List;
import mx.unam.citas_medicas.modelo.Paciente;
import mx.unam.citas_medicas.modelo.Usuario;
import mx.unam.citas_medicas.service.PacienteService;
import mx.unam.citas_medicas.dao.PacienteDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author julio
 */
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
    public void actualizarPaciente(Paciente p) {
        this.pacienteDao.save(p);
    }

    @Override
    public void borrarPaciente(int id) {
        this.pacienteDao.delete(getPacienteById(id));
    }

    @Override
    public List<Paciente> listaPacientes() {
        return this.pacienteDao.findAll();        
    }

    @Override
    public Paciente getPacienteById(int rfc) {
        return this.pacienteDao.findById(rfc);
    }

    @Override
    public Paciente getPacienteByNombre(String nombre) {
        List<Paciente>list= this.pacienteDao.findByNombre(nombre);
        if(list.size()>0){
            return list.iterator().next();
        }
        return null;
    }

    @Override
    public Paciente getPacienteByUsuario(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarPaciente(Paciente paciente) {
       this.pacienteDao.save(paciente);  
    }
    
}
