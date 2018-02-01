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
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raphael de Souza Pereira <raphael.pereira@ibm.com>
 */
public class CandidatoServlet extends HttpServlet {

    private static final long serialVersionUID = 6149992041445660273L;

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

        //campos obrigatorios no cadastro
        String nome = request.getParameter("nomeCandidato");
        String email = request.getParameter("emailCandidato");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ibm_IBMEmploymentControlAPP_war_1.0-SNAPSHOTPU");

        //instacia do DAO e BEAN do candidato para fazer o cadastro
        CandidatoDAO candidadatoDAO = new CandidatoDAO(emf.createEntityManager());
        CandidatoBean candidato = new CandidatoBean();

        candidato.setNome(nome);
        candidato.setEmail(email);

        //salva no banco o novo candidato
        try {
            candidadatoDAO.salvarCandidatoComVerificacao(candidato);
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script type=\"text/javascript\">");
            out.println("setTimeout(function(){window.location.href='cadastro-candidato-response.jsp';},100)");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script type=\"text/javascript\">");
            out.println("setTimeout(function(){window.location.href='cadastro-candidato-falha-response.jsp';},100)");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
        }

        emf.close();
        emf = null;
        candidadatoDAO = null;
        candidato = null;

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
