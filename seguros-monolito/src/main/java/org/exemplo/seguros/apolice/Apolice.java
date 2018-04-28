package org.exemplo.seguros.apolice;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Apolice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cpf;
    private String nome;
    private String bem;
    private String seguradora;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Dependente> dependentes;

    public Apolice() {
    }

    public Apolice(Long id, String cpf, String nome, String bem, String seguradora, List<Dependente> dependentes) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.bem = bem;
        this.seguradora = seguradora;
        this.dependentes = dependentes;
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

    public String getBem() {
        return bem;
    }

    public String getSeguradora() {
        return seguradora;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void addDepenente(Dependente dependente) {
        this.dependentes.add(dependente);
    }
}
