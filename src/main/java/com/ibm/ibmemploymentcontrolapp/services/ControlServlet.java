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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        String dtAberturaTexto = request.getParameter("data_abertura");
        String area = request.getParameter("area");
        String tecnologia = request.getParameter("tecnologia");
        String dtExpEntradaTexto = request.getParameter("dt_exp_entrada");
        String tipo = request.getParameter("tipo");
        String banda = request.getParameter("banda");
        String detalhe = request.getParameter("detalhe");
        //campos nao obrigatorios
        String pmp = request.getParameter("pmp");
        String aprovacaoBoardBr = request.getParameter("aprovacao_board_brasil");
        String aprovacaoBoardGlobal = request.getParameter("aprovacao_board_global");
        String entrouOperacao = request.getParameter("entrou_operacao");
        String profSelecionado = request.getParameter("profissional_selecionado");
        String rate = request.getParameter("rate");
        String impactoFinanceiro = request.getParameter("impacto_financeiro");
        String comentarios = request.getParameter("comentarios");

        // dados de data
        Calendar dtAbertura = null;
        Calendar dtExpEntrada = null;
        Date dateAbertura;
        Date dateExpEnt;

        // fazendo a conversão da data
//        try {
//            dateExpEnt
//                    = new SimpleDateFormat("dd/MM/yyyy")
//                            .parse(dtExpEntradaTexto);
//            dtExpEntrada = Calendar.getInstance();
//            dtExpEntrada.setTime(dateExpEnt);
//        } catch (ParseException e) {
//           // TODO : TRATAR EXCEPTION COM MODAL
////            out.println("Erro de conversão da data");
//            return; //para a execução do método
//        }
//        
//      try {
//            dateAbertura
//                    = new SimpleDateFormat("dd/MM/yyyy")
//                            .parse(dtAberturaTexto);
//            dtExpEntrada = Calendar.getInstance();
//            dtExpEntrada.setTime(dateAbertura);
//        } catch (ParseException e) {
//           // TODO : TRATAR EXCEPTION COM MODAL
////            out.println("Erro de conversão da data");
//            return; //para a execução do método
//        }

        //Inicializa configuracoes de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ibm_IBMEmploymentControlAPP_war_1.0-SNAPSHOTPU");

        //Instancia uma VagaDAO
        VagaDAO vagaDAO = new VagaDAO(emf.createEntityManager());

        VagaBean vaga = new VagaBean();
        
//        vaga.setArea();
        vaga.setCategoria(categoria);
        vaga.setStatus(status);
//        vaga.setDataDeAbertura(dateAbertura);
//        vaga.setExpectativaDeEntrada(dateExpEnt);
        vaga.setTipo(tipo);
        vaga.setBanda(banda);
        vaga.setDetalhe(detalhe);
        
        vagaDAO.salvarVaga(vaga);

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
