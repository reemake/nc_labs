package csvReader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.Repository;
import validation.ContractDatesValidator;
import validation.ContractIDValidator;
import validation.PersonAgeValidator;
import validation.Validator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvReaderTest {

    Repository repo;
    CsvReader reader;

    @BeforeEach
    void setUp() {
        ContractIDValidator v1 = new ContractIDValidator();
        ContractDatesValidator v2 = new ContractDatesValidator();
        PersonAgeValidator v3 = new PersonAgeValidator();
        List<Validator> validators = new ArrayList();
        validators.add(v1);
        validators.add(v2);
        validators.add(v3);
        repo = new Repository();
        reader = new CsvReader("C://Users/User/IdeaProjects/netcracker_labs/src/main/resources/contracts_information.csv",  ';', repo, validators);
    }

    @Test
    void amountOfCorrectContractsTest() {
        reader.readFromCSV();
        int expectedValue = 5;
        int actualValue = repo.getSize();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void ifMobileContractBeenReadCorrectTest() {
        reader.readFromCSV();
        String expectedValue =
                "Контракт на мобильную связь № 111\n" +
                "ID: 1\n" +
                "Дата начала контракта: 2020-01-01\n" +
                "Дата окончания контракта: 2022-01-01\n" +
                "Количество минут: 200\n" +
                "Количество смс: 2000\n" +
                "Траффик: 30 Гб\n" +
                "\n" +
                "Владелец контракта: \n" +
                "ID: 1\n" +
                "ФИО: Jack N.\n" +
                "Дата рождения: 1995-02-01\n" +
                "Пол: M\n" +
                "Паспорт: 2222 222222\n" +
                "Возраст: 26";
        String actualValue = repo.getContractByIndex(0).toString();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void ifInternetContractBeenReadCorrectTest() {
        reader.readFromCSV();
        String expectedValue =
                "Контракт на проводной интернет № 444\n" +
                        "ID: 4\n" +
                        "Дата начала контракта: 2017-03-03\n" +
                        "Дата окончания контракта: 2022-03-03\n" +
                        "Скорость интернета: 60 Mbps\n" +
                        "\n" +
                        "Владелец контракта: \n" +
                        "ID: 4\n" +
                        "ФИО: Anna F.\n" +
                        "Дата рождения: 1987-06-17\n" +
                        "Пол: F\n" +
                        "Паспорт: 1111 111111\n" +
                        "Возраст: 34";
        String actualValue = repo.getContractByIndex(2).toString();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void ifTelevisionContractBeenReadCorrectTest() {
        reader.readFromCSV();
        String expectedValue =
                "Контракт на цифровое телевидение № 222\n" +
                        "ID: 2\n" +
                        "Дата начала контракта: 2019-01-01\n" +
                        "Дата окончания контракта: 2021-01-01\n" +
                        "Пакет каналов: package1\n" +
                        "\n" +
                        "Владелец контракта: \n" +
                        "ID: 2\n" +
                        "ФИО: Clint B.\n" +
                        "Дата рождения: 1991-02-02\n" +
                        "Пол: M\n" +
                        "Паспорт: 3333 333333\n" +
                        "Возраст: 30";
        String actualValue = repo.getContractByIndex(1).toString();

        assertEquals(expectedValue, actualValue);
    }
}