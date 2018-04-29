package org.exemplo.seguros.apolice.aplicacao;

import org.exemplo.seguros.apolice.dominio.ApoliceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/apolices")
public class ApoliceApi {

    private ApoliceService service;

    public ApoliceApi(ApoliceService service) {
        this.service = service;
    }

    @PostMapping
    public ComandoRecebido salvar(@RequestBody ApoliceDTO apolice) {
        service.criar(apolice.toDomain());
        return new ComandoRecebido("Recebemos sua requisição para salvar uma apolice.");
    }

    @GetMapping("/{numero}")
    public ApoliceDTO buscar(@PathVariable("numero") Long numero) {
        return new ApoliceDTO(service.ler(numero));
    }

    @PostMapping("/{numero}/dependentes")
    public ComandoRecebido atualizarDependente(@PathVariable("numero") Long numero, @RequestBody DependenteDTO dependente) {
        service.adicionarDependente(numero, dependente.toDomain());
        return new ComandoRecebido("Recebemos sua requisição para adicionar um dependente.");
    }

}
