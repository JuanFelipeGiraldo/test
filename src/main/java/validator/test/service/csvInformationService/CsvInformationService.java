package validator.test.service.csvInformationService;

import org.springframework.stereotype.Service;
import validator.test.model.CsvInformation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class CsvInformationService {
    private static final Set<String> jobTitles = new HashSet<>(Arrays.asList("test", "Haematologist", "Phytotherapist", "Building surveyor", "Insurance", "account manager", "Educational psychologist"));

    public boolean validateUser(CsvInformation csvInformation) {
        return isValidEmail(csvInformation.getEmail()) && isValidDateOfBirth(csvInformation.getDate()) && isValidJobTitle(csvInformation.getJobTitle());
    }

    private boolean isValidDateOfBirth(String date) {
        try {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fecha = LocalDate.parse(date, dateFormat);
            return !fecha.isBefore(LocalDate.of(1980, 1, 1));
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    private boolean isValidJobTitle(String jobTitle) {
        String lowerCaseJobTitle = jobTitle.replaceAll("\\s+", "").toLowerCase();
        for (String title : jobTitles) {
            if (lowerCaseJobTitle.contains(title.replaceAll("\\s+", "").toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}