
package mx.unam.citas_medicas.service;
import java.util.List;
import mx.unam.citas_medicas.modelo.Usuario;
/**
 *
 * @author Ariadna
 */
public interface UsuarioService {
    
    public void agregarUsuario(Usuario u);
    public void actualizarUsuario(Usuario u);
    public void borrarUsuario(int id);
    public List<Usuario> listaUsuarios(); 
    public Usuario getUsuarioById(int id);
    public Usuario getUsuarioByNombre(String nombre);
}
