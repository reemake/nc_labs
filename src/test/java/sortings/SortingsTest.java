package sortings;

import comparators.ContractIDComparatorImpl;
import comparators.ContractNumberComparatorImpl;
import contracts.InternetConnectionContract;
import contracts.MobileConnectionContract;
import contracts.TelevisionContract;
import entities.Human;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class SortingsTest {

    Human person1;
    Human person2;
    MobileConnectionContract someContract1;
    TelevisionContract someContract2;
    InternetConnectionContract someContract3;
    TelevisionContract someContract4;
    InternetConnectionContract someContract5;
    Repository repo;

    @BeforeEach
    void setUp() {
        person1 = new Human(256, "Иванов Иван Иванович", "1996-02-26", "М", "9999 999999");
        person2 = new Human(113, "Петрова Мария Петровна", "1991-03-22", "Ж", "8888 888888");
        someContract1 = new MobileConnectionContract(53, "2020-11-01", "2022-11-01", 522, person1, 228, 1337, 777);
        someContract2 = new TelevisionContract(12, "2019-10-01", "2023-10-01", 241, person1, "someChannelPackage");
        someContract3 = new InternetConnectionContract(31, "2019-10-01", "2023-10-01", 111, person2, 60);
        someContract4 = new TelevisionContract(45, "2018-11-01", "2022-11-01", 345, person2, "someChannelPackage");
        someContract5 = new InternetConnectionContract(84, "2020-09-01", "2023-09-01", 901, person2, 70);
        repo = new Repository();

        repo.addContract(someContract1);
        repo.addContract(someContract2);
        repo.addContract(someContract3);
        repo.addContract(someContract4);
        repo.addContract(someContract5);
        repo.trimToSizeArray();
    }

    @Test
    void BubbleSortByContractIDTest() {
        repo.setSorter(new BubbleSort());
        repo.sort(new ContractIDComparatorImpl());

        String expectedValue = "12, 31, 45, 53, 84.";
        String actualValue = repo.getIDofAllContracts();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void InsertionSortByContractIDTest() {
        repo.setSorter(new InsertionSort());
        repo.sort(new ContractIDComparatorImpl());

        String expectedValue = "12, 31, 45, 53, 84.";
        String actualValue = repo.getIDofAllContracts();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void BubbleSortByContractNumberTest() {
        repo.setSorter(new BubbleSort());
        repo.sort(new ContractNumberComparatorImpl());

        int expectedValue = 111;
        int actualValue = repo.getContractByIndex(0).getNumber();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void InsertionSortByContractNumberTest() {
        repo.setSorter(new InsertionSort());
        repo.sort(new ContractNumberComparatorImpl());

        int expectedValue = 111;
        int actualValue = repo.getContractByIndex(0).getNumber();

        assertEquals(expectedValue, actualValue);
    }
}