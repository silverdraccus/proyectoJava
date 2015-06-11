
package mx.unam.citas_medicas.dao;

import java.util.List;
import mx.unam.citas_medicas.modelo.Cita;

/**
 *
 * @author Ariadna
 */
public interface CitaDAO {
    public void save(Cita transientInstance);
    public void delete(Cita persistentInstance);   
    public Cita findById( java.lang.Integer id);
    public List findByExample(Cita instance);      
    public List findByProperty(String propertyName, Object value);
    public List findAll();
    public Cita merge(Cita detachedInstance);
    public void attachDirty(Cita instance);
    public void attachClean(Cita instance);
}
