package validator.test.model;


public class CsvInformation {

    private String email;
    private String date;
    private String jobTitle;


    public CsvInformation(String email, String date, String jobTitle) {
        this.email = email;
        this.date = date;
        this.jobTitle = jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public String getDate() {
        return date;
    }

    public String getJobTitle() {
        return jobTitle;
    }

}

