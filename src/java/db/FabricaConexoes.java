/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class FabricaConexoes {
    
   
    String baseString = "jdbc:postgresql://"; // Usando Postgre
    String ip = "localhost:5432";
    String nomeDoBanco = "java";
    
    String stringDeConexao = baseString + ip + "/" + nomeDoBanco;
           
    public Connection getConnection() {
        try{
        	Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e){
        	System.err.print("ClassNotFoundexception: ");
        	System.err.println(e.getMessage());        	
        }
        
    	try {
            return DriverManager.getConnection(stringDeConexao, "postgres", "123456" );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }    
    } 
}