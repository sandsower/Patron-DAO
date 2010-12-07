/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.edu.upa.bean;

/**
 *
 * @author Garrison
 */
public class Puesto implements Bean{

    private Integer idPuesto;
    private Double salario;
    private String descripcion;
    private String horario;
    
    public Puesto() {
    }
    public Puesto(Double salario, String descripcion, String horario) {
        setSalario(salario);
        setDescripcion(descripcion);
        setHorario(horario);
    }
    public Puesto(Integer idPuesto, Double salario, String descripcion, String horario) {
        setId(idPuesto);
        setSalario(salario);
        setDescripcion(descripcion);
        setHorario(horario);
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public Integer getId() {
        return idPuesto;
    }
    public void setId(Integer id) {
        this.idPuesto = id;
    }
    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    
    

    public boolean isEqual() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
