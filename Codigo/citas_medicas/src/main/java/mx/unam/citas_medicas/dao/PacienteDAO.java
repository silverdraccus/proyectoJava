/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.citas_medicas.dao;

import java.util.List;
import mx.unam.citas_medicas.modelo.Paciente;

/**
 *
 * @author Ariadna
 */
public interface PacienteDAO {
    
    public void save(Paciente transientInstance);
    public void delete(Paciente persistentInstance);
    public Paciente findById( java.lang.Integer id);
    public List findByExample(Paciente instance);
    public List findByProperty(String propertyName, Object value);
    public List findByNombre(Object nombre) ;
    public List findByCarrera(Object carrera);
    public List findBySemestreVigente(Object semestreVigente);
    public List findByDirCalle(Object dirCalle);
    public List findByDirNumero(Object dirNumero);
    public List findByDirColonia(Object dirColonia);
    public List findByTelefono(Object telefono);
    public List findByCorreoE(Object correoE);
    public List findAll();
    public Paciente merge(Paciente detachedInstance);
    public void attachDirty(Paciente instance);
    public void attachClean(Paciente instance);
}
