/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Querys;
import java.sql.Connection;
import javax.swing.JOptionPane;
//import org.hsqldb.jdbc.JDBCDriver;
import java.sql.DriverManager;


/**
 *
 * @author SNdzeko
 */
public class conexao {
    
    public static Connection con;
    
    //Carregamemento do ficheiro da Base de Dados
    public static String dbFile="C://Users//SNdzeko//Documents//NetBeansProjects//PayParque//DB//payparqueDB.accdb";
    public static String dbUrl="jdbc:ucanaccess://"+dbFile.trim()+";memory=true";
    
    public static Connection getConnection(){
        
        try{
            
            con=DriverManager.getConnection(dbUrl,"","");
            
            
        }catch(Exception ex){
            System.out.println(""+ex);
            JOptionPane.showMessageDialog(null, ex);
            
            JOptionPane.showConfirmDialog(null, "Falha na conexao");
        }
        
       
        
        return con;
    }
    
    
    
    
    
}
