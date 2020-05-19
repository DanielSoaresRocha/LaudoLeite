package com.backend.laudoleite.domain.enums;

public enum TipoSituacao {
    PENDENTE(1,"Pendente"),
    EMANALISE(2,"Em Análise"),
    ANALISADA(3,"Análisada");

    private int cod;
    private String descricao;

    private TipoSituacao(int cod, String descricao) {
        this.cod=cod;
        this.descricao=descricao;
    }


    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }


    public static TipoSituacao toEnum(Integer cod) {

        if(cod==null)
            return null;


        for (TipoSituacao x : TipoSituacao.values()) {
            if(cod.equals(x.getCod()))
                return x;
        }
        throw new IllegalArgumentException("Id inválido"+cod);


    }
}
