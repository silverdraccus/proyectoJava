/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.citas_medicas.controller;

import mx.unam.citas_medicas.modelo.Paciente;
import mx.unam.citas_medicas.modelo.Usuario;
import mx.unam.citas_medicas.service.PacienteService;
import mx.unam.citas_medicas.service.UsuarioService;
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
@RequestMapping("/altaPaciente.jsp")
public class AltaPacienteController {

    PacienteService pacienteService;

    @Autowired(required = true)
    public void setPacienteService(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    UsuarioService usuarioService;

    @Autowired(required = true)
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping(method = {RequestMethod.GET})
    public String initForm(Model model) {
        model.addAttribute("pacienteForm", new Paciente());
        return "altaPaciente";
    }

    @RequestMapping(method = {RequestMethod.POST})
    public String submitAltaPaciente(
            @ModelAttribute("pacienteForm") Paciente paciente,
            BindingResult result, Model model) {
        System.out.println("paciente: " + paciente + " nombre: " + paciente.getNombre()
                + "carrera: " + paciente.getCarrera() + " nac: " + paciente.getFechaNacimiento() + "semevig: " + paciente.getSemestreVigente()
                + " dirCalle " + paciente.getDirCalle()
                + " dirNumero: " + paciente.getDirNumero()
                + " dirColonia " + paciente.getDirColonia()
                + " telefono " + paciente.getTelefono()
                + " correoE " + paciente.getCorreoE()
        );
        GeneradorNuevoUsuario g = new GeneradorNuevoUsuario();

        Usuario u = g.getNuevoUsuario();
        model.addAttribute("usuario", u);
        model.addAttribute("isDoctor", false);
        usuarioService.agregarUsuario(u);
        paciente.setUsuario(u);
        pacienteService.agregarPaciente(paciente);
        return "mostrarAlta";
    }

}
