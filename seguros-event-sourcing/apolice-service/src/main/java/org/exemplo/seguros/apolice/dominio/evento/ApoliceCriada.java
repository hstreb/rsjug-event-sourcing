package org.exemplo.seguros.apolice.dominio.evento;

import org.exemplo.seguros.apolice.dominio.Dependente;

import java.util.Collections;
import java.util.List;

public class ApoliceCriada implements Evento {

    private Long numero;
    private String cpf;
    private String nome;
    private String bem;
    private String seguradora;
    private List<Dependente> dependentes;

    public ApoliceCriada() {
    }

    public ApoliceCriada(Long numero, String cpf, String nome, String bem, String seguradora, List<Dependente> dependentes) {
        this.numero = numero;
        this.cpf = cpf;
        this.nome = nome;
        this.bem = bem;
        this.seguradora = seguradora;
        this.dependentes = dependentes;
    }

    public Long getNumero() {
        return numero;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getBem() {
        return bem;
    }

    public String getSeguradora() {
        return seguradora;
    }

    public List<Dependente> getDependentes() {
        return Collections.unmodifiableList(dependentes);
    }

}
