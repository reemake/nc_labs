package jdbc;

import contracts.InternetConnectionContract;
import contracts.MobileConnectionContract;
import contracts.TelevisionContract;
import entities.Human;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JDBCTest {

    Human person1;
    Human person2;
    Human person3;
    MobileConnectionContract someContract1;
    TelevisionContract someContract2;
    InternetConnectionContract someContract3;

    @BeforeEach
    void setUp() {
        person1 = new Human(211, "Иванов Иван Иванович", "1996-02-26", "Мужской", "9999 999999");
        person2 = new Human(25, "Петров Петр Петрович", "1956-05-22", "Мужской", "7777 777777");
        person3 = new Human(132, "Сидоров Виктор Александрович", "1982-11-29", "Мужской", "8888 888888");
        someContract1 = new MobileConnectionContract(23, "2020-11-01", "2022-11-01", 222, person1, 228, 1337, 777);
        someContract2 = new TelevisionContract(12, "2019-10-01", "2023-10-01", 152, person2, "someChannelPackage");
        someContract3 = new InternetConnectionContract(33, "2019-10-01", "2023-10-01", 4, person3, 60);
    }

    @Test
    void DBCreateAndInsertTablesTest() {
        H2Utils.createTables();
        H2Utils.addContract(someContract1);
        H2Utils.addContract(someContract2);
        H2Utils.addContract(someContract3);
        H2Utils.printRepoTable();
    }

}
