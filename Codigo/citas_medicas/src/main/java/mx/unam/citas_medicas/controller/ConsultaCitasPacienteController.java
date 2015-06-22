/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.citas_medicas.controller;

import mx.unam.citas_medicas.modelo.Paciente;
import mx.unam.citas_medicas.service.impl.UsuarioServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author julio
 */

@Controller
public class ConsultaCitasPacienteController {
    @RequestMapping(value={"/consultaCitasPaciente"})
    public String getCitas(@ModelAttribute("paciente") Paciente p){
        UsuarioServiceImpl s;
        return "consultaCitaMedico";
    }
}
