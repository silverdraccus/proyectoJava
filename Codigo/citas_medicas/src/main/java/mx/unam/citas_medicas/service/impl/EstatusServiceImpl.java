/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.citas_medicas.service.impl;

import java.util.List;
import mx.unam.citas_medicas.dao.EstatusDAO;
import mx.unam.citas_medicas.modelo.Estatus;
import mx.unam.citas_medicas.service.EstatusService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ariadna
 */
@Service
public class EstatusServiceImpl implements EstatusService{
     @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory=sf;
    }
    
    @Autowired
    private EstatusDAO estatusDAO;
    public void setEstatusDAO(EstatusDAO estatusDAO) {
        this.estatusDAO = estatusDAO;
    }
    @Override
    @Transactional
    public void agregarEstatus(Estatus e) {
        this.estatusDAO.save(e);
    }

    @Override
    @Transactional
    public void actualizarEstatus(Estatus e) {
       this.estatusDAO.merge(e);
    }

    @Override
    @Transactional
    public void borrarEstatus(int id) {
        this.estatusDAO.delete(getEstatusById(id));
        
    }

    @Override
    @Transactional
    public List<Estatus> listaEstatuss() {
        return this.estatusDAO.findAll();
    }

    @Override
    @Transactional
    public Estatus getEstatusById(int id) {
        return this.estatusDAO.findById(id);
    }

    @Override
    public Estatus getEstatusByDescripcion(String desc) {
       List<Estatus>estatusList =this.estatusDAO.findByProperty("descripcion", desc);
       if (estatusList.size()>0){
           return estatusList.iterator().next();
       }
       return null;
    }
    
}
