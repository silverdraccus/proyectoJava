/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.citas_medicas.controller;

import java.util.HashSet;
import mx.unam.citas_medicas.modelo.Consultorio;
import mx.unam.citas_medicas.modelo.Doctor;
import mx.unam.citas_medicas.modelo.Turno;
import mx.unam.citas_medicas.modelo.Usuario;
import mx.unam.citas_medicas.service.CatalogoService;
import mx.unam.citas_medicas.service.DoctorService;
import mx.unam.citas_medicas.service.impl.CatalogoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author julio
 */
@Controller
@RequestMapping(value = "/altaMedico.jsp")
public class AltaMedicoContoller {
    
    CatalogoService catalogoService;
    @Autowired(required = true)
    public void setCatalogoService(CatalogoService catalogoService){
        this.catalogoService=catalogoService;
    }
    
    DoctorService doctorService;
    @Autowired(required = true)
    public void setDoctorService(DoctorService doctorService){
        this.doctorService=doctorService;
    }
    
    
    @RequestMapping(method = {RequestMethod.GET})
    public String initForm(Model model) {
        model.addAttribute("doctorForm", new Doctor());        
        initModelList(model);
        return "altaMedico";
    }

    @RequestMapping(method = {RequestMethod.POST})
    public String submitAltaPaciente(@ModelAttribute("doctorForm")Doctor doctor,BindingResult result,Model model) {
        System.out.println("doctor ingresado: "+doctor+" epscieliadad: "+doctor.getEspecialidad() 
                +" turno: "+doctor.getTurno()+" consultorio: "+doctor.getConsultorio());
        GeneradorNuevoUsuario g=new GeneradorNuevoUsuario();
        
        Usuario u=g.getNuevoUsuario();
        model.addAttribute("usuario", u);
        model.addAttribute("isDoctor", true);
        model.addAttribute("isPaciente", false);
        /*Usuario u=new Usuario("usuario"+Math.random(), String.valueOf(Math.random()), 
                new HashSet(),  new HashSet(),  new HashSet());
        System.out.println("usuario creado: "+u);
        
        UsuarioService us=new UsuarioServiceImpl();
        us.agregarUsuario(u);
        doctor.setUsuario(u);
        doctorService.agregarDoctor(doctor);
        */
        return "mostrarAlta";
    }

    private void initModelList(Model model) {
        if(catalogoService==null){
            catalogoService=new CatalogoServiceImpl();
        }
        HashSet<Turno> hs=new HashSet<>();
        hs.add(new Turno("matutino"));
        hs.add(new Turno("vespertino"
                + ""));
        HashSet<Consultorio> HSC=new HashSet<>();
        HSC.add(new Consultorio(1));
        HSC.add(new Consultorio(2));
        HSC.add(new Consultorio(3));
        
        model.addAttribute("especialidades", 
                catalogoService.getCatalogoEspecialidades());       
        model.addAttribute("turnos",hs );
        model.addAttribute("consultorios", HSC);
      
        /*  model.addAttribute("turnos", 
                catalogoService.getCatalogoTurnos());
        model.addAttribute("consultorios", 
                catalogoService.getCatalogoConsultorios());
        */
    }
}
