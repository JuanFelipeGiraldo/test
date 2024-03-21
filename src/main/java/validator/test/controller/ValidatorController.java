package validator.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import validator.test.model.CsvInformation;
import validator.test.service.CsvInformationService;


@RestController
public class ValidatorController {

    private CsvInformationService csvInformationService;
    @Autowired
    public ValidatorController(CsvInformationService csvInformationService) {
        this.csvInformationService = csvInformationService;
    }

    @GetMapping("/validator")
    public String test() {
        return "Validator ON";
    }


    @GetMapping("/test/x")
    public String obtenerDatos() {
        // Lógica para obtener los datos del servicio 2
        return "Datos del test";

    }

    @PostMapping("/usuarios/cvs")
    public boolean validatorUser(@RequestBody CsvInformation csvInformation) {
        return this.csvInformationService.validateUser(csvInformation);
    }

}
