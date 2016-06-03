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

import MVC.MapModel;
import db.FabricaConexoes;


public class mapDAO {
    
    private final Connection connection;
    
    public mapDAO() {
        this.connection = new FabricaConexoes().getConnection();    
    }
    
    public void insere(MapModel map) {
        
        String sql = "insert into imagens" +
                " (id_user,url_mapa)" +
                " values (?,?)";
                
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            // Seta os valores
            stmt.setLong(1, map.getUserId());
            stmt.setString(2, map.getUrl());

            // Executa
            stmt.execute();
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }
    
    public ArrayList<MapModel> consulta() {
        
        ArrayList<MapModel> mapas; 
        mapas = new ArrayList<MapModel>();
        
        String sql = "select * from imagens";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            ResultSet rs = stmt.executeQuery();
              
            while(rs.next()){
                MapModel u = new MapModel();
                u.setMapId(rs.getLong(1));
                u.setUserId(rs.getLong(2));
                u.setUrl(rs.getString(3));
                
                mapas.add(u);
            }
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }
        
        return mapas;
    }
    
    public void altera(MapModel map) {
        
        String sql = "update imagens set id_user=?, " +
                " url_mapa=?, where id_mapa=?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            // Seta os valores
            stmt.setLong(1,map.getUserId());
            stmt.setString(2, map.getUrl());
            stmt.setLong(3, map.getMapId());
            
            // Executa
            stmt.execute();
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }         
    }
    
    public void remove(Long id) {
        
        String sql = "delete from imagens where id_mapa=?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            // Seta os valores
            stmt.setLong(1, id);
            
            //Executa
            stmt.execute();
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }         
    }
    
    public ArrayList<MapModel> getUserMaps(Long id){
        ArrayList<MapModel> mapas; 
        mapas = new ArrayList<MapModel>();
        
        String sql = "select * from imagens where id_user=?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                MapModel u = new MapModel();
                u.setMapId(rs.getLong(1));
                u.setUserId(rs.getLong(2));
                u.setUrl(rs.getString(3));
                
                mapas.add(u);
            }
            
        } catch(SQLException e) { 
            throw new RuntimeException(e);
        }
        
        return mapas;
    }
    
}
