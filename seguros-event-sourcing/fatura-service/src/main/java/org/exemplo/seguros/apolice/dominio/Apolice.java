package org.exemplo.seguros.apolice.dominio;

import org.exemplo.seguros.apolice.dominio.evento.DependenteAdicionado;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Apolice {
    private Long numero;
    private List<Dependente> dependentes;

    public Apolice(Long numero, List<Dependente> dependentes) {
        this.numero = numero;
        this.dependentes = dependentes;
    }

    public Long getNumero() {
        return numero;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public BigDecimal getValor() {
        return dependentes.stream()
                .filter(Objects::nonNull)
                .map(Dependente::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void adicionar(DependenteAdicionado adicionado) {
        this.dependentes = new ArrayList<Dependente>(dependentes) {{
            add(new Dependente(adicionado.getIdade()));
        }};
    }
}
