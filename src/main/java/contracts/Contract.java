package contracts;

import entities.Human;
import jaxb.DateAdapter;
import repository.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Class which is describing a general contract structure
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see Human
 * @see Repository
 * @see MobileConnectionContract
 * @see InternetConnectionContract
 * @see TelevisionContract
 */
@XmlType(propOrder = {"ID", "startDate", "expirationDate", "number", "owner"})
public abstract class Contract {

    protected int ID;
    protected LocalDate startDate;
    protected LocalDate expirationDate;
    protected int number;
    protected Human owner;

    /** Default constructor for an object of the Contract abstract class */
    public Contract() {
        this.ID = 0;
        this.startDate = null;
        this.expirationDate = null;
        this.number = 0;
        this.owner = null;
    }

    /** Constructor for an object of the Contract abstract class */
    public Contract(int ID, String StartDate, String ExpirationDate, int number, Human owner) {
        this.ID = ID;
        this.startDate = LocalDate.parse(StartDate);
        this.expirationDate = LocalDate.parse(ExpirationDate);
        this.number = number;
        this.owner = owner;
    }

    @XmlElement
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @XmlElement
    @XmlJavaTypeAdapter(value = DateAdapter.class)
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(String StartDate) {
        this.startDate = LocalDate.parse(StartDate);
    }

    @XmlElement
    @XmlJavaTypeAdapter(value = DateAdapter.class)
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String ExpirationDate) {
        this.expirationDate = LocalDate.parse(ExpirationDate);
    }

    @XmlElement
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @XmlElement
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
