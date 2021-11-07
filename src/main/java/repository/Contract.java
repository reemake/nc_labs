package repository;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Contract {

    private int ID;
    private LocalDate startDate;
    private LocalDate expirationDate;
    private int number;
    private Human owner;

    public Contract(int ID, String StartDate, String ExpirationDate, int number, Human owner) {
        this.ID = ID;
        this.startDate = LocalDate.parse(StartDate);
        this.expirationDate = LocalDate.parse(ExpirationDate);
        this.number = number;
        this.owner = owner;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(String StartDate) {
        this.startDate = LocalDate.parse(StartDate);
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String ExpirationDate) {
        this.expirationDate = LocalDate.parse(ExpirationDate);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Human getOwner() {
        return owner;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return ID == contract.ID && number == contract.number && Objects.equals(startDate, contract.startDate) && Objects.equals(expirationDate, contract.expirationDate) && Objects.equals(owner, contract.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, startDate, expirationDate, number, owner);
    }
}
