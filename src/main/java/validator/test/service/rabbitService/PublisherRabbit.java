package validator.test.service.rabbitService;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@EnableRabbit
public class PublisherRabbit {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public PublisherRabbit(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;

    }

    public void send(String message) {
        rabbitTemplate.convertAndSend("answers",message);

    }
}
