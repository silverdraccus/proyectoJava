package mx.unam.citas_medicas.modelo;
// Generated 11/06/2015 07:06:02 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Paciente generated by hbm2java
 */
public class Paciente  implements java.io.Serializable {


     private int noCuenta;
     private Usuario usuario;
     private String nombre;
     private String carrera;
     private Date fechaNacimiento;
     private Integer semestreVigente;
     private String dirCalle;
     private Integer dirNumero;
     private Integer dirColonia;
     private String telefono;
     private String correoE;
     private Set citas = new HashSet(0);

    public Paciente() {
    }

	
    public Paciente(int noCuenta) {
        this.noCuenta = noCuenta;
    }
    public Paciente(int noCuenta, Usuario usuario, String nombre, String carrera, Date fechaNacimiento, Integer semestreVigente, String dirCalle, Integer dirNumero, Integer dirColonia, String telefono, String correoE, Set citas) {
       this.noCuenta = noCuenta;
       this.usuario = usuario;
       this.nombre = nombre;
       this.carrera = carrera;
       this.fechaNacimiento = fechaNacimiento;
       this.semestreVigente = semestreVigente;
       this.dirCalle = dirCalle;
       this.dirNumero = dirNumero;
       this.dirColonia = dirColonia;
       this.telefono = telefono;
       this.correoE = correoE;
       this.citas = citas;
    }
   
    public int getNoCuenta() {
        return this.noCuenta;
    }
    
    public void setNoCuenta(int noCuenta) {
        this.noCuenta = noCuenta;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCarrera() {
        return this.carrera;
    }
    
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public Integer getSemestreVigente() {
        return this.semestreVigente;
    }
    
    public void setSemestreVigente(Integer semestreVigente) {
        this.semestreVigente = semestreVigente;
    }
    public String getDirCalle() {
        return this.dirCalle;
    }
    
    public void setDirCalle(String dirCalle) {
        this.dirCalle = dirCalle;
    }
    public Integer getDirNumero() {
        return this.dirNumero;
    }
    
    public void setDirNumero(Integer dirNumero) {
        this.dirNumero = dirNumero;
    }
    public Integer getDirColonia() {
        return this.dirColonia;
    }
    
    public void setDirColonia(Integer dirColonia) {
        this.dirColonia = dirColonia;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreoE() {
        return this.correoE;
    }
    
    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }
    public Set getCitas() {
        return this.citas;
    }
    
    public void setCitas(Set citas) {
        this.citas = citas;
    }

    @Override
    public String toString() {
        return "mx.unam.citas_medicas.modelo.Paciente_1[ noCuenta=" + noCuenta + " ]";
    }
    


}


