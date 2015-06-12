package mx.unam.citas_medicas.controller;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import mx.unam.citas_medicas.dao.UsuarioDAO;
import mx.unam.citas_medicas.modelo.Usuario;
/**
 *
 * @author Ariadna
 */
public class Test {
      public static void main(String[] args) {
          try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring.xml")) {
              UsuarioDAO usuarioDAO = context.getBean(UsuarioDAO.class);
              
              Usuario usuario = new Usuario();
              usuario.setNombre("irma09");
              usuario.setPassword("hola123");
              
              usuarioDAO.save(usuario);
              
              System.out.println("Usuario:: "+usuario);
              
              List<Usuario> list = usuarioDAO.findAll();
              
              for(Usuario u : list){
                  System.out.println("Usuario List:: "+u);
              }
              //close resources
          }    
      }
}
