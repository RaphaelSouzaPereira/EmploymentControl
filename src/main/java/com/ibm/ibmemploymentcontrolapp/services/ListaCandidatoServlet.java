/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp.services;

import com.ibm.ibmemploymentcontrolapp.beans.CandidatoBean;
import com.ibm.ibmemploymentcontrolapp.dao.CandidatoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego Cansi Matte <diego.cansi at ibm.com>
 */
public class ListaCandidatoServlet extends HttpServlet {

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

        //Inicializa configuracoes de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ibm_IBMEmploymentControlAPP_war_1.0-SNAPSHOTPU");

        //Instancia uma VagaDAO
        CandidatoDAO candidatoDao = new CandidatoDAO(emf.createEntityManager());

        ArrayList<CandidatoBean> listaCandidatos = new ArrayList<CandidatoBean>();
        listaCandidatos = candidatoDao.listarCandidatos();

        request.setAttribute("listaCandidatosCompletos", listaCandidatos);
        RequestDispatcher view = request.getRequestDispatcher("./editar-candidato.jsp");
        view.forward(request, response);

        emf.close();
        candidatoDao = null;
        emf = null;

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Alterar Candidato</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script type=\"text/javascript\">");
            out.println("setTimeout(function(){window.location.href='editar-candidato.jsp';},100)");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
