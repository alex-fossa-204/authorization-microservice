package by.andersen.laboratory.microservice.authorization.service.impl;

import by.andersen.laboratory.microservice.authorization.config.kafka.message.UserMessage;
import by.andersen.laboratory.microservice.authorization.model.ClientDto;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProducerServiceImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerServiceImpl.class);

    private final KafkaTemplate<String, UserMessage> kafkaUserMicroserviceTemplate;

    public void sendMessageToUsersMicroservice(UserMessage userMessage) {
        LOGGER.info(String.format("Called method: [ProducerService] - sendMessageToUsersMicroservice(ResponseToUserMicroservice: %s)", userMessage));
    }

    public List<ClientDto> sendMessageFindAllClients() {
        LOGGER.info("Called method: [ProducerService] - sendMessageFindAllClients()");
        return null;
    }

}
