package org.exemplo.seguros.fatura.dominio.evento;

import java.math.BigDecimal;

public class FaturaCriada {

    private Long apolice;
    private BigDecimal valor;

    public FaturaCriada(Long apolice, BigDecimal valor) {
        this.apolice = apolice;
        this.valor = valor;
    }

    public FaturaCriada() {
    }

    public Long getApolice() {
        return apolice;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
