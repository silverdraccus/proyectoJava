package mx.unam.citas_medicas.dao;

import java.util.List;
import mx.unam.citas_medicas.modelo.Turno;

/**
 *
 * @author Ariadna
 */
public interface TurnoDAO {
    
    public void save(Turno transientInstance);
    public void delete(Turno persistentInstance);
    public Turno findById( java.lang.String id);
    public List findByExample(Turno instance);
    public List findByProperty(String propertyName, Object value);
    public List findAll();
    public Turno merge(Turno detachedInstance);
    public void attachDirty(Turno instance);
    public void attachClean(Turno instance);
}
