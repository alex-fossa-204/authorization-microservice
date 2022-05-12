package by.andersen.laboratory.microservice.authorization.config.kafka;

import by.andersen.laboratory.microservice.authorization.config.kafka.message.UserMessage;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Map;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Configuration
public class KafkaProducerConfig {

    @Value("${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    private Map<String, Object> jsonConfigurationProperties() {
        Map<String, Object> configProperties = Map.of(
                BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress,
                KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
                VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class
        );
        return configProperties;
    }

    @Bean
    public ProducerFactory<String, UserMessage> userMicroserviceProducerFactory() {
        return new DefaultKafkaProducerFactory<>(jsonConfigurationProperties());
    }

    @Bean
    public KafkaTemplate<String, UserMessage> userMicroserviceKafkaTemplate() {
        KafkaTemplate<String, UserMessage> kafkaTemplate = new KafkaTemplate<>(userMicroserviceProducerFactory());
        kafkaTemplate.setMessageConverter(new StringJsonMessageConverter());
        return kafkaTemplate;
    }

}
