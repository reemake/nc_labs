package entities;

import contracts.Contract;
import jaxb.DateAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.Period;

/**
 * Class which is describing an entity Human
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see Contract
 */
public class Human {

    private int ID;
    private String FIO;
    private LocalDate birthday;
    private String gender;
    private String passport;
    private int age;

    /** Default constructor for an object of the Human class */
    public Human() {
        this.ID = 0;
        this.FIO = "";
        this.birthday = null;
        this.gender = "";
        this.passport = "";
        this.age = 0;
    }

    /** Constructor with parameters for an object of the Human class */
    public Human(int ID, String FIO, String Birthday, String gender, String passport) {
        this.ID = ID;
        this.FIO = FIO;
        this.birthday = LocalDate.parse(Birthday);
        this.gender = gender;
        this.passport = passport;
        this.age = calcAge();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    @XmlJavaTypeAdapter(value = DateAdapter.class)
    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(String Birthday) {
        this.birthday = LocalDate.parse(Birthday);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    /**
     * Function of calculating the age
     * @return age in years
     */
    public int calcAge() {
        LocalDate currDate = LocalDate.now();
        if (this.birthday != null && currDate != null)
            return Period.between(birthday, currDate).getYears();
        else
            return 0;
    }

    @Override
    public String toString() {
        return "ID: " + this.getID() +
                "\nФИО: " + this.getFIO() +
                "\nДата рождения: " + this.getBirthday() +
                "\nПол: " + this.getGender() +
                "\nПаспорт: " + this.getPassport() +
                "\nВозраст: " + this.getAge();
    }

}
