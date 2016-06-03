/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import db.mapDAO;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.json.stream.JsonGenerator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author demeterko
 */
@WebServlet(name = "ServletMapsApp", urlPatterns = {"/ServletMapsApp"})
public class ServletMapsApp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            mapDAO u = new mapDAO();
            Long user_id = Long.parseLong(request.getParameter("user_id"));
            ArrayList<MapModel> maps = u.getUserMaps(user_id);
            
            JsonArrayBuilder array = Json.createArrayBuilder();
            
            StringBuilder json = new StringBuilder();
            JsonObjectBuilder builder = Json.createObjectBuilder();
            
            for(MapModel m : maps){
                builder.add("map_id", m.getMapId());
                builder.add("user_id", m.getUserId());
                builder.add("map_url", m.getUrl());
                
                JsonObject resultado = builder.build();
                
                array.add(resultado);
            }
            
            JsonObject jsonObject = Json.createObjectBuilder()
                    .add("resultado", array.build()).build();
            Json.createWriter(out).writeObject(jsonObject);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  //      processRequest(request, response);
        
        int user_id = Integer.parseInt(request.getAttribute("user_id").toString());
        
        //Aqui vai buscar todas as imagens do banco de dados associadas ao user_id fornacido
        //e vai retornar elas da forma:
     //"123345data:image/png;base64,jhdfgkluhafkvkelfyavwlekfvlkjgfal...
      //234521435data:image/png;base64,.kewafgf,bkjhdbjhgyj,vlcydhv..."
        //com o id da imagem antes do "data:image/png;base64," e separando as imagens
        //com um '\n'
    
    PrintWriter out = response.getWriter();
    
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
