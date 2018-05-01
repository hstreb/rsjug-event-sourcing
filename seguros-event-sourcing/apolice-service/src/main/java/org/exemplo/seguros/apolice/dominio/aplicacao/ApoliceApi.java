package org.exemplo.seguros.apolice.dominio.aplicacao;

import org.exemplo.seguros.apolice.dominio.dominio.ApoliceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/apolices")
public class ApoliceApi {

    private ApoliceService service;

    public ApoliceApi(ApoliceService service) {
        this.service = service;
    }

    @PostMapping
    public ComandoRecebido criar(@RequestBody ApoliceDTO apolice) {
        service.criar(apolice.toDomain());
        return new ComandoRecebido("Recebemos sua requisição para criar uma apolice.");
    }

    @GetMapping("/{numero}")
    public ApoliceDTO ler(@PathVariable("numero") Long numero) {
        return new ApoliceDTO(service.ler(numero));
    }

    @PostMapping("/{numero}/dependentes")
    public ComandoRecebido adicionarDependente(@PathVariable("numero") Long numero, @RequestBody DependenteDTO dependente) {
        service.adicionarDependente(numero, dependente.toDomain());
        return new ComandoRecebido("Recebemos sua requisição para adicionar um dependente.");
    }

}
