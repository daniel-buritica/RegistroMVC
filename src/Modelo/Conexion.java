
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class Conexion {
    
     private final String base ="tienda";
     private final String user ="root";
     private final String password="1234";
     private final String url="jdbc:mysql://localhost:3306/"+base;
     private Connection con=null;
     
     
     
     public  Connection getConexion() {
         
         try{
             Class.forName("com.mysql.jdbc.Driver");
             con=(Connection)DriverManager.getConnection(this.url, this.user, this.password);
             
              
             
         }catch(SQLException e){
             System.out.println(e);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
         }
         return con;
         
         
     }
    
}
