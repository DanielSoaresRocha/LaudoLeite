package com.backend.laudoleite.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FisicoQuimico extends Laudo{
    private static final long serialVersionUID = 1L;

    private String leite;
    private String origem;
    private String produtos;
    private Integer amostras_nao_coletadas;
    private Integer amostras_nao_analizadas;
    private String amostragem;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy", timezone="Brazil/East")
    private Date data_processamento;


    public FisicoQuimico(Integer id, String cliente, String analise, String resultado, String ordem_serviço, String responsavel_coleta, Date data_coleta, String hora_coleta, String especie, String analise_solicitada, String responsavel_recebimento, String temperatura, Integer situacao, String leite, String origem, String produtos, Integer amostras_nao_coletadas, Integer amostras_nao_analizadas, String amostragem, Date data_processamento) {
        super(id, cliente, analise, resultado, ordem_serviço, responsavel_coleta, data_coleta, hora_coleta, especie, analise_solicitada, responsavel_recebimento, temperatura, situacao);
        this.leite = leite;
        this.origem = origem;
        this.produtos = produtos;
        this.amostras_nao_coletadas = amostras_nao_coletadas;
        this.amostras_nao_analizadas = amostras_nao_analizadas;
        this.amostragem = amostragem;
        this.data_processamento = data_processamento;
    }
}
