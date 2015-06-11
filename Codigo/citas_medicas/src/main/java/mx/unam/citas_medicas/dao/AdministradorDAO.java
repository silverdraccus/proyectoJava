package mx.unam.citas_medicas.dao;

import java.util.List;
import mx.unam.citas_medicas.modelo.Administrador;

/**
 *
 * @author Ariadna
 */
public interface AdministradorDAO {

    public void save(Administrador transientInstance);
    public void delete(Administrador persistentInstance);
    public Administrador findById( java.lang.String id) ;
    public List findByExample(Administrador instance);   
    public List findByProperty(String propertyName, Object value);
    public List findByNombre(Object nombre);
    public List findAll();
    public Administrador merge(Administrador detachedInstance);
    public void attachDirty(Administrador instance);
    public void attachClean(Administrador instance);
}
