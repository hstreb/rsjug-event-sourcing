package org.exemplo.seguros.apolice.infraestrutura;

import org.exemplo.seguros.apolice.dominio.Apolice;
import org.exemplo.seguros.apolice.dominio.ApoliceRespository;
import org.exemplo.seguros.apolice.dominio.evento.ApoliceCriada;
import org.exemplo.seguros.apolice.dominio.evento.DependenteAdicionado;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ApoliceRespositoryImpl implements ApoliceRespository {

    private List<Apolice> apolices;

    public ApoliceRespositoryImpl() {
        apolices = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public Optional<Apolice> ler(Long numero) {
        return apolices.stream()
                .filter(a -> a.getNumero().equals(numero))
                .findFirst();
    }

    @KafkaListener(topics = "${app.topic.apolice}")
    public void receive(@Payload ApoliceCriada apoliceCriada) {
        Apolice apolice = new Apolice(apoliceCriada.getNumero(),
                apoliceCriada.getCpf(),
                apoliceCriada.getNome(),
                apoliceCriada.getBem(),
                apoliceCriada.getSeguradora(),
                apoliceCriada.getDependentes());
        apolices.add(apolice);
    }

    @KafkaListener(topics = "${app.topic.dependente}")
    public void receive(@Payload DependenteAdicionado dependenteAdicionado) {
        ler(dependenteAdicionado.getNumero())
                .ifPresent(apolice -> apolice.adicionar(dependenteAdicionado));
    }
}
