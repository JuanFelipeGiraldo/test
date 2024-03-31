package validator.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import validator.test.model.CsvInformation;
import validator.test.service.csvInformationService.CsvInformationService;


@RestController
public class ValidatorController {

    private CsvInformationService csvInformationService;
    @Autowired
    public ValidatorController(CsvInformationService csvInformationService) {
        this.csvInformationService = csvInformationService;
    }

    @PostMapping("/validator/cvs")
    public boolean validatorUser(@RequestBody CsvInformation csvInformation) {
        return this.csvInformationService.validateUser(csvInformation);
    }

}
