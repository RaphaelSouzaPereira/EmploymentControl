package com.ibm.ibmemploymentcontrolapp.services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.ibm.ibmemploymentcontrolapp.beans.CandidatoBean;
import com.ibm.ibmemploymentcontrolapp.beans.VagaAudBean;
import com.ibm.ibmemploymentcontrolapp.beans.VagaBean;
import com.ibm.ibmemploymentcontrolapp.dao.VagaDAO;
import com.ibm.ibmemploymentcontrolapp.dao.CandidatoDAO;
import com.ibm.ibmemploymentcontrolapp.dao.CandidatoVagaDAO;
import com.ibm.ibmemploymentcontrolapp.dao.VagaAudDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PriscilaRicardoArrud
 */
public class ListaServlet extends HttpServlet {

    private static final long serialVersionUID = -5904318238581502627L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // F U N C I O N A N D O
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Inicializa configuracoes de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ibm_IBMEmploymentControlAPP_war_1.0-SNAPSHOTPU");

        //Instancia os DAOs
        VagaDAO vagaDAO = new VagaDAO(emf.createEntityManager());
        VagaAudDAO vagaAudDAO = new VagaAudDAO(emf.createEntityManager());
        CandidatoDAO candidatoDAO = new CandidatoDAO(emf.createEntityManager());
        CandidatoVagaDAO candidatoVagaDAO = new CandidatoVagaDAO(emf.createEntityManager());

        //Instancia os Beans
        List<VagaBean> listaVagas = new ArrayList<VagaBean>();
        List<VagaAudBean> listHistoricoVaga = new ArrayList<VagaAudBean>();
        List<CandidatoBean> listaCandidatos = new ArrayList<CandidatoBean>();

        listaVagas = vagaDAO.listarPorAreaData(emf.createEntityManager());
        listHistoricoVaga = vagaAudDAO.listarHistVagas();
        listaCandidatos = candidatoDAO.listarCandidatos();

        //Seta os atributos que serão utilizados nos jsp
        request.setAttribute("listaVagas", listaVagas);
        request.setAttribute("listaHistoricoVagas", listHistoricoVaga);
        request.setAttribute("listaCandidatos", listaCandidatos);

        ArrayList<CandidatoBean> listaCandidatosV = new ArrayList<CandidatoBean>();
        VagaBean vag = new VagaBean();
        
        System.out.println(listHistoricoVaga.isEmpty()+" TESTE MALUCO!!!");

        // parte incluida para fazer a listagem dos candidatos vinculados a vaga...
        for (int i = 0; i < listaVagas.size(); i++) {
            vag = vagaDAO.buscarVagaPorIdExistente(listaVagas.get(i).getId(), emf.createEntityManager());
            listaCandidatosV = candidatoVagaDAO.listarCandidatosNaVaga(vag, emf.createEntityManager());
            request.setAttribute("listaCandidatosVagas" + listaVagas.get(i).getId(), listaCandidatosV);
        }

        RequestDispatcher view = request.getRequestDispatcher("./index.jsp");
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
