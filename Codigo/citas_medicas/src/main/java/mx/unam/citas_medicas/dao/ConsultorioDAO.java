/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.citas_medicas.dao;

import java.util.List;
import mx.unam.citas_medicas.modelo.Consultorio;

/**
 *
 * @author Ariadna
 */
public interface ConsultorioDAO {
    public void save(Consultorio transientInstance);
    public void delete(Consultorio persistentInstance);
    public Consultorio findById( java.lang.Integer id);
    public List findByExample(Consultorio instance);
    public List findByProperty(String propertyName, Object value);
    public List findAll();
    public Consultorio merge(Consultorio detachedInstance);
    public void attachDirty(Consultorio instance);
    public void attachClean(Consultorio instance);
}
