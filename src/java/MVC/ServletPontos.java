/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.pontoDAO;

/**
 *
 * @author demeterko
 */
@WebServlet(name = "ServletPontos", urlPatterns = {"/ServletPontos"})
public class ServletPontos extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPontos() {
        super();
        // TODO Auto-generated constructor stub
    }

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
        response.getWriter().append("Served at: ").append(request.getContextPath());
        try (PrintWriter out = response.getWriter()) {
            try{
                PontoModel f = new PontoModel(Long.parseLong(request.getParameter("id_map")),Integer.parseInt(request.getParameter("x")),Integer.parseInt(request.getParameter("y")),request.getParameter("SSID"),Integer.parseInt(request.getParameter("level")));
                pontoDAO u = new pontoDAO();
                u.insere(f); 
            }
            catch(NumberFormatException e)
            {
                request.setAttribute("error", "Entrada Inv&aacute;lida: par&acirc;metro n&atilde;o &eacute; um n&uacute;mero v&aacute;lido."); 
                ServletContext app = this.getServletContext(); 
                RequestDispatcher rd = app.getRequestDispatcher("/error.jsp"); 
                rd.forward(request, response); 
            }
            }
	}

}
