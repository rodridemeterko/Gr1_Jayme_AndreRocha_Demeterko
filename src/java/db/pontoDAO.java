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

import MVC.PontoModel;

public class pontoDAO {
    private final Connection connection;
    
    public pontoDAO() {
        this.connection = new FabricaConexoes().getConnection();    
    }
    
    public void insere(PontoModel ponto) {
        
        String sql = "insert into pontos" +
                " (id_map,posx,posy,SSID,level)" +
                " values (?,?,?,?,?)";
                
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            // Seta os valores
            stmt.setLong(1, ponto.getMapId());
            stmt.setFloat(2, ponto.getX());
            stmt.setFloat(3, ponto.getY());
            stmt.setString(4, ponto.getSSID());
            stmt.setInt(5, ponto.getLevel());
            // Executa
            stmt.execute();
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }
    
    public ArrayList<PontoModel> consulta() {
        
        ArrayList<PontoModel> pontos; 
        pontos = new ArrayList<PontoModel>();
        
        String sql = "select * from pontos";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            ResultSet rs = stmt.executeQuery();
              
            while(rs.next()){
                PontoModel u = new PontoModel();
                u.setPontoId(rs.getLong(1));
                u.setMapId(rs.getLong(2));
                u.setX(rs.getInt(3));
                u.setY(rs.getInt(4));
                u.setSSID(rs.getString(5));
                u.setLevel(rs.getInt(6));
                
                pontos.add(u);
            }
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }
        
        return pontos;
    }
    
    public void altera(PontoModel ponto) {
        
        String sql = "update pontos set id_map=?, posx=?," +
                " posy=?, SSID=?, level=?, where id_ponto=?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            // Seta os valores
            stmt.setLong(1,ponto.getMapId());
            stmt.setFloat(2,ponto.getX());
            stmt.setFloat(3, ponto.getY());
            stmt.setString(4, ponto.getSSID());
            stmt.setInt(5, ponto.getLevel());
            stmt.setLong(6, ponto.getPontoId());
            
            // Executa
            stmt.execute();
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }         
    }
    
    public void remove(Long id) {
        
        String sql = "delete from pontos where id_ponto=?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            // Seta os valores
            stmt.setLong(1, id);
            
            //Executa
            stmt.execute();
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }         
    }
    

}
