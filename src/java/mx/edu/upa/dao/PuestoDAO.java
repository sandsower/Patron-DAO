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
        boolean result = false;
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        try{
            conexion = DAOFactory.getConexion();
            ps = conexion.prepareStatement(SQL.deletePuesto);
            ps.setInt(1, id);
            int rows_updated = ps.executeUpdate();
            return true;
            

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


        return result;
    }

    public boolean update(Puesto puesto, int id) {
        boolean result = false;
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        try{
            conexion = DAOFactory.getConexion();
            ps = conexion.prepareStatement(SQL.updatePuesto);
            ps.setString(1, puesto.getDescripcion());
            ps.setDouble(2,puesto.getSalario());
            ps.setString(3,puesto.getHorario());
            ps.setInt(4, id);
            System.out.println(ps.toString());
            ps.executeUpdate();
            return true;
                
            
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

        return result;
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
//        ArrayList arreglo = null;
                                                                                //Prueba para encontrar un puesto
//        Puesto puesto = (Puesto) pd.find(4);
                                                                                //prueba para encontrar todos los puestos
//        arreglo = pd.select();
                                                                                //prueba para insertar un puesto
//        Puesto b = new Puesto(123.1,"Nuevo Puesto","de 8 a 12");
//        int insertar = pd.insert(b);
                                                                                //Prueba para borrar un puesto
//        boolean resultado = pd.delete(11);
//        if (resultado= true)
//            System.out.println("true");
//        else
//            System.out.println("false");
                                                                                //prueba para modificar un puesto
//        Puesto b = new Puesto(222.2,"Puesto modificado","todo el dia");
//        boolean resultado = pd.update(b, 12);
//
//        if (resultado= true)
//            System.out.println("true");
//        else
//            System.out.println("false");

    }

}
