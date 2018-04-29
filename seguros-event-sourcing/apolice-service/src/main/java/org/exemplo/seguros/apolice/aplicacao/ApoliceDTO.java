package org.exemplo.seguros.apolice.aplicacao;

import org.exemplo.seguros.apolice.dominio.Apolice;
import org.exemplo.seguros.apolice.dominio.Dependente;

import java.util.List;

public class ApoliceDTO {
    private Long numero;
    private String cpf;
    private String nome;
    private String bem;
    private String seguradora;
    private List<Dependente> dependentes;

    public ApoliceDTO() {
    }

    public ApoliceDTO(Apolice apolice) {
        this.numero = apolice.getNumero();
        this.cpf = apolice.getCpf();
        this.nome = apolice.getNome();
        this.bem = apolice.getBem();
        this.seguradora = apolice.getSeguradora();
        this.dependentes = apolice.getDependentes();
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
        return dependentes;
    }

    public Apolice toDomain() {
        return new Apolice(numero, cpf, nome, bem, seguradora, dependentes);
    }
}
