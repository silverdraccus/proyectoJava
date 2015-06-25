/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.citas_medicas.controller;

import java.util.List;
import mx.unam.citas_medicas.modelo.Cita;
import mx.unam.citas_medicas.modelo.Estatus;
import mx.unam.citas_medicas.service.CitaService;
import mx.unam.citas_medicas.service.EstatusService;
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
@RequestMapping("/crearNuevaCita.jsp")
public class CrearNuevaCitaController {
    CitaService citaService;
    EstatusService estatusService;
    
    @Autowired(required = true)
    public void setCitaService(CitaService citaService){
        this.citaService=citaService;
    }
    
    @Autowired(required = true)
    public void setEstatusService(EstatusService estatusService){
        this.estatusService=estatusService;
    }
    
    @RequestMapping(method = {RequestMethod.GET})
    public String getNuevaCita(Model model){
        Cita cita=new Cita();
        List<Estatus> estatus=estatusService.listaEstatuss();
        Estatus activo = new Estatus(1);
        for (Estatus estatu : estatus) {
            activo = estatu;
            if(activo.getDescripcion().equalsIgnoreCase("activa")){
                break;
            }                
        }
        cita.setEstatus(activo);
        model.addAttribute("cita", cita);
        return "crearNuevaCita";
    }
    
    @RequestMapping(method = {RequestMethod.POST})
    public String guardarNuevaCita(@ModelAttribute("cita")Cita cita,
            BindingResult result){
        citaService.agregarCita(cita);
        return "consultarCitaPaciente";
    }
    
}
