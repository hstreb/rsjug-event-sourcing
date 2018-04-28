package org.exemplo.seguros.fatura;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faturas")
public class FaturaApi {

    private FaturaService faturaService;

    public FaturaApi(FaturaService faturaService) {
        this.faturaService = faturaService;
    }

    @PostMapping
    public Fatura salvar(@RequestBody Fatura fatura) {
        return faturaService.salvar(fatura);
    }

    @GetMapping("/{apoliceId}")
    public List<Fatura> buscar(@PathVariable Long apoliceId) {
        return faturaService.buscar(apoliceId);
    }
}
