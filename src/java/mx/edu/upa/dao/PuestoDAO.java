/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.edu.upa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mx.edu.upa.bean.Bean;
import mx.edu.upa.bean.Puesto;

/**
 *
 * @author Garrison
 */
public class  PuestoDAO implements OperacionesDAO {

    public int insert(Puesto puesto) {
        int resultado = 0;
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs =null;

        try{
            conexion = DAOFactory.getConexion();
            ps = conexion.prepareStatement(SQL.insertPuesto); 
            ps.setString(1, puesto.getDescripcion());
            ps.setDouble(2, puesto.getSalario() );
            ps.setString(3, puesto.getHorario());
            System.out.println(ps.toString());
            resultado = ps.executeUpdate();

        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
        try{

            if(rs!=null){
                rs.close();
                rs =null;
            }
            if(ps!=null){
                ps.close();
                ps =null;
            }
            if(conexion!=null){
                DAOFactory.closeConexion(conexion);
                conexion = null;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
       }

        
        return resultado;
    }

    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean update(Bean bean) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList select(){
       Puesto puesto = null;
       Connection conexion = null;
       PreparedStatement ps = null;
       ResultSet rs =null;
       ArrayList Puestos = new ArrayList();

       try{
            conexion = DAOFactory.getConexion();
            ps = conexion.prepareStatement(SQL.selectPuesto);
            rs = ps.executeQuery();
            puesto = new Puesto();
            while(rs.next())
                Puestos.add(new Puesto(rs.getInt("idPuesto"),rs.getDouble("salario"),rs.getString("descripcion"),rs.getString("horario")));
  
       }
       catch(Exception ex){
            ex.printStackTrace();
        }
       finally{
        try{

            if(rs!=null){
                rs.close();
                rs =null;
            }
            if(ps!=null){
                ps.close();
                ps =null;
            }
            if(conexion!=null){
                DAOFactory.closeConexion(conexion);
                conexion = null;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
       }
       return Puestos;
    }

    public Bean find(int id) {
       Puesto puesto = null;
       Connection conexion = null;
       PreparedStatement ps = null;
       ResultSet rs =null;

        try{
            conexion = DAOFactory.getConexion();
            ps = conexion.prepareStatement(SQL.findPuesto);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            puesto = new Puesto();

            while(rs.next())
                puesto = new Puesto(rs.getInt("idPuesto"),rs.getDouble("salario"),rs.getString("descripcion"),rs.getString("horario"));

        }catch(Exception ex){
            ex.printStackTrace();
        }
       finally{
        try{
            
            if(rs!=null){
                rs.close();
                rs =null;
            }
            if(ps!=null){
                ps.close();
                ps =null;
            }
            if(conexion!=null){
                DAOFactory.closeConexion(conexion);
                conexion = null;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
       }

       return puesto;
    }

    public static void main(String[] args) {
        PuestoDAO pd = new PuestoDAO();
        ArrayList arreglo = null;
        Puesto puesto = (Puesto) pd.find(4);
        arreglo = pd.select();
        Puesto b = new Puesto(123.1,"Nuevo Puesto","de 8 a 12");
        int insertar = pd.insert(b);

//        System.out.println("id " + puesto.getId() );
//        System.out.println(" des "+ puesto.getDescripcion());
//        System.out.println(" salario "+ puesto.getSalario());
//        System.out.println(" horario "+ puesto.getHorario());

    }

}
