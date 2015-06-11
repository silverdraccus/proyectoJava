

package mx.unam.citas_medicas.dao;

import java.util.List;
import mx.unam.citas_medicas.modelo.Estatus;

/**
 *
 * @author Ariadna
 */
public interface EstatusDAO {
    
    public void save(Estatus transientInstance);
    public void delete(Estatus persistentInstance);
    public Estatus findById( java.lang.Integer id);
    public List findByExample(Estatus instance);
    public List findByProperty(String propertyName, Object value);
    public List findByDescripcion(Object descripcion);
    public List findAll();
    public Estatus merge(Estatus detachedInstance);
    public void attachDirty(Estatus instance);
    public void attachClean(Estatus instance);
}
