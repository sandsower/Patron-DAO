/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.edu.upa.dao;

import java.util.ArrayList;
import mx.edu.upa.bean.Bean;
import mx.edu.upa.bean.Puesto;

/**
 *
 * @author Garrison
 */
public interface OperacionesDAO {

    ArrayList select();
    int insert(Bean bean);
    boolean delete(int id);
    boolean update(Bean bean,int id);
    Bean find(int id);

}
