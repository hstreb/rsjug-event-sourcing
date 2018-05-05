package org.exemplo.seguros.fatura.infraestrutura;

import org.exemplo.seguros.fatura.dominio.Apolice;
import org.exemplo.seguros.fatura.dominio.ApoliceRepository;
import org.exemplo.seguros.fatura.dominio.evento.ApoliceCriada;
import org.exemplo.seguros.fatura.dominio.evento.DependenteAdicionado;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ApoliceRepositoryImpl implements ApoliceRepository {

    private List<Apolice> apolices;

    public ApoliceRepositoryImpl() {
        this.apolices = Collections.synchronizedList(new ArrayList<>());
    }

    public Optional<Apolice> buscar(Long numero) {
        return apolices.stream()
                .filter(a -> a.getNumero().equals(numero))
                .findFirst();
    }

    @KafkaListener(topics = "${app.topic.apolice}")
    public void receive(@Payload ApoliceCriada apoliceCriada) {
        Apolice apolice = new Apolice(apoliceCriada.getNumero(), apoliceCriada.getDependentes());
        apolices.add(apolice);
    }

    @KafkaListener(topics = "${app.topic.dependente}")
    public void receive(@Payload DependenteAdicionado dependenteAdicionado) {
        buscar(dependenteAdicionado.getNumero())
                .ifPresent(apolice -> apolice.adicionar(dependenteAdicionado));
    }
}
