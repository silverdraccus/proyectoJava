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
import mx.unam.citas_medicas.service.ConsultorioService;
import mx.unam.citas_medicas.service.DoctorService;
import mx.unam.citas_medicas.service.EspecialidadService;
import mx.unam.citas_medicas.service.UsuarioService;
import mx.unam.citas_medicas.service.impl.CatalogoServiceImpl;
import mx.unam.citas_medicas.service.impl.UsuarioServiceImpl;
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
/*
@Controller
@RequestMapping(value = "/altaMedico2.jsp")
public class AltaMedicoContoller {

    EspecialidadService especialidadService;
    @Autowired(required = true)
    public void setEspecialidaService(EspecialidadService especialidadService) {
        this.especialidadService=especialidadService;
    }

    ConsultorioService consultorioService;
    @Autowired(required = true)
    public void setConsultorioService(ConsultorioService consultorioService) {
        this.consultorioService = consultorioService;
    }

    DoctorService doctorService;

    @Autowired(required = true)
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    UsuarioService usuarioService;

    @Autowired(required = true)
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping(method = {RequestMethod.GET})
    public String initForm(Model model) {
        model.addAttribute("doctorForm", new Doctor());
        initModelList(model);
        return "altaMedico";
    }

    @RequestMapping(method = {RequestMethod.POST})
    public String submitAltaPaciente(@ModelAttribute("doctorForm") Doctor doctor, BindingResult result, Model model) {
        System.out.println("doctor ingresado: " + doctor + " epscieliadad: " + doctor.getEspecialidad()
                + " turno: " + doctor.getTurno() + " consultorio: " + doctor.getConsultorio());
        GeneradorNuevoUsuario g = new GeneradorNuevoUsuario();

        Usuario u = g.getNuevoUsuario();
        model.addAttribute("usuario", u);
        model.addAttribute("isDoctor", true);
        usuarioService.agregarUsuario(u);
        doctor.setUsuario(u);
        doctor.setConsultorio(consultorioService.listaConsultorios().get(0));
        doctorService.agregarDoctor(doctor);

        return "mostrarAlta";
    }

    private void initModelList(Model model) {
        HashSet<Turno> hs = new HashSet<>();
        hs.add(new Turno("matutino"));
        hs.add(new Turno("vespertino"
                + ""));
        HashSet<Consultorio> HSC = new HashSet<>();
        HSC.add(new Consultorio(1));
        HSC.add(new Consultorio(2));
        HSC.add(new Consultorio(3));

        model.addAttribute("especialidades",
                especialidadService.listaEspecialidads());
        model.addAttribute("turnos", hs);
        model.addAttribute("consultorios", HSC);

        /*  model.addAttribute("turnos", 
         turnoService.getCatalogoTurnos());
         model.addAttribute("consultorios", 
         consultorioService.getCatalogoConsultorios());
         * \/
    }
}
*/