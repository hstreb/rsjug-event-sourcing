package org.exemplo.seguros.fatura.aplicacao;

import org.exemplo.seguros.fatura.dominio.Fatura;

import java.math.BigDecimal;

public class FaturaDTO {

    private Long apolice;
    private BigDecimal valor;

    public FaturaDTO() {
    }

    public FaturaDTO(Fatura fatura) {
        this.apolice = fatura.getApolice();
        this.valor = fatura.getValor();
    }

    public FaturaDTO(Long apolice, BigDecimal valor) {
        this.apolice = apolice;
        this.valor = valor;
    }

    public Long getApolice() {
        return apolice;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Fatura toDomain() {
        return new Fatura(apolice, valor);
    }
}
