/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.edu.upa.bean;

/**
 *
 * @author Garrison
 */
public class Empleado extends Persona {

    private Integer idEmpleado;
    private Integer idPuesto;

    public Empleado() {
    }

    public Empleado(Integer idPersona, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String sexo, String telefono, Integer idEmpleado, Integer idPuesto) {
        super(idPersona,nombre,apellidoPaterno,apellidoMaterno,sexo,fechaNacimiento,telefono);
        setIdEmpleado(idEmpleado);
        setIdPuesto(idPuesto);
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public Integer getIdPuesto() {
        return idPuesto;
    }
    public void setIdPuesto(Integer idPuesto) {
        this.idPuesto = idPuesto;
    }


}
