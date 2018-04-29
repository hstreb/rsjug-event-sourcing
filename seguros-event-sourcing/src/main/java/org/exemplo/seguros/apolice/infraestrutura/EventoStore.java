package org.exemplo.seguros.apolice.infraestrutura;

import org.exemplo.seguros.apolice.dominio.evento.ApoliceCriada;
import org.exemplo.seguros.apolice.dominio.evento.DependenteAdicionado;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class EventoStore {

    private KafkaTemplate<Long, ApoliceCriada> kafkaTemplateApolice;
    private KafkaTemplate<Long, DependenteAdicionado> kafkaTemplateDependente;
    private String topicApolice;
    private String topicDependente;

    public EventoStore(KafkaTemplate<Long, ApoliceCriada> kafkaTemplateApolice,
                       KafkaTemplate<Long, DependenteAdicionado> kafkaTemplateDependente,
                       @Value("${app.topic.apolice}") String topicApolice,
                       @Value("${app.topic.dependente}") String topicDependente) {
        this.kafkaTemplateApolice = kafkaTemplateApolice;
        this.kafkaTemplateDependente = kafkaTemplateDependente;
        this.topicApolice = topicApolice;
        this.topicDependente = topicDependente;
    }

    public void salvar(ApoliceCriada evento) {
        Message<ApoliceCriada> message = MessageBuilder
                .withPayload(evento)
                .setHeader(KafkaHeaders.TOPIC, topicApolice)
                .build();
        kafkaTemplateApolice.send(message);
    }

    public void salvar(DependenteAdicionado evento) {
        Message<DependenteAdicionado> message = MessageBuilder
                .withPayload(evento)
                .setHeader(KafkaHeaders.TOPIC, topicDependente)
                .build();
        kafkaTemplateDependente.send(message);
    }
}
