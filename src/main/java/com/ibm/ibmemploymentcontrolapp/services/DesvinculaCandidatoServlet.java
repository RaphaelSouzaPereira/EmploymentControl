/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ibm.ibmemploymentcontrolapp.services;

import com.ibm.ibmemploymentcontrolapp.beans.CandidatoBean;
import com.ibm.ibmemploymentcontrolapp.beans.VagaBean;
import com.ibm.ibmemploymentcontrolapp.dao.CandidatoDAO;
import com.ibm.ibmemploymentcontrolapp.dao.CandidatoVagaDAO;
import com.ibm.ibmemploymentcontrolapp.dao.VagaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author RenanFontouraBoldrin
 */
public class DesvinculaCandidatoServlet extends HttpServlet {

    private static final long serialVersionUID = -474914625620317771L;

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
        // Variaveis do jsp
        String idVaga = request.getParameter("id_vaga_candidato");
        String[] idCandidatos = request.getParameterValues("candidatosNaVagaAll");
        // Candidato 
        ArrayList<CandidatoBean> listaCandidatos = new ArrayList<CandidatoBean>();

        //Instancia DAOs
        VagaDAO vagaDAO = new VagaDAO(emf.createEntityManager());
        CandidatoDAO candidatoDAO = new CandidatoDAO(emf.createEntityManager());
        CandidatoVagaDAO candidatoVagaDAO = new CandidatoVagaDAO(emf.createEntityManager());

        //Instancia Beans
        VagaBean vaga = new VagaBean();

        vaga = vagaDAO.buscarVagaPorIdExistente(Integer.parseInt(idVaga), emf.createEntityManager());

        for (String id : idCandidatos) {
            System.out.println("Valor: " + id);
            listaCandidatos.add(candidatoDAO.buscarCandidatoPorIdExistente(Integer.parseInt(id)));
        }

        for (CandidatoBean cb : listaCandidatos) {
            System.out.println(cb.getNome());
        }

        candidatoVagaDAO.removerCandidatoDaVaga(vaga, listaCandidatos);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VinculaCandidatoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VinculaCandidatoServlet at " + request.getContextPath() + "</h1>");
//            out.println("<p>" + Arrays.toString(id) + "</p>");
//            out.println("<p>ID DA VAGA: "+ id_vaga + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
        emf.close();
        emf = null;
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
