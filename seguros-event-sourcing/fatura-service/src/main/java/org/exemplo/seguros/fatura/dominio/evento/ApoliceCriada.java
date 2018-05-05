package org.exemplo.seguros.fatura.dominio.evento;

import org.exemplo.seguros.fatura.dominio.Dependente;

import java.util.Collections;
import java.util.List;

public class ApoliceCriada implements Evento {

    private Long numero;
    private List<Dependente> dependentes;

    public ApoliceCriada() {
    }

    public ApoliceCriada(Long numero, List<Dependente> dependentes) {
        this.numero = numero;
        this.dependentes = dependentes;
    }

    public Long getNumero() {
        return numero;
    }

    public List<Dependente> getDependentes() {
        return Collections.unmodifiableList(dependentes);
    }

}
