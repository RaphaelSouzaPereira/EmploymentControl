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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
public class ListaServlet extends HttpServlet {

    private static final long serialVersionUID = -5904318238581502627L;
    int offset;
    int length;

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

        //Declaração de variáveis
        int maxEntriesPerPage = 5;
        int page = 1;

        //Pega Página da jsp
        String pageNumberValue = request.getParameter("pageNumber");

        //Seta a página como Integer
        if (pageNumberValue != null) {
            try {
                page = Integer.parseInt(pageNumberValue);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        //Define o offset e do limite de entradas por página
        int offset = maxEntriesPerPage * (page - 1);
        this.offset = offset;
        this.length = maxEntriesPerPage;

        //Inicializa configuracoes de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ibm_IBMEmploymentControlAPP_war_1.0-SNAPSHOTPU");

        //Instancia os DAOs
        VagaDAO vagaDAO = new VagaDAO(emf.createEntityManager());
        VagaAudDAO vagaAudDAO = new VagaAudDAO(emf.createEntityManager());
        CandidatoDAO candidatoDAO = new CandidatoDAO(emf.createEntityManager());
        CandidatoVagaDAO candidatoVagaDAO = new CandidatoVagaDAO(emf.createEntityManager());

        //Instancia os Beans
        List<VagaBean> listaVagas = new ArrayList<VagaBean>();
        List<VagaBean> listaDeVagasPorPagina = new ArrayList<VagaBean>();
        List<VagaAudBean> listaHistoricoVaga = new ArrayList<VagaAudBean>();
        List<CandidatoBean> listaCandidatos = new ArrayList<CandidatoBean>();
        VagaAudBean vagaAud = new VagaAudBean();
        
        //instancia variaveis envolvidas nos request's
        listaVagas = vagaDAO.listarPorAreaData(emf.createEntityManager());
        listaDeVagasPorPagina = vagaDAO.listarPorPagina(emf.createEntityManager(), this.length, this.offset);
        listaCandidatos = candidatoDAO.listarCandidatos();

        ArrayList<CandidatoBean> listaCandidatosV = new ArrayList<CandidatoBean>();
        VagaBean vag = new VagaBean();

        int resultadoDiasUteis;
        
        //Seta os atributos que serão utilizados nos jsp
        
        for (int j = 0; j < listaVagas.size(); j++) {
            // parte incluida para fazer a listagem dos candidatos vinculados a vaga...
            vag = vagaDAO.buscarVagaPorIdExistente(listaVagas.get(j).getId(), emf.createEntityManager());
            listaCandidatosV = candidatoVagaDAO.listarCandidatosNaVaga(vag, emf.createEntityManager());
            request.setAttribute("listaCandidatosVagas" + listaVagas.get(j).getId(), listaCandidatosV);

            // para a listagem do historico de cada vaga...
            listaHistoricoVaga = vagaAudDAO.listarHistoricoDaVaga(listaVagas.get(j).getId(), emf.createEntityManager());
            request.setAttribute("listaHistoricoVagas" + listaVagas.get(j).getId(), listaHistoricoVaga);

            // calculo elaborado com as datas
            resultadoDiasUteis = CalculoDatas(listaVagas.get(j).getDataDeAbertura(), listaVagas.get(j).getAprovacaoBoardBrasil());
            request.setAttribute("desdeAberturaBrasil" + listaVagas.get(j).getId(), resultadoDiasUteis); // passando os dias uteis boardBrasil
            
            resultadoDiasUteis = CalculoDatas(listaVagas.get(j).getDataDeAbertura(), listaVagas.get(j).getAprovacaoBoardGlobal());
            request.setAttribute("desdeAberturaGlobal" + listaVagas.get(j).getId(), resultadoDiasUteis); // passando os dias uteis boardGlobal
            
            resultadoDiasUteis = CalculoDatas(listaVagas.get(j).getDataDeAbertura(), listaVagas.get(j).getEntrouNaOperacao());
            request.setAttribute("desdeAberturaEntrouNaOperacao" + listaVagas.get(j).getId(), resultadoDiasUteis); // passando os dias uteis entrouNaOperacao
            
            resultadoDiasUteis = CalculoDatasExpectativa(listaVagas.get(j).getExpectativaDeEntrada(), listaVagas.get(j).getEntrouNaOperacao());
            request.setAttribute("expectativaDeEntrada" + listaVagas.get(j).getId(), resultadoDiasUteis); // passando os dias uteis expectativaentrada         
        }
        
        request.setAttribute("listaCandidatos", listaCandidatos);

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("currentPage", Integer.toString(page));
        httpSession.setAttribute("pages", getPages(listaVagas));
        httpSession.setAttribute("listaDeVagasPorPagina", listaDeVagasPorPagina);

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

    /**
     * @return List with page numbers
     */
    public List getPages(List<VagaBean> listaVagas) {
        List pageNumbers = new ArrayList();
        int pages = listaVagas.size() / this.length;

        if (listaVagas.size() % this.length != 0) {
            pages = pages + 1;
        }

        for (int i = 1; i <= pages; i++) {
            pageNumbers.add(new Integer(i));
        }

        return pageNumbers;
    }
//Calcula os dias uteis de uma data a outra(retira apenas sabados e domingos, nao leva em conta feriados)...
    public int calculoDiasUteis(LocalDate data1, LocalDate data2) {
        int diasUteis = 1;
        while (data1.isBefore(data2)) {
            data1 = data1.plusDays(1);
            if (!(data1.getDayOfWeek() == DayOfWeek.SATURDAY || data1.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                diasUteis++;
            }
        }
        return diasUteis;
    }
//Efetua regra de negocio nas datas, para entao calcular os dias uteis...
    public int CalculoDatas(Date abertura, Date aprovacao) {
        int resultadoDiasUteis = 0;
        String d = abertura.toString();
        LocalDate dataAbertura = LocalDate.parse(d);
        LocalDate hoje = LocalDate.now();

        if (aprovacao == null) {
            resultadoDiasUteis = calculoDiasUteis(dataAbertura, hoje);
        } else {
            String b = aprovacao.toString(); 
            LocalDate dataAprovacaoBrasil = LocalDate.parse(b);
            resultadoDiasUteis = calculoDiasUteis(dataAbertura, dataAprovacaoBrasil);
        }
        return resultadoDiasUteis;
    }
// Efetua regra de negocio na situacao expecifica da expectativa de entrada,
// para depois seguir com o calculo das datas... 
    public int CalculoDatasExpectativa(Date expectativa, Date entrouNaOperacao){
        String d = expectativa.toString();
        LocalDate expectativaA = LocalDate.parse(d);
        LocalDate hoje = LocalDate.now();
        
        if(hoje.isBefore(expectativaA)){
            return 0;
        }
        return CalculoDatas(expectativa, entrouNaOperacao);
    }
}
