package predicates;

import contracts.Contract;
import contracts.InternetConnectionContract;
import contracts.MobileConnectionContract;
import contracts.TelevisionContract;
import entities.Human;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.Repository;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;
import static predicates.RepoPredicates.*;

class RepoPredicatesTest {

    Human person1;
    Human person2;
    MobileConnectionContract someContract1;
    TelevisionContract someContract2;
    InternetConnectionContract someContract3;
    Repository repo;
    Predicate<Contract> p;

    @BeforeEach
    void setUp() {
        person1 = new Human(256, "Иванов Иван Иванович", "1996-02-26", "М", "9999 999999");
        person2 = new Human(113, "Петрова Мария Петровна", "1991-03-22", "Ж", "8888 8888888");
        someContract1 = new MobileConnectionContract(23, "2020-11-01", "2022-11-01", 222, person1, 228, 1337, 777);
        someContract2 = new TelevisionContract(12, "2019-10-01", "2023-10-01", 244, person2, "someChannelPackage");
        someContract3 = new InternetConnectionContract(33, "2019-10-01", "2023-10-01", 244, person2, 60);
        repo = new Repository();

        repo.addContract(someContract1);
        repo.addContract(someContract2);
        repo.addContract(someContract3);
    }

    @Test
    void isContractIDLessThanTest() {
        int id = 30;
        p = isContractIDLessThan(id);
        Repository newRepo = repo.search(p);

        String expectedValue = "23, 12.";
        String actualValue = newRepo.getIDofAllContracts();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void isContractIDMoreThanTest() {
        int id = 30;
        p = isContractIDMoreThan(id);
        Repository newRepo = repo.search(p);

        String expectedValue = "33.";
        String actualValue = newRepo.getIDofAllContracts();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void isOwnerIsMaleTest() {
        p = isOwnerIsMale();
        Repository newRepo = repo.search(p);

        String expectedValue = "23.";
        String actualValue = newRepo.getIDofAllContracts();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void isOwnerIsFemaleTest() {
        p = isOwnerIsFemale();
        Repository newRepo = repo.search(p);

        String expectedValue = "12, 33.";
        String actualValue = newRepo.getIDofAllContracts();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void isOwnerAgeLessThanTest() {
        int age = 27;
        p = isOwnerAgeLessThan(age);
        Repository newRepo = repo.search(p);

        String expectedValue = "23.";
        String actualValue = newRepo.getIDofAllContracts();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void isOwnerAgeMoreThanTest() {
        int age = 27;
        p = isOwnerAgeMoreThan(age);
        Repository newRepo = repo.search(p);

        String expectedValue = "12, 33.";
        String actualValue = newRepo.getIDofAllContracts();

        assertEquals(expectedValue, actualValue);
    }
}