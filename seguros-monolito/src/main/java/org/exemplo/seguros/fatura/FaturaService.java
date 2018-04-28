package org.exemplo.seguros.fatura;

import org.exemplo.seguros.apolice.Apolice;
import org.exemplo.seguros.apolice.ApoliceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaturaService {

    private FaturaRepository faturaRepository;
    private ApoliceService apoliceService;

    public FaturaService(FaturaRepository faturaRepository, ApoliceService apoliceService) {
        this.faturaRepository = faturaRepository;
        this.apoliceService = apoliceService;
    }

    public Fatura salvar(Fatura fatura) {
        Apolice apolice = apoliceService.buscar(fatura.getApolice().getId());
        fatura.setApolice(apolice);
        return faturaRepository.save(fatura);
    }

    public List<Fatura> buscar(Long apoliceId) {
        apoliceService.buscar(apoliceId);
        return faturaRepository.findByApoliceId(apoliceId);
    }
}
