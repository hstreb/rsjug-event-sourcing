package org.exemplo.seguros.apolice.dominio.aplicacao;

public class ComandoRecebido {
    private String mensagem;

    public ComandoRecebido(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}