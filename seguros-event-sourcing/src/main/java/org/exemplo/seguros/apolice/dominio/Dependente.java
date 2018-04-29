package org.exemplo.seguros.apolice.dominio;

public class Dependente {

    private String cpf;
    private String nome;
    private Integer idade;

    public Dependente() {
    }

    public Dependente(String cpf, String nome, Integer idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }
}
