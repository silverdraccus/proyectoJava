package mx.unam.citas_medicas.controller;

import mx.unam.citas_medicas.modelo.Usuario;
import mx.unam.citas_medicas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;



/**
 *
 * @author Ariadna
 */
@Controller
public class LoginController {

    UsuarioService usuarioService;
    
    @Autowired(required=true)
    public void setUsuarioService(UsuarioService us){
            this.usuarioService = us;
    }
    
    @RequestMapping(value = {"/*", "/index"})
    public String getIndex(Model model) {
        if(!model.containsAttribute("usuario")) {
            model.addAttribute("usuario", new Usuario());
        }
        return "index";
    }
    
    //Para loguear
    @RequestMapping(value= "/login.jsp",  method=RequestMethod.POST)
    public String getLogin(Usuario u,Model model){
        u=usuarioService.getUsuarioByNombreAndByPassword(u);
        System.out.println("U: "+u);
        if (u!=null){
            return "altaMedico";
        }else{
            model.addAttribute("usuario", new Usuario());
            model.addAttribute("msj","Datos incorrectos");
            return "index";
        }
        
    }
}
