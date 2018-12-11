/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author JORGE DELGADILLO
 */
public class conexion {
    
    public static Connection conexion(){
        
         Connection cn= null;
         
       try{
           
            Class.forName("com.mysql.jdbc.Driver");
            
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eva","root","");
       
       }catch(SQLException e1){
           
           JOptionPane.showMessageDialog(null,"Error: " + e1.getMessage());
           
       }catch(ClassNotFoundException e){ 
           
           JOptionPane.showMessageDialog(null,e.getMessage());
           
       }
       
       return cn;
       
    }
    
    Statement createStatement(){
        
        throw new UnsupportedOperationException("No soportado");
        
    }
    
}
