package validator.test.service.rabbitService;
import org.springframework.messaging.handler.annotation.Payload;
import validator.test.model.CsvInformation;


public interface ConsumerRabbit {


    void receive(@Payload String jsonInfo);
}
