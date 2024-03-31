package validator.test.service.rabbitService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import validator.test.model.CsvInformation;
import validator.test.service.csvInformationService.CsvInformationService;

@Service
public class ConsumerRabbitImp implements ConsumerRabbit {

    boolean answers ;
    private ObjectMapper objectMapper;
    private CsvInformationService csvInformationService;
    private PublisherRabbit publisherRabbit;
    @Autowired
    public ConsumerRabbitImp(ObjectMapper objectMapper, CsvInformationService csvInformationService, PublisherRabbit publisherRabbit) {
        this.objectMapper = objectMapper;
        this.csvInformationService = csvInformationService;
        this.publisherRabbit = publisherRabbit;
    }
    @Override
    @RabbitListener(queues = "csvperson")
    public void receive(String jsonInfo) {

        try {
            CsvInformation csvInformation = objectMapper.readValue(jsonInfo, CsvInformation.class);
           answers = csvInformationService.validateUser(csvInformation);
           publisherRabbit.send(Boolean.toString(answers));
        } catch (Exception e) {
            System.out.println(e);
        }

    }




}
