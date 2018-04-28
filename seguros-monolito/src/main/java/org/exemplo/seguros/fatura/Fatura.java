package org.exemplo.seguros.fatura;

import org.exemplo.seguros.apolice.Apolice;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Fatura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate data;
    private BigDecimal valor;
    @OneToOne
    private Apolice apolice;

    public Fatura() {
    }

    public Fatura(LocalDate data, BigDecimal valor, Apolice apolice) {
        this.data = data;
        this.valor = valor;
        this.apolice = apolice;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Apolice getApolice() {
        return apolice;
    }

    public void setApolice(Apolice apolice) {
        this.apolice = apolice;
    }
}
