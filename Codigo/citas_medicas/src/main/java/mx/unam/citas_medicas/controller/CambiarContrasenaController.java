/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.citas_medicas.controller;

import mx.unam.citas_medicas.modelo.Paciente;
import mx.unam.citas_medicas.modelo.Usuario;
import mx.unam.citas_medicas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author julio
 */
@RequestMapping("/cambiarContrasena")
public class CambiarContrasenaController {
    
    @Autowired(required=true)
    UsuarioService usuarioService;
    public void setUsuarioService(UsuarioService usuarioService){
        this.usuarioService=usuarioService;
    }
    
    @RequestMapping(method = {RequestMethod.GET})
    public String getFormContrasena(@ModelAttribute("pacienteForm")Paciente p,
    Model model){
        model.addAttribute("usuarioForm", p.getUsuario());
        return "cambiarContrasena";
    }
    
    @RequestMapping(method = {RequestMethod.POST})
    public String guardarNuevaContrasena(@ModelAttribute("usuarioForm")Usuario u,
            BindingResult result){
        usuarioService.actualizarUsuario(u);
        return "consultaCitaPaciente";
    }
            
}
