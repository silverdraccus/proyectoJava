package mx.unam.citas_medicas.dao;

import java.util.List;
import mx.unam.citas_medicas.modelo.Doctor;

/**
 *
 * @author Ariadna
 */
public interface DoctorDAO {   
    public void save(Doctor transientInstance);
    public void delete(Doctor persistentInstance);
    public Doctor findById( String rfc); 
    public List findByExample(Doctor instance);  
    public List findByProperty(String propertyName, Object value);
    public List findByNombre(Object nombre); 
    public List findAll(); 
    public Doctor merge(Doctor detachedInstance);
    public void attachDirty(Doctor instance);
    public void attachClean(Doctor instance); 
}
