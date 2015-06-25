package mx.unam.citas_medicas.controller;

import java.util.List;
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
public class AdminController {
    
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
    
    //Para listar los doctores
    @RequestMapping(value= "/doctores.jsp",  method=RequestMethod.GET)
    public String getDoctores(@ModelAttribute("usuarioLogin") Usuario u,Model model){
        List<Doctor> listaDoctors;
        if (u!=null){
            model.addAttribute("usuarioLogin", u);
            model.addAttribute("isAdmin", "true");
            listaDoctors = doctorService.listaDoctors();
            model.addAttribute("doctores", listaDoctors);
            return "listaDoctor";
        }else{
            model.addAttribute("usuarioLogin", new Usuario());
            model.addAttribute("msj","Datos incorrectos");
            return "index";
        }
    }
    
}
