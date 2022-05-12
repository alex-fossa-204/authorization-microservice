package by.andersen.laboratory.microservice.authorization.service;

import by.andersen.laboratory.microservice.authorization.config.kafka.message.UserMessage;

public interface ProducerService {

    public void sendMessageToUsersMicroservice(UserMessage userMessage);

}
