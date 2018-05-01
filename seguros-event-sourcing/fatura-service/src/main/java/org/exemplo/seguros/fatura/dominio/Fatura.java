package org.exemplo.seguros.fatura.dominio;

import java.math.BigDecimal;

public class Fatura {

    private Long apolice;
    private BigDecimal valor;

    public Fatura(Long apolice, BigDecimal valor) {
        this.apolice = apolice;
        this.valor = valor;
    }

    public Long getApolice() {
        return apolice;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
