/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.citas_medicas.controller;

import mx.unam.citas_medicas.modelo.Paciente;
import mx.unam.citas_medicas.modelo.Usuario;
import mx.unam.citas_medicas.service.PacienteService;
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
//@RequestMapping("/editarDatos.jsp")
public class EditarDatosController {

    PacienteService pacienteService;

    @Autowired(required = true)
    public void setPacienteService(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @RequestMapping("/editarDatos.jsp")
    public String getDatos(@ModelAttribute("usuario") Usuario u,
            BindingResult result, Model model){
        u.setIdUs(4);
        u.setNombre("admin1");
        u.setPassword("admin1");
        Paciente p = pacienteService.getPacienteByUsuario(u);
        model.addAttribute("pacienteForm", p);
        return "editarDatos";
    }

    @RequestMapping(value = "/guardarDatos.jsp", method = RequestMethod.POST)
    public String guardarDatos(@ModelAttribute("pacienteForm") Paciente p,
            BindingResult result, Model model) {
        pacienteService.actualizarPaciente(p);
        return "consultaCitaPaciente";
    }

}
