package org.exemplo.seguros.apolice.dominio.dominio.evento;

public class DependenteAdicionado implements Evento {

    private Long numero;
    private String cpf;
    private String nome;
    private Integer idade;

    public DependenteAdicionado() {
    }

    public DependenteAdicionado(Long numero, String cpf, String nome, Integer idade) {
        this.numero = numero;
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
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

    public Integer getIdade() {
        return idade;
    }

}