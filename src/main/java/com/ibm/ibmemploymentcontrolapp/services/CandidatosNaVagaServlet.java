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
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PriscilaRicardoArrud
 */
public class CandidatosNaVagaServlet extends HttpServlet {

    private static final long serialVersionUID = 2380334037078690670L;

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

        //Inicialização de configurações de persistência
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ibm_IBMEmploymentControlAPP_war_1.0-SNAPSHOTPU");

        //Valores dos parâmetros vindos da index.jsp
        String idDaVaga = request.getParameter("id_vaga_candidato");
        
        String[] idDosCandidatos;
        idDosCandidatos = request.getParameterValues("candidatosAll");
        
        String[] idDosCandidatosNaVaga;
        idDosCandidatosNaVaga = request.getParameterValues("candidatosNaVagaAll");
        
        String opcaoDeVinculo = request.getParameter("opcaoDeVinculo");

        //Instância DAOs
        VagaDAO vagaDAO = new VagaDAO(emf.createEntityManager());
        CandidatoDAO candidatoDAO = new CandidatoDAO(emf.createEntityManager());
        CandidatoVagaDAO candidatoVagaDAO = new CandidatoVagaDAO(emf.createEntityManager());

        //Instância de Beans
        VagaBean vaga = new VagaBean();
        ArrayList<CandidatoBean> listaCandidatos = new ArrayList<CandidatoBean>();

        //Busca uma vaga por Id existente
        vaga = vagaDAO.buscarVagaPorIdExistente(Integer.parseInt(idDaVaga), emf.createEntityManager());

        //Verifica qual a opção escolhida: Vincular ou Desvincular
        if (opcaoDeVinculo.equals("Vincular")) {
            //---------- VINCULAR CANDIDATO - INÍCIO ----------
            listaCandidatos = adicionarNaListaCandidatos(listaCandidatos, idDosCandidatos, candidatoDAO);
            if (listaCandidatos.isEmpty() != true) {
                candidatoVagaDAO.salvarCandidatoNaVagaComVerificacao(vaga, listaCandidatos);
            }
            //---------- VINCULAR CANDIDATO - FIM -------------            
        } else if (opcaoDeVinculo.equals("Desvincular")) {
            //---------- DESVINCULAR CANDIDATO - INÍCIO -------
            listaCandidatos = adicionarNaListaCandidatos(listaCandidatos, idDosCandidatosNaVaga, candidatoDAO);
            if (listaCandidatos.isEmpty() != true) {
                candidatoVagaDAO.removerCandidatoDaVaga(vaga, listaCandidatos);
            }
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CandidatosNaVagaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            //out.println("<a href='./'>Voltar para a Home</a>");
            out.println("<script type=\"text/javascript\">");
            out.println("setTimeout(function(){window.location.href='./';},200)");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
        }

        //Finalização de configurações de persistência
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
    
    /**
     * Método que adiciona os candidatos na vaga
     * @param listaCandidatos
     * @param idDosCandidatos
     * @param candidatoDAO
     * @return lista de candidatos na vaga
     */
    public ArrayList<CandidatoBean> adicionarNaListaCandidatos(ArrayList<CandidatoBean> listaCandidatos, String[] idDosCandidatos, CandidatoDAO candidatoDAO) {
        if (idDosCandidatos != null) {
            for (String id : idDosCandidatos) {
                listaCandidatos.add(candidatoDAO.buscarCandidatoPorIdExistente(Integer.parseInt(id)));
            }
        }
        return listaCandidatos;
    }

}
