/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp.services;

import com.ibm.ibmemploymentcontrolapp.beans.VagaBean;
import com.ibm.ibmemploymentcontrolapp.dao.VagaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PriscilaRicardoArrud
 */
public class VacancyReport extends HttpServlet {

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
        
        String login = (String) request.getSession().getAttribute("usuarioLogado");
        request.getSession().setAttribute("usuarioLogado", login);
        
        //Pega parametros da jsp
        String reportArea = request.getParameter("ra");
        String reportStatus = request.getParameter("rs");
        String reportTechnology = request.getParameter("rt");
        
        //Verifica se o filtro está vindo como null e seta um valor padrão
        if (reportArea == null) {
            reportArea = "";
        }

        if (reportStatus == null) {
            reportStatus = "";
        }

        if (reportTechnology == null) {
            reportTechnology = "";
        }
        
        //Inicializa configurações de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ibm_IBMEmploymentControlAPP_war_1.0-SNAPSHOTPU");
        
        //Instancia os DAOs
        VagaDAO vacancieDAO = new VagaDAO(emf.createEntityManager());
        
        //Instancia os Beans
        List<VagaBean> listOfVacancies = new ArrayList<VagaBean>();
        
        listOfVacancies = vacancieDAO.listarVagasComFiltro(emf.createEntityManager(), reportArea, reportStatus, reportTechnology);
        
        HttpSession httpSession = request.getSession();
        
        httpSession.setAttribute("listOfVacancies", listOfVacancies);
        
        RequestDispatcher view = request.getRequestDispatcher("./vacancy-report.jsp");
        view.forward(request, response);

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
