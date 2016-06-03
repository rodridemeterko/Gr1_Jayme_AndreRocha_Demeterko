/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MVC.UserModel;
import db.FabricaConexoes;


public class userDAO {
    
    private final Connection connection;
    
    public userDAO() {
        this.connection = new FabricaConexoes().getConnection();    
    }
    
    public void insere(UserModel user) {
        
        String sql = "insert into usuarios" +
                " (nome,usuario,senha)" +
                " values (?,?,?)";
                
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            // Seta os valores
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getUser());
            stmt.setString(3, user.getPassword());

            // Executa
            stmt.execute();
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }
    
    public ArrayList<UserModel> consulta() {
        
        ArrayList<UserModel> usuarios; 
        usuarios = new ArrayList<UserModel>();
        
        String sql = "select * from usuarios";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            ResultSet rs = stmt.executeQuery();
              
            while(rs.next()){
                UserModel u = new UserModel();
                u.setId(rs.getLong(1));
                u.setName(rs.getString(2));
                u.setUser(rs.getString(3));
                u.setPassword(rs.getString(4));
                
                usuarios.add(u);
            }
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }
        
        return usuarios;
    }
    
    public void altera(UserModel user) {
        
        String sql = "update usuarios set nome=?, usuario=?," +
                " senha=?, where id=?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            // Seta os valores
            stmt.setString(1,user.getName());
            stmt.setString(2,user.getUser());
            stmt.setString(3, user.getPassword());
            stmt.setLong(4, user.getId());
            
            // Executa
            stmt.execute();
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }         
    }
    
    public void remove(Long id) {
        
        String sql = "delete from usuarios where id=?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            // Seta os valores
            stmt.setLong(1, id);
            
            //Executa
            stmt.execute();
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }         
    }
    public boolean newUser(UserModel user){
    	ArrayList<UserModel> usuarios; 
        usuarios = this.consulta();
        
        for (UserModel usuario : usuarios) {
            if (usuario.getUser().equals(user.getUser())) {
                return false;
            }
        }
        return true;

    }
    public boolean isUser(UserModel user){
    	ArrayList<UserModel> usuarios; 
        usuarios = this.consulta();
        
        for (UserModel usuario : usuarios) {
            if (usuario.getUser().equals(user.getUser())&& usuario.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;

    }
    
    public long getUserId(UserModel user){
        ArrayList<UserModel> usuarios;
        usuarios = this.consulta();
    
        for(UserModel usuario : usuarios){
        if(usuario.getUser().equals(user.getUser())&& usuario.getPassword().equals(user.getPassword()))
            return usuario.getId();
        }
        return -1;
    }
}
