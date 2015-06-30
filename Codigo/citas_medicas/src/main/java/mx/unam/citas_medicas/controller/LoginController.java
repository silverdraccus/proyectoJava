package mx.unam.citas_medicas.controller;

import mx.unam.citas_medicas.modelo.Administrador;
import mx.unam.citas_medicas.modelo.Doctor;
import mx.unam.citas_medicas.modelo.Usuario;
import mx.unam.citas_medicas.service.AdministradorService;
import mx.unam.citas_medicas.service.DoctorService;
import mx.unam.citas_medicas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("usuarioLogin")
public class LoginController {

    UsuarioService usuarioService;
    DoctorService doctorService;
    AdministradorService administradorService;
    
    @Autowired(required=true)
    public void setUsuarioService(UsuarioService us){
            this.usuarioService = us;
    }
    
    @Autowired(required=true)
    public void setDoctorService(DoctorService ds){
            this.doctorService = ds;
    }
    
    @Autowired(required=true)
    public void setAdministradorService(AdministradorService as){
            this.administradorService = as;
    }
    
    @RequestMapping(value = {"/*", "/index"})
    public String getIndex(Model model) {
        if(!model.containsAttribute("usuarioLogin")) {
            model.addAttribute("usuarioLogin", new Usuario());
        }
        return "index";
    }
     
    //Para loguear
    @RequestMapping(value= "/login.jsp",  method=RequestMethod.POST)
    public String getLogin(Usuario u,Model model){
        u=usuarioService.getUsuarioByNombreAndByPassword(u);
        System.out.println("U: "+u);
        if (u!=null){
            model.addAttribute("usuarioLogin", u);
            if (isDoctor(u, doctorService)){
                model.addAttribute("isDoctor", "true");
            }
            if(isAdministrador(u, administradorService)){
                model.addAttribute("isAdmin", "true");
            } 
            return "menuGeneral";
        }else{
            model.addAttribute("usuarioLogin", new Usuario());
            model.addAttribute("msj","Datos incorrectos");
            return "index";
        }
    }
    
    //Para salir
    @RequestMapping(value= "/logout.jsp")
    public String getLogout(Model model){
        model.addAttribute("usuarioLogin",new Usuario());
        return "index";
    }
    
    //Para la pag principal
    @RequestMapping(value= "/menu.jsp",  method=RequestMethod.GET)
    public String getMenu(@ModelAttribute("usuarioLogin") Usuario u,Model model){
        if (u!=null){
            model.addAttribute("usuarioLogin", u);
            if (isDoctor(u, doctorService)){
                model.addAttribute("isDoctor", "true");
            }
            if(isAdministrador(u, administradorService)){
                model.addAttribute("isAdmin", "true");
            } 
            return "menuGeneral";
        }else{
            model.addAttribute("usuarioLogin", new Usuario());
            model.addAttribute("msj","Datos incorrectos");
            return "index";
        }
    }
    
    public boolean isDoctor(Usuario u,DoctorService ds){
        Doctor d=ds.getDoctorByUsuario(u);
        if (d!=null){
            System.out.println("Doctor: "+d.toString());
            return true;
        }
        return false;
    }
    
    public boolean isAdministrador(Usuario u,AdministradorService as){
        Administrador a=as.getAdministradorByUsuario(u);
        if(a!=null){
            System.out.println("Admin: "+a.toString());
            return true;
        }
        return false;
    }
}
