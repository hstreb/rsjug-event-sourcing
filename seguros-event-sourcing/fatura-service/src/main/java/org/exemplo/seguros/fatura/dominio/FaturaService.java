package org.exemplo.seguros.fatura.dominio;

import org.exemplo.seguros.fatura.dominio.evento.FaturaCriada;
import org.exemplo.seguros.fatura.infraestrutura.EventoStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaturaService {

    private ApoliceRepository apoliceRepository;
    private FaturaRepository faturaRepository;
    private EventoStore eventoStore;

    public FaturaService(ApoliceRepository apoliceRepository, FaturaRepository faturaRepository, EventoStore eventoStore) {
        this.apoliceRepository = apoliceRepository;
        this.faturaRepository = faturaRepository;
        this.eventoStore = eventoStore;
    }

    public void salvar(Fatura fatura) {
        apoliceRepository.buscar(fatura.getApolice())
                .ifPresent(apolice -> eventoStore.salvar(new FaturaCriada(fatura.getApolice(), apolice.getValor())));
    }

    public List<Fatura> buscar(Long apolice) {
        return faturaRepository.buscar(apolice);
    }
}
