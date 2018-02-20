/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.ibmemploymentcontrolapp.dao;

import com.ibm.ibmemploymentcontrolapp.model.VagaAud;
import com.ibm.ibmemploymentcontrolapp.beans.VagaAudBean;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.modelmapper.ModelMapper;

/**
 *
 * @author FabioHenriqueGoulart
 */
public class VagaAudDAO {

    private EntityManager em;
    private final ModelMapper modelMapper;

    public VagaAudDAO(EntityManager em) {
        this.em = em;
        this.modelMapper = new ModelMapper();
    }

    /**
     * Método que lista as alterações de cada vaga
     *
     * @param idVaga
     * @param emExterno
     * @return lista das vagas que tiverem alteração
     */
    public List<VagaAudBean> listarHistoricoDaVaga(int idVaga, EntityManager emExterno) {

        List<VagaAud> listaHistorico = new ArrayList<VagaAud>();
        Query query = emExterno.createNamedQuery("VagaAud.findById").setParameter("id", idVaga);
        listaHistorico = query.getResultList();
        List<VagaAudBean> listaHistoricoBean = new ArrayList<VagaAudBean>();

        for (VagaAud histVagas : (List<VagaAud>) query.getResultList()) {

            listaHistoricoBean.add(modelMapper.map(histVagas, VagaAudBean.class));
        }
        emExterno.close();
        emExterno = null;
        return listaHistoricoBean;
    }
}
