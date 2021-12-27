package csvReader;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import contracts.*;
import entities.Human;
import repository.Repository;
import validation.Status;
import validation.ValidationMessage;
import validation.Validator;
import java.io.*;
import java.util.List;

/**
 * Class which is describing method for reading data from CSV-file
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see Repository
 * @see Contract
 * @see MobileConnectionContract
 * @see InternetConnectionContract
 * @see TelevisionContract
 */
public class CsvReader {

    /** Variable storing the path to the file */
    private String csvFilePath;
    /** Separator that used to split the lines of the CSV-file */
    private char separator;
    /** Object of the Repository class, into which the contract data read from the CSV-file is adding */
    private Repository repo;
    /** List of validators to check the correctness of data read from CSV-file */
    private List<Validator> validators;

    /** Constructor with parameters for an object of the сsvReader class */
    public CsvReader(String csvFilePath, char separator, Repository repo, List validators) {
        this.csvFilePath = csvFilePath;
        this.separator = separator;
        this.repo = repo;
        this.validators = validators;
    }

    /**
     * Method for reading data from CSV-file
     * @throws FileNotFoundException
     * @throws IOException
     * @throws CsvValidationException
     */
    public void readFromCSV() {
        try (FileReader in = new FileReader(csvFilePath)) {
            CSVParser parser = new CSVParserBuilder().withSeparator(separator).build();
            CSVReader reader = new CSVReaderBuilder(in).withCSVParser(parser).withSkipLines(1).build();
            if (reader == null) {
                throw new FileNotFoundException(csvFilePath);
            }
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                Human person = new Human(Integer.parseInt(nextLine[4]), nextLine[5], nextLine[7], nextLine[6], nextLine[8]);
                if (nextLine[9].equals("Mobile")) {
                    String[] mobileTariffPlan = nextLine[10].split(",");
                    MobileConnectionContract contract = new MobileConnectionContract(Integer.parseInt(nextLine[0]), nextLine[2], nextLine[3], Integer.parseInt(nextLine[1]), person, Integer.parseInt(mobileTariffPlan[0]), Integer.parseInt(mobileTariffPlan[1]), Integer.parseInt(mobileTariffPlan[2]));
                    ValidationMessage validationMessage = new ValidationMessage();
                    boolean validationFailed = false;
                    for (Validator v : validators) {
                        validationMessage = v.validate(contract);
                        if (validationMessage.getStatus() == Status.FAIL) {
                            validationFailed = true;
                            break;
                        }
                    }
                    if (validationFailed)
                        System.out.println("Ошибка валидации для контракта с ID = " + contract.getID() + '!' + validationMessage);
                    else repo.addContract(contract);
                }
                else if (nextLine[9].equals("Television")) {
                    TelevisionContract contract = new TelevisionContract(Integer.parseInt(nextLine[0]), nextLine[2], nextLine[3], Integer.parseInt(nextLine[1]), person, nextLine[10]);
                    ValidationMessage validationMessage = new ValidationMessage();
                    boolean validationFailed = false;
                    for (Validator v : validators) {
                        validationMessage = v.validate(contract);
                        if (validationMessage.getStatus() == Status.FAIL) {
                            validationFailed = true;
                            break;
                        }
                    }
                    if (validationFailed)
                        System.out.println("Ошибка валидации для контракта с ID = " + contract.getID() + '!' + validationMessage);
                    else repo.addContract(contract);
                }
                else if (nextLine[9].equals("Internet")) {
                    InternetConnectionContract contract = new InternetConnectionContract(Integer.parseInt(nextLine[0]), nextLine[2], nextLine[3], Integer.parseInt(nextLine[1]), person, Integer.parseInt(nextLine[10]));
                    ValidationMessage validationMessage = new ValidationMessage();
                    boolean validationFailed = false;
                    for (Validator v : validators) {
                        validationMessage = v.validate(contract);
                        if (validationMessage.getStatus() == Status.FAIL) {
                            validationFailed = true;
                            break;
                        }
                    }
                    if (validationFailed)
                        System.out.println("Ошибка валидации для контракта с ID = " + contract.getID() + '!' + validationMessage);
                    else repo.addContract(contract);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    public String getCsvFilePath() {
        return csvFilePath;
    }

    public void setCsvFilePath(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    public char getSeparator() {
        return separator;
    }

    public void setSeparator(char separator) {
        this.separator = separator;
    }

    public List<Validator> getValidators() {
        return validators;
    }

    public void setValidators(List<Validator> validators) {
        this.validators = validators;
    }
}
