package mx.unam.citas_medicas.controller;

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
    //@Qualifier(value="usuarioService")
    public void setUsuarioService(UsuarioService us){
            this.usuarioService = us;
    }
    
    @RequestMapping(value = {"/*", "/index"})
    public String getIndex(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "index";
    }
    
    //Para loguear
    @RequestMapping(value= "/login", method = RequestMethod.POST)
    public String getLogin(@ModelAttribute("usuario") Usuario u){
        System.out.println("U: "+u);

            return "altaMedico";

    }
}
