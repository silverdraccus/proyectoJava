/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.citas_medicas.service.impl;

import java.util.List;
import mx.unam.citas_medicas.dao.ConsultorioDAO;
import mx.unam.citas_medicas.dao.EspecialidadDAO;
import mx.unam.citas_medicas.dao.EstatusDAO;
import mx.unam.citas_medicas.dao.TurnoDAO;
import mx.unam.citas_medicas.dao.impl.EspecialidadDAOImpl;
import mx.unam.citas_medicas.modelo.Consultorio;
import mx.unam.citas_medicas.modelo.Especialidad;
import mx.unam.citas_medicas.modelo.Estatus;
import mx.unam.citas_medicas.modelo.Turno;
import mx.unam.citas_medicas.service.CatalogoService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author julio
 */
@Service
public class CatalogoServiceImpl implements CatalogoService {
    /*@Autowired
    private ConsultorioDAO consultorioDAO;   
    public void setConsultorioDAO(ConsultorioDAO cDAO){
        this.consultorioDAO=cDAO;
    }
    
    
    @Autowired
    private TurnoDAO turnoDAO;
    public void setTurnoDAO(TurnoDAO tDAO){
        this.turnoDAO=tDAO;
    }
    
    
    @Autowired
    private EstatusDAO estatusDAO;    
    public void setEspecialidadDAO(EstatusDAO eDAO){
        this.estatusDAO=eDAO;
    }
    
    @Autowired
    private EspecialidadDAO especialidadDAO;     
    public void setEspecialidadDAO(EspecialidadDAO eDAO){
        this.especialidadDAO=eDAO;
    }
    
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory=sf;
    }
    
   
    @Override
    @Transactional
    public List<Turno> getCatalogoTurnos() {
        return this.turnoDAO.findAll();
    }

    @Override
    @Transactional
    public List<Especialidad> getCatalogoEspecialidades() {
        if(especialidadDAO==null){
            especialidadDAO=new EspecialidadDAOImpl();
        }
        return this.especialidadDAO.findAll();
    }

    @Override
    @Transactional        
    public List<Estatus> getCatalogoEstatus() {
        return this.estatusDAO.findAll();
    }

    @Override
    @Transactional
    public List<Consultorio> getCatalogoConsultorios() {
        return this.consultorioDAO.findAll();
    }
    */
}
