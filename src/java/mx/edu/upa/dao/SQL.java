/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.edu.upa.dao;

/**
 *
 * @author Garrison
 */
public class SQL {

    public static String selectPuesto="SELECT * from puesto";
    public static String findPuesto="SELECT idPuesto,descripcion,salario,horario FROM puesto WHERE idPuesto=?";
    public static String updatePuesto="UPDATE puesto idPuesto= ?, descripcion=? salario=?, horario=? WHERE idPuesto=?";
    public static String insertPuesto="INSERT INTO puesto(descripcion,salario,horario) VALUES(?,?,?)";
    public static String deletePuesto="DELETE FROM puesto WHERE idPuesto=?";

}
