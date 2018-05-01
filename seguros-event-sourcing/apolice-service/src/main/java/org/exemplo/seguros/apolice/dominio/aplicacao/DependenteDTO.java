package org.exemplo.seguros.apolice.dominio.aplicacao;

import org.exemplo.seguros.apolice.dominio.dominio.Dependente;

public class DependenteDTO {

    private String cpf;
    private String nome;
    private Integer idade;

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public Dependente toDomain() {
        return new Dependente(cpf, nome, idade);
    }
}
