package org.exemplo.seguros.fatura.dominio.evento;

public class DependenteAdicionado implements Evento {

    private Long numero;
    private Integer idade;

    public DependenteAdicionado() {
    }

    public DependenteAdicionado(Long numero, Integer idade) {
        this.numero = numero;
        this.idade = idade;
    }

    public Long getNumero() {
        return numero;
    }

    public Integer getIdade() {
        return idade;
    }

}