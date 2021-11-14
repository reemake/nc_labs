package repository;

import contract.Contract;
import contract.InternetConnectionContract;
import contract.MobileConnectionContract;
import contract.TelevisionContract;
import entity.Human;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    Human person;
    MobileConnectionContract someContract1;
    TelevisionContract someContract2;
    InternetConnectionContract someContract3;
    Repository repo;

    @BeforeEach
    void setUp() {
        person = new Human(256, "Иванов Иван Иванович", "1996-02-26", "Мужской", "9999 999999");
        someContract1 = new MobileConnectionContract(23, "2020-11-01", "2022-11-01", 222, person, 228, 1337, 777);
        someContract2 = new TelevisionContract(12, "2019-10-01", "2023-10-01", 244, person, "someChannelPackage");
        someContract3 = new InternetConnectionContract(33, "2019-10-01", "2023-10-01", 244, person, 60);
        repo = new Repository();
    }

    @Test
    void addContractTest() {
        boolean expectedValue = true;
        boolean actualValue = repo.addContract(someContract1);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void addSomeCountOfContractsTest() {
        Contract[] contractsArr = new Contract[3];
        contractsArr[0] = someContract1;
        contractsArr[1] = someContract2;
        contractsArr[2] = someContract3;

        boolean expectedValue = true;
        boolean actualValue = repo.addSomeCountOfContracts(contractsArr);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void deleteContractByIDTestSuccessful() {
        repo.addContract(someContract1);
        repo.addContract(someContract2);

        boolean expectedValue = true;
        boolean actualValue = repo.deleteContractByID(23);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void deleteContractByIDTestFromEmptyRepo() {
        boolean expectedValue = false;
        boolean actualValue = repo.deleteContractByID(23);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getContractByIDTestSuccessful() {
        repo.addContract(someContract1);
        repo.addContract(someContract2);

        MobileConnectionContract expectedValue = someContract1;
        MobileConnectionContract actualValue = (MobileConnectionContract) repo.getContractByID(23, MobileConnectionContract.class);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getContractByIDTestFromEmptyRepo() {
        Contract expectedValue = null;
        MobileConnectionContract actualValue = (MobileConnectionContract) repo.getContractByID(23, MobileConnectionContract.class);

        assertEquals(expectedValue, actualValue);
    }
}