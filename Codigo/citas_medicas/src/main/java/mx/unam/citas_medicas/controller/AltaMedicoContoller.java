/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.citas_medicas.controller;

import java.util.HashSet;
import mx.unam.citas_medicas.modelo.Doctor;
import mx.unam.citas_medicas.modelo.Usuario;
import mx.unam.citas_medicas.service.CatalogoService;
import mx.unam.citas_medicas.service.DoctorService;
import mx.unam.citas_medicas.service.UsuarioService;
import mx.unam.citas_medicas.service.impl.CatalogoServiceImpl;
import mx.unam.citas_medicas.service.impl.DoctorServiceImpl;
import mx.unam.citas_medicas.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        model.addAttribute("doctor", new Doctor());
        initModelList(model);
        return "altaMedico";
    }

    @RequestMapping(method = {RequestMethod.POST})
    public String submitAltaPaciente(Model model,Doctor doctor) {
        Usuario u=new Usuario("usuario"+Math.random(), String.valueOf(Math.random()), 
                new HashSet(),  new HashSet(),  new HashSet());
        System.out.println("usuario creado: "+u);
        
        UsuarioService us=new UsuarioServiceImpl();
        us.agregarUsuario(u);
        doctor.setUsuario(u);
        doctorService.agregarDoctor(doctor);
        
        return "paginaPrueba";
    }

    private void initModelList(Model model) {
        if(catalogoService==null){
            catalogoService=new CatalogoServiceImpl();
        }
        model.addAttribute("especialidades", 
                catalogoService.getCatalogoEspecialidades());
        model.addAttribute("turnos", 
                catalogoService.getCatalogoTurnos());
        model.addAttribute("consultorios", 
                catalogoService.getCatalogoConsultorios());
    }
}
