package com.backend.laudoleite.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Microbiologica extends Laudo{
    private static final long serialVersionUID = 1L;

    private String produto;
    private String sif_idiarn_sim;
    private Date data_producao;
    private Date data_validacao;
    private Boolean individual;
    private Integer quantidade;
    private String responsavel_recebimento1;
    private Date data_recebimento;
    private String hora_recebimento;
    private String ensaio;
    private String volume;


    public Microbiologica(Integer id, String cliente, String analise, String resultado, String ordem_serviço, String responsavel_coleta, Date data_coleta, String hora_coleta, String especie, String analise_solicitada, String responsavel_recebimento, String temperatura, String produto, String sif_idiarn_sim, Date data_producao, Date data_validacao, Boolean individual, Integer quantidade, String responsavel_recebimento1, Date data_recebimento, String hora_recebimento, String ensaio, String volume) {
        super(id, cliente, analise, resultado, ordem_serviço, responsavel_coleta, data_coleta, hora_coleta, especie, analise_solicitada, responsavel_recebimento, temperatura);
        this.produto = produto;
        this.sif_idiarn_sim = sif_idiarn_sim;
        this.data_producao = data_producao;
        this.data_validacao = data_validacao;
        this.individual = individual;
        this.quantidade = quantidade;
        this.responsavel_recebimento1= responsavel_recebimento1;
        this.data_recebimento = data_recebimento;
        this.hora_recebimento = hora_recebimento;
        this.ensaio = ensaio;
        this.volume = volume;
    }
}
