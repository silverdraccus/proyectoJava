/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.citas_medicas.controller;

import java.math.BigInteger;
import java.security.SecureRandom;
import mx.unam.citas_medicas.modelo.Usuario;

/**
 *
 * @author julio
 */
public final class GeneradorNuevoUsuario {
    private SecureRandom random = new SecureRandom();
    public  Usuario getNuevoUsuario(){
        String s="user";
        s+=(int)(Math.random()*Math.pow(2, 28));
        String pass=new BigInteger(130, random).toString(32);
        Usuario u=new Usuario(s, pass);
        return u;
        
    }
    
}
