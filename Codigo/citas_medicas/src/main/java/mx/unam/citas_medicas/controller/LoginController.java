package mx.unam.citas_medicas.controller;

import java.net.URL;
import java.net.URLClassLoader;
import mx.unam.citas_medicas.modelo.Usuario;
import mx.unam.citas_medicas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



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
        model.addAttribute("usuario", new Usuario());
        return "index";
    }
    
    //Para loguear
    @RequestMapping(value= "/login.jsp",  method=RequestMethod.POST)
    //@ModelAttribute("usuario") 
    public String getLogin(Usuario u){
        
        u=usuarioService.getUsuarioByNombreAndByPassword(u);
        System.out.println("U: "+u);
        return "altaMedico";
    }
}
