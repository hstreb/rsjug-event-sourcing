package org.exemplo.seguros.fatura.aplicacao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.exemplo.seguros.fatura.dominio.evento.ApoliceCriada;
import org.exemplo.seguros.fatura.dominio.evento.DependenteAdicionado;
import org.exemplo.seguros.fatura.dominio.evento.FaturaCriada;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class Configuracao {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "json");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return props;
    }

    @Bean
    public ConsumerFactory<Long, ApoliceCriada> consumerFactoryApolice() {
        return new DefaultKafkaConsumerFactory<>(
                consumerConfigs(),
                new LongDeserializer(),
                new JsonDeserializer<>(ApoliceCriada.class));
    }

    @Bean
    public ConsumerFactory<Long, DependenteAdicionado> consumerFactoryDependente() {
        return new DefaultKafkaConsumerFactory<>(
                consumerConfigs(),
                new LongDeserializer(),
                new JsonDeserializer<>(DependenteAdicionado.class));
    }

    @Bean
    public ConsumerFactory<Long, FaturaCriada> consumerFactoryFatura() {
        return new DefaultKafkaConsumerFactory<>(
                consumerConfigs(),
                new LongDeserializer(),
                new JsonDeserializer<>(FaturaCriada.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<Long, ApoliceCriada> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Long, ApoliceCriada> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryApolice());
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<Long, DependenteAdicionado> kafkaListenerContainerFactoryDependente() {
        ConcurrentKafkaListenerContainerFactory<Long, DependenteAdicionado> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryDependente());
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<Long, FaturaCriada> kafkaListenerContainerFactoryFatura() {
        ConcurrentKafkaListenerContainerFactory<Long, FaturaCriada> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryFatura());
        return factory;
    }

    @Bean
    @Primary
    ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return props;
    }

    @Bean
    public ProducerFactory<Long, FaturaCriada> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<Long, FaturaCriada> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
