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
import com.ibm.ibmemploymentcontrolapp.dao.VagaCandidatoDAO;
import com.ibm.ibmemploymentcontrolapp.model.Vaga;
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

        //Inicializa configuracoes de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ibm_IBMEmploymentControlAPP_war_1.0-SNAPSHOTPU");

        //Instancia os DAOs
        VagaDAO vagaDAO = new VagaDAO(emf.createEntityManager());
        CandidatoDAO candidatoDAO = new CandidatoDAO(emf.createEntityManager());
        VagaCandidatoDAO vagacandidatoDAO = new VagaCandidatoDAO(emf.createEntityManager());

        
        
        
        
        /*Implentacao Inicial Salvar candidato na vaga
        VagaBean vaga1 = new VagaBean();
        vaga1 = vagaDAO.buscarVagaPorIdExistente(1);

        List<CandidatoBean> listDeCandidatos = new ArrayList<CandidatoBean>();
        listDeCandidatos.add(candidatoDAO.buscarCandidatoPorIdExistente(331));

        vagacandidatoDAO.salvarCandidatoNaVaga(listDeCandidatos, vaga1);
        -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- */
        //Instancia os Beans
        List<VagaBean> listaVagas = new ArrayList<VagaBean>();
        List<CandidatoBean> listaCandidatos = new ArrayList<CandidatoBean>();
        
        validaSalvaCandidado(vagaDAO, vagacandidatoDAO, listaCandidatos, 11);

        //Retorna as listas de vagas e candidatos
        listaVagas = vagaDAO.listarPorAreaData();
        listaCandidatos = candidatoDAO.listarCandidatosComFiltro(filtro);

        //Seta os atributos que serão utilizados nos jsp
        request.setAttribute("listaVagas", listaVagas);
        request.setAttribute("listaCandidatos", listaCandidatos);

        RequestDispatcher view = request.getRequestDispatcher("./index.jsp");
        view.forward(request, response);

        emf.close();
        emf = null;
    }

    public void validaSalvaCandidado(VagaDAO vagaDAO, VagaCandidatoDAO vagaCandidatoDAO,
            List<CandidatoBean> listaCandidatoBean, Integer id_vaga) {
        boolean teste;
        for (CandidatoBean cand : listaCandidatoBean) {
            teste = false;
            for (Vaga vaga : cand.getVagaCollection()) {
                if (vaga.getId().equals(id_vaga)) {
                    teste = true;
                }
            }
            if (teste == false) {
                vagaCandidatoDAO.salvarCandidatoNaVaga(cand, vagaDAO.buscarVagaPorIdExistente(1));
            }
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
