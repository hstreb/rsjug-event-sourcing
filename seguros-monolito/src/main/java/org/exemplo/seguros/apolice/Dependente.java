package org.exemplo.seguros.apolice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public final class Dependente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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

    public Dependente(Long id, String cpf, String nome, Integer idade) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
    }

    public Long getId() {
        return id;
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
