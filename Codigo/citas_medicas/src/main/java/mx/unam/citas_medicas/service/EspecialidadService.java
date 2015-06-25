/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.citas_medicas.service;

import java.util.List;
import mx.unam.citas_medicas.modelo.Especialidad;

/**
 *
 * @author Ariadna
 */
public interface EspecialidadService {
    public void agregarEspecialidad(Especialidad e);
    public void actualizarEspecialidad(Especialidad e);
    public void borrarEspecialidad(String e);
    public List<Especialidad> listaEspecialidads(); 
    public Especialidad getEspecialidadById(String e);
}
