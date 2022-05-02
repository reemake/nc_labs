package jdbc;

public class H2Queries {

    public static String createRepoTable() {
        return "drop table test if exists; drop table contracts if exists; create table contracts(id integer auto_increment primary key, start_date date, exp_date date, number integer, owner_id integer, type varchar(30), properties varchar(255));";
    }

    public static String createCustomersTable() {
        return "drop table test if exists; drop table customers if exists; create table customers(id integer auto_increment primary key, name varchar(255), date_of_birth date, gender varchar(10), passport varchar(15));";
    }

    public static String addContract() {
        return "insert into contracts(id, start_date, exp_date, number, owner_id, type, properties) values (?, parsedatetime(formatdatetime(?, 'yyyy-MM-dd'), 'yyyy-MM-dd'),  parsedatetime(formatdatetime(?, 'yyyy-MM-dd'), 'yyyy-MM-dd'), ?, ?, ?, ?);";
    }

    public static String addCustomer() {
        return "insert into customers(id, name, date_of_birth, gender, passport) values (?, ?, parsedatetime(formatdatetime(?, 'yyyy-MM-dd'), 'yyyy-MM-dd'), ?, ?);";
    }

    public static String getContractById () {
        return "select c.* from contracts c where c.id = ?;";
    }

    public static String getCustomerById() {
        return "select c.* from customers c where c.id = ?;";
    }

    public static String getRepo() {
        return "select c.* from contracts c;";
    }
}
