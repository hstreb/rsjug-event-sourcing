package org.exemplo.seguros.fatura.infraestrutura;

import org.exemplo.seguros.fatura.dominio.Fatura;
import org.exemplo.seguros.fatura.dominio.FaturaRepository;
import org.exemplo.seguros.fatura.dominio.evento.FaturaCriada;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FaturaRepositoryImpl implements FaturaRepository {

    private List<Fatura> faturas;

    public FaturaRepositoryImpl() {
        this.faturas = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public List<Fatura> buscar(Long apolice) {
        return faturas.stream()
                .filter(fatura -> fatura.getApolice().equals(apolice))
                .collect(Collectors.toList());
    }

    @KafkaListener(topics = "${app.topic.fatura}")
    public void receive(@Payload FaturaCriada faturaCriada) {
        Fatura fatura = new Fatura(faturaCriada.getApolice(), faturaCriada.getValor());
        faturas.add(fatura);
    }
}
