package com.ibm.ibmemploymentcontrolapp.services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.ibm.ibmemploymentcontrolapp.beans.CandidatoBean;
import com.ibm.ibmemploymentcontrolapp.beans.VagaBean;
import com.ibm.ibmemploymentcontrolapp.dao.VagaDAO;
import com.ibm.ibmemploymentcontrolapp.dao.CandidatoDAO;
import com.ibm.ibmemploymentcontrolapp.dao.CandidatoVagaDAO;
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // parametro para filtro
        //String filtro = request.getParameter("filtro"); ainda n foi implementado
        String filtro = "";
        String idVagaCandidato = "11";//request.getParameter("id_vaga_candidato");
        System.out.println(idVagaCandidato);

        //Inicializa configuracoes de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ibm_IBMEmploymentControlAPP_war_1.0-SNAPSHOTPU");

        //Instancia os DAOs
        VagaDAO vagaDAO = new VagaDAO(emf.createEntityManager());
        CandidatoDAO candidatoDAO = new CandidatoDAO(emf.createEntityManager());
        CandidatoVagaDAO candidatoVagaDAO = new CandidatoVagaDAO(emf.createEntityManager());

        //Instancia os Beans
        List<VagaBean> listaVagas = new ArrayList<VagaBean>();
        List<CandidatoBean> listaCandidatos = new ArrayList<CandidatoBean>();
        ArrayList<CandidatoBean> listaCandidatosVagas = new ArrayList<CandidatoBean>();
        VagaBean vaga = new VagaBean();

        vaga = vagaDAO.buscarVagaPorIdExistente(Integer.parseInt(idVagaCandidato));

        listaVagas = vagaDAO.listarPorAreaData();
        listaCandidatos = candidatoDAO.listarCandidatosComFiltro(filtro);
        listaCandidatosVagas = candidatoVagaDAO.listarCandidatosNaVaga(vaga);

        //Seta os atributos que serão utilizados nos jsp
        request.setAttribute("listaVagas", listaVagas);
        request.setAttribute("listaCandidatos", listaCandidatos);
        request.setAttribute("listaCandidatosVagas", listaCandidatosVagas);
        
        
        ArrayList<CandidatoBean> listaCandidatosV = new ArrayList<CandidatoBean>();
        
        System.out.println("comeca aquiiiiiiiiiiiiiiiiii  ->  "+listaVagas.size());

        VagaBean vag = new VagaBean();
        
        for (int i = 0; i < listaVagas.size(); i++) {
            System.out.println("teste   -> "+listaVagas.get(i).getId());
            vag = vagaDAO.buscarVagaPorIdExistente(listaVagas.get(i).getId());
            System.out.println("renan id --------> " + listaVagas.get(i).getId());
            listaCandidatosV = candidatoVagaDAO.listarCandidatosNaVaga(vag);
            for(CandidatoBean candidat : listaCandidatosV ){
                System.out.println("Nome da PRAGA ---> "+ candidat.getNome());
            }
            System.out.println("nome final da lista para o JSP ---> "+"listaCandidatosVagas" + listaVagas.get(i).getId());
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
