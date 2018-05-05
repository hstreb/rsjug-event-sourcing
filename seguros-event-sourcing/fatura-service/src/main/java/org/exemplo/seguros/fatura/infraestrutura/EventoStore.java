package org.exemplo.seguros.fatura.infraestrutura;

import org.exemplo.seguros.fatura.dominio.evento.FaturaCriada;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class EventoStore {
    private KafkaTemplate<Long, FaturaCriada> kafkaTemplate;
    private String topic;

    public EventoStore(KafkaTemplate<Long, FaturaCriada> kafkaTemplate, @Value("${app.topic.fatura}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void salvar(FaturaCriada faturaCriada) {
        Message<FaturaCriada> message = MessageBuilder
                .withPayload(faturaCriada)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();
        kafkaTemplate.send(message);
    }
}
