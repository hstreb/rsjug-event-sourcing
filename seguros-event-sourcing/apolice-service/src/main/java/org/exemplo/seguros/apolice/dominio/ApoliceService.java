package org.exemplo.seguros.apolice.dominio;

import org.exemplo.seguros.apolice.dominio.evento.ApoliceCriada;
import org.exemplo.seguros.apolice.dominio.evento.DependenteAdicionado;
import org.exemplo.seguros.apolice.infraestrutura.EventoStore;
import org.springframework.stereotype.Service;

@Service
public class ApoliceService {

    private EventoStore eventoStore;
    private ApoliceRespository respository;

    public ApoliceService(EventoStore eventoStore, ApoliceRespository respository) {
        this.eventoStore = eventoStore;
        this.respository = respository;
    }

    public Apolice ler(Long numero) {
        return respository.ler(numero)
                .orElseThrow(() -> new ApoliceNotFoundException("Não foi encontrada apolice '" + numero + "'!"));
    }

    public void criar(Apolice apolice) {
        eventoStore.salvar(criarApolice(apolice));
    }

    public void adicionarDependente(Long numero, Dependente dependente) {
        eventoStore.salvar(novoDependente(numero, dependente));
    }

    private DependenteAdicionado novoDependente(Long numero, Dependente dependente) {
        return new DependenteAdicionado(numero, dependente.getCpf(), dependente.getNome(), dependente.getIdade());
    }

    private ApoliceCriada criarApolice(Apolice apolice) {
        return new ApoliceCriada(apolice.getNumero(),
                apolice.getCpf(),
                apolice.getNome(),
                apolice.getBem(),
                apolice.getSeguradora(),
                apolice.getDependentes());
    }

}
