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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.math.NumberUtils;

/**
 *
 * @author RenanFontouraBoldrin
 */
public class AtualizacaoServlet extends HttpServlet {

    private static final long serialVersionUID = -4093743980063731357L;

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

        double rateConverted;

        String id = request.getParameter("id_vaga");
        Double impactoFinanceiro;
        int diasExpectativaEntrada;

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
        String profissionalSelecionado = request.getParameter("profissionalSelecionado");
        String pmp = request.getParameter("pmp");
        String dataaprovacaoBoardBrForm = request.getParameter("aprovacao_board_brasil");
        String dataaprovacaoBoardGlobalForm = request.getParameter("aprovacao_board_global");
        String dataEntrouOperacaoForm = request.getParameter("entrou_operacao");
        String rate = request.getParameter("rate");
        String comentarios = request.getParameter("comentarios");
        String motivoDaAtualizacao = request.getParameter("motivo");
        // campos de calculo de data nao mostrados no form
        int expectativaDeAbertura;

        // Declaracao das variaveis data para conversao
        Date dateAbertura = null;
        Date dateExpectativaEntrada = null;
        Date dateAprovacaoBr = null;
        Date dateAprovacaoGlobal = null;
        Date dateEntrouOperacao = null;
        Date dateAtual = new Date();

        // Variaveis datas sendo convertidas
        dateAbertura = conversaoData(dataAberturaForm, dateAbertura);
        dateExpectativaEntrada = conversaoData(dataExpectativaEntradaForm, dateExpectativaEntrada);
        System.out.println("DATA NO ATUALIZA: " + dateExpectativaEntrada);
        System.out.println("DATA NO ATUALIZA request: " + dataExpectativaEntradaForm);
        dateAprovacaoBr = conversaoData(dataaprovacaoBoardBrForm, dateAprovacaoBr);
        dateAprovacaoGlobal = conversaoData(dataaprovacaoBoardGlobalForm, dateAprovacaoGlobal);
        dateEntrouOperacao = conversaoData(dataEntrouOperacaoForm, dateEntrouOperacao);
        rate = conversaoRate(rate);
        expectativaDeAbertura = diferencaDatas(dateAbertura, dateExpectativaEntrada);

        //Inicializa configuracoes de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ibm_IBMEmploymentControlAPP_war_1.0-SNAPSHOTPU");

        //Instancia uma VagaDAO
        VagaDAO vagaDAO = new VagaDAO(emf.createEntityManager());

        VagaBean vaga = vagaDAO.buscarVagaPorIdExistente(Integer.parseInt(id), emf.createEntityManager());

        vaga.setCategoria(categoria);
        vaga.setStatus(status);
        vaga.setDataDeAbertura(dateAbertura);
        vaga.setArea(area);
        vaga.setTecnologia(tecnologia);
        vaga.setExpectativaDeEntrada(dateExpectativaEntrada);
        vaga.setTipo(tipo);
        vaga.setBanda(banda);
        vaga.setProfissionalSelecionado(profissionalSelecionado);
        vaga.setDetalhe(detalhe);
        vaga.setDataAudit(dateAtual);
        vaga.setMotivoAtualizacao(motivoDaAtualizacao);

        rateConverted = Double.parseDouble(rate);

        // nao obrigatorios:
        vaga.setPmp(NumberUtils.toInt(pmp, 0));
        vaga.setAprovacaoBoardBrasil(dateAprovacaoBr);
        vaga.setAprovacaoBoardGlobal(dateAprovacaoGlobal);
        vaga.setEntrouNaOperacao(dateEntrouOperacao);
        vaga.setRate(rateConverted);
        vaga.setComentario(comentarios);

        // campos de calculo de data
        diasExpectativaEntrada = CalculoDatasExpectativa(dataExpectativaEntradaForm, dataEntrouOperacaoForm);
        impactoFinanceiro = diasExpectativaEntrada * rateConverted * 8.8;
        vaga.setExpectativaDeAbertura(expectativaDeAbertura);
        vaga.setImpactoFinanceiro(impactoFinanceiro);

        // Atualiza no banco
        vagaDAO.atualizarVaga(vaga);
        emf.close();

        vagaDAO = null;
        vaga = null;
        emf = null;

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadastro de vagas IBM</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script type=\"text/javascript\">");
            out.println("setTimeout(function(){window.location.href='ListaServlet';},500)");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Converte as datas que vem da pagina web no form.
     * @param form String pega do form feito no jsp
     * @param date variavel criada para receber a data convertida
     * @return uma data convertidada para o padrao yyyy/MM/dd
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

    /**
     * Converte valor do rate com virgula que vem do form para rate com ponto no lugar.
     * @param rate
     * @return valor da rate sem virgula
     */
    public String conversaoRate(String rate) {
        String rateSemVirgula = rate.replace(',', '.');
        return rateSemVirgula;
    }

    /**
     * Calcula a diferença entre datas
     * @param dataAbertura
     * @param dataExpectativa
     * @return retorna a diferenca, em dias, da data Expectativa de entrada x
     * Abertura da vaga
     */
    public int diferencaDatas(Date dataAbertura, Date dataExpectativa) {
        long dif = dataExpectativa.getTime() - dataAbertura.getTime();
        return (int) TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
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

    public int CalculoDatas(String abertura, String aprovacao) {
        int resultadoDiasUteis = 0;
//        String d = abertura.toString();
        System.out.println("DENTRO DO CALCULO: " + abertura);
        LocalDate dataAbertura = LocalDate.parse(abertura);
        LocalDate hoje = LocalDate.now();

        if (aprovacao == null || aprovacao.isEmpty()) {
            resultadoDiasUteis = calculoDiasUteis(dataAbertura, hoje);
        } else {
//            String b = aprovacaotoString();
            LocalDate dataAprovacaoBrasil = LocalDate.parse(aprovacao);
            resultadoDiasUteis = calculoDiasUteis(dataAbertura, dataAprovacaoBrasil);
        }
        return resultadoDiasUteis;
    }
// Efetua regra de negocio na situacao expecifica da expectativa de entrada,
// para depois seguir com o calculo das datas... 

    public int CalculoDatasExpectativa(String expectativa, String entrouNaOperacao) {
//        String d = expectativa.toString();
        LocalDate expectativaA = LocalDate.parse(expectativa);
        LocalDate hoje = LocalDate.now();

        if (hoje.isBefore(expectativaA)) {
            return 0;
        }
        return CalculoDatas(expectativa, entrouNaOperacao);
    }

}
