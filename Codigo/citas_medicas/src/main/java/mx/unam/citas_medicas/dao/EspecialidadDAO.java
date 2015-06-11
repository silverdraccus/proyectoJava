package mx.unam.citas_medicas.dao;

import java.util.List;
import mx.unam.citas_medicas.modelo.Especialidad;

/**
 *
 * @author Ariadna
 */
public interface EspecialidadDAO {
    public void save(Especialidad transientInstance);
    public void delete(Especialidad persistentInstance);
    public Especialidad findById( java.lang.String id);
    public List findByExample(Especialidad instance);
    public List findByProperty(String propertyName, Object value);
    public List findAll();	
    public Especialidad merge(Especialidad detachedInstance);
    public void attachDirty(Especialidad instance);
    public void attachClean(Especialidad instance);
}
