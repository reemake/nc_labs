package repository;

import java.time.LocalDate;
import java.time.Period;

public class Human {

    private int ID;
    private String FIO;
    private LocalDate birthday;
    private String gender;
    private String passport;
    private int age;

    public Human() {
        this.ID = 0;
        this.FIO = "";
        this.birthday = null;
        this.gender = "";
        this.passport = "";
        this.age = 0;
    }

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
