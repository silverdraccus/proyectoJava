/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.citas_medicas.service;

import java.util.List;
import mx.unam.citas_medicas.modelo.Consultorio;
import mx.unam.citas_medicas.modelo.Especialidad;
import mx.unam.citas_medicas.modelo.Estatus;
import mx.unam.citas_medicas.modelo.Turno;

/**
 *
 * @author julio
 */
public interface CatalogoService {

    public List<Turno> getCatalogoTurnos();
    public List<Especialidad> getCatalogoEspecialidades();
    public List<Estatus> getCatalogoEstatus();
    public List<Consultorio> getCatalogoConsultorios();
}
