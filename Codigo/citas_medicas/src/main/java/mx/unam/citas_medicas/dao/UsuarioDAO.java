package mx.unam.citas_medicas.dao;
import java.util.List;
import mx.unam.citas_medicas.modelo.Usuario;

/**
 *
 * @author Ariadna
 */
public interface UsuarioDAO {

    public void save(Usuario u);
    public void delete(Usuario u);
    public Usuario findById(Integer id);
    public List findByExample(Usuario u);
    public List findByProperty(String propertyName, Object value) ;
    public List findByNombre(Object nombre);
    public List findByPassword(Object password);
    public List findAll();
    public Usuario merge(Usuario u);
    public void attachDirty(Usuario u);
    public void attachClean(Usuario u);
}
