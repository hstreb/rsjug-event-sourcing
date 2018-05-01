package org.exemplo.seguros.fatura.aplicacao;

import org.exemplo.seguros.fatura.dominio.FaturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/faturas")
public class FaturaApi {

    private FaturaService faturaService;

    public FaturaApi(FaturaService faturaService) {
        this.faturaService = faturaService;
    }

    @PostMapping
    public ComandoRecebido salvar(@RequestBody FaturaDTO fatura) {
        faturaService.salvar(fatura.toDomain());
        return new ComandoRecebido("Recebemos sua requisição para criar uma fatura.");
    }

    @GetMapping("/{apolice}")
    public List<FaturaDTO> buscar(@PathVariable Long apolice) {
        return faturaService.buscar(apolice).stream()
                .map(FaturaDTO::new)
                .collect(Collectors.toList());
    }
}
