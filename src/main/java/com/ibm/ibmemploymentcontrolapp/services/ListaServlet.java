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

        //Inicializa configuracoes de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ibm_IBMEmploymentControlAPP_war_1.0-SNAPSHOTPU");

        //Instancia os DAOs
        VagaDAO vagaDAO = new VagaDAO(emf.createEntityManager());
        CandidatoDAO candidatoDAO = new CandidatoDAO(emf.createEntityManager());

        //Instancia os Beans
        List<VagaBean> listaVagas = new ArrayList<VagaBean>();
        List<CandidatoBean> listaCandidatos = new ArrayList<CandidatoBean>();

        //Retorna as listas de vagas e candidatos
        listaVagas = vagaDAO.listarPorAreaData();
        listaCandidatos = candidatoDAO.listarCandidatosComFiltro(filtro);
        
        CandidatoVagaDAO candidatoVagaDao = new CandidatoVagaDAO(emf.createEntityManager());
        VagaBean vaga = new VagaBean();
        //vaga.setId(11);
        for(VagaBean v : listaVagas){
            if(v.getId() == 11){
                vaga = v;
                System.out.println(vaga.getId()+" TESTTTTTTTTTTEEEEEEEEEEEEEEEEE" );
                
            }
        }
        
        System.out.println("teste -----> "+vaga.getId()+" ------> "+vaga.getArea());

//        List<CandidatoBean> listacandidatos = candidatoVagaDao.listarCandidatosNaVaga(vaga);
        
        CandidatoBean cand1 = new CandidatoBean();
        cand1.setId(301);
        cand1.setEmail("teste.teste@teste");
        cand1.setNome("nora");
        
//        CandidatoBean cand2 = new CandidatoBean();
//        cand2.setId(311);
//        cand2.setEmail("raphael@raphael.com");
//        cand2.setNome("raphael");
        
        CandidatoBean cand3 = new CandidatoBean();
        cand3.setId(321);
        cand3.setEmail("cc@cc.com");
        cand3.setNome("cc");
        
        
        ArrayList<CandidatoBean> lista = new ArrayList<CandidatoBean>();
        lista.add(cand1);
//        lista.add(cand2);
        lista.add(cand3);
        
        System.out.println("teste -----> "+cand1.getId()+" ------> teste "+cand3.getId()+" <___--___" );
        
        candidatoVagaDao.salvarCandidatoNaVagaComVerificacao(vaga, lista);
        
        System.out.println("Sucesso!!");
 
////        candidatoVagaDao.salvarCandidatoNaVagaComVerificacao(vaga, lista);

//-------------------------------testefim

        //Seta os atributos que serão utilizados nos jsp
        request.setAttribute("listaVagas", listaVagas);
        request.setAttribute("listaCandidatos", listaCandidatos);

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
