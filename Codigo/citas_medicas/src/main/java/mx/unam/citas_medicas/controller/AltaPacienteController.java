/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.citas_medicas.controller;

import java.lang.reflect.Method;
import mx.unam.citas_medicas.modelo.Doctor;
import mx.unam.citas_medicas.modelo.Usuario;
import mx.unam.citas_medicas.service.DoctorService;
import mx.unam.citas_medicas.service.impl.DoctorServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author julio
 */
@Controller
public class AltaPacienteController {
    DoctorService ds=new DoctorServiceImpl();
    @RequestMapping(value="/medico",method = {RequestMethod.POST})
    public ModelAndView doctor(){
        return new ModelAndView("doctor","command",new Doctor());
    }
    
    @RequestMapping(value="/altaMedico.jsp",method = {RequestMethod.POST})
    public void guardaDoctor(Doctor d){
        Usuario u=new Usuario("usuario"+Math.random());
        d.setUsuario(u);
        this.ds.agregarDoctor(d);
    }
}
