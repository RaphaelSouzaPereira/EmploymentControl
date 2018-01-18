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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FabioHenriqueGoulart
 */
public class ControlServlet extends HttpServlet {

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

        String categoria = request.getParameter("categoria");
        String status = request.getParameter("status");
        String dataAberturaForm = request.getParameter("data_abertura");
        String area = request.getParameter("area");
        String tecnologia = request.getParameter("tecnologia");
        String dataExpectativaEntradaForm = request.getParameter("data_exp_entrada");
        String tipo = request.getParameter("tipo");
        String banda = request.getParameter("banda");
        String detalhe = request.getParameter("detalhe");
        //campos nao obrigatorios
        String pmp = request.getParameter("pmp");
        String dataaprovacaoBoardBrForm = request.getParameter("aprovacao_board_brasil");
        String dataaprovacaoBoardGlobalForm = request.getParameter("aprovacao_board_global");
        String dataEntrouOperacaoForm = request.getParameter("entrou_operacao");
        String profSelecionado = request.getParameter("profissional_selecionado");
        String rate = request.getParameter("rate");
        String impactoFinanceiro = request.getParameter("impacto_financeiro");
        String comentarios = request.getParameter("comentarios");

        // Conversao dados de data
        Date dateAbertura = null;
        Date dateExpectativaEntrada = null;
        Date dateAprovacaoBr = null;
        Date dateAprovacaoGlobal = null;
        Date dateEntrouOperacao = null;

        dateAbertura = conversaoData(dataAberturaForm, dateAbertura);
        dateExpectativaEntrada = conversaoData(dataExpectativaEntradaForm, dateExpectativaEntrada);
        dateAprovacaoBr = conversaoData(dataaprovacaoBoardBrForm, dateAprovacaoBr);
        dateAprovacaoGlobal = conversaoData(dataaprovacaoBoardGlobalForm, dateAprovacaoGlobal);
        dateEntrouOperacao = conversaoData(dataEntrouOperacaoForm, dateEntrouOperacao);

        //Inicializa configuracoes de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ibm_IBMEmploymentControlAPP_war_1.0-SNAPSHOTPU");

        //Instancia uma VagaDAO
        VagaDAO vagaDAO = new VagaDAO(emf.createEntityManager());

        VagaBean vaga = new VagaBean();

        vaga.setCategoria(categoria);
        vaga.setStatus(status);
        vaga.setDataDeAbertura(dateAbertura);
        vaga.setArea(area);
        vaga.setTecnologia(tecnologia);
        vaga.setExpectativaDeEntrada(dateExpectativaEntrada);
        vaga.setTipo(tipo);
        vaga.setBanda(banda);
        vaga.setDetalhe(detalhe);
// nao obrigatorios:
        vaga.setPmp(Integer.parseInt(pmp));
        System.out.println("PMP:" + Integer.parseInt(pmp));
        vaga.setAprovacaoBoardBrasil(dateAprovacaoBr);
        vaga.setAprovacaoBoardGlobal(dateAprovacaoGlobal);
        vaga.setEntrouNaOperacao(dateEntrouOperacao);
        vaga.setProfissionalSelecionado(profSelecionado);
        vaga.setRate(Double.parseDouble(rate));
        vaga.setImpactoFinanceiro(Double.parseDouble(impactoFinanceiro));
        vaga.setComentario(comentarios);

        // salva no banco
        vagaDAO.salvarVaga(vaga);

        dateAbertura = null;
        dateExpectativaEntrada = null;
        dateAprovacaoBr = null;
        dateAprovacaoGlobal = null;
        dateEntrouOperacao = null;

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControlServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // fazendo a conversão da data
    //TODO: ENCAPSULAR EM UM METODO
    /**
     *
     * @param form String pega do form feito no jsp
     * @param date variavel criada para receber a data convertida
     * @param corrigida string correta onde foi tirado - para /
     * @return
     */
    public Date conversaoData(String form, Date date) {
        String corrigida = form.replace('-', '/');
        try {
            date = new SimpleDateFormat("yyyy/MM/dd").parse(corrigida);
        } catch (ParseException e) {
            // TODO : TRATAR EXCEPTION COM MODAL
            System.out.println("Erro no parse" + corrigida);

        }

        return date;
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
