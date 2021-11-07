package repository;

import java.util.Arrays;
import java.util.Objects;

/**
 * Class which is describing a repository based on expanding array mechanism
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see Human
 * @see Contract
 * @see MobileConnectionContract
 * @see InternetConnectionContract
 * @see TelevisionContract
 */
public class Repository {

    /** Current number of contracts in the repository */
    private int size;

    /** Max number of contracts in the repository */
    private int capacity;

    /** A repository represented by an expanding array */
    private Contract[] repo;

    /** Default constructor for an object of the Repository class */
    public Repository() {
        size = 0;
        capacity = 1;
        repo = new Contract[capacity];
    }

    /** Constructor with parameters for an object of the Repository class */
    public Repository(int Capacity) {
        size = 0;
        this.capacity = Capacity;
        repo = new Contract[capacity];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Contract[] getRepo() {
        return repo;
    }

    public void setRepo(Contract[] repo) {
        this.repo = repo;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        capacity *= 2;
        Contract[] newRepo = new Contract[capacity];
        for (int i = 0; i < size; i++) {
            newRepo[i] = repo[i];
            repo[i] = null;
        }
        repo = newRepo;
    }


    /**
     * Adding contract to the repository
     * @param contract element (inheritor) of an abstract class Contract
     * @return true on successful adding, false otherwise
     */
    public boolean addContract(Contract contract) {
        if (size >= capacity) resize();
        repo[size++] = contract;
        return true;
    }

    /**
     * Adding a certain number of contracts to the repository
     * @param contracts elements (inheritors) of an abstract class Contract
     * @return true on successful adding, false otherwise
     */
    public boolean addSomeCountOfContracts(Contract[] contracts) {
        for (int i = 0; i < contracts.length; i++)
            addContract(contracts[i]);
        return true;
    }


    /**
     * Helper function to shift array elements to the left, used when deleting
     * @param start starting position
     */
    private void shiftArrToLeft(int start) {
        for (int i = start; i < size - 1; i++)
            repo[i] = repo[i+1];
        repo[size - 1] = null;
        size--;
    }

    /**
     * Removing contract from repository by ID
     * @param contractID ID of contract
     * @return true on successful removing, false otherwise
     */
    public boolean deleteContractByID(int contractID) {
        if (isEmpty()) return false;
        else {
            for (int i = 0; i < size; i++)
                if (contractID == repo[i].getID())
                    shiftArrToLeft(i);
        }
        return true;
    }

    /** Getting contract from repository by ID
     * @param contractID ID of contract
     * @param expectedClass one of three types of contracts
     * @return object of the specified contract class, null otherwise
     */
    public Contract getContractByID(int contractID, Class expectedClass) {
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (contractID == repo[i].getID() && repo[i].getClass().equals(expectedClass))
                    return repo[i];
            }
        }
        return null;
    }

    /**
     * Helper function for toString, used to display the IDs of the contracts available in the repository
     * @return a string containing IDs of the contracts available in the repository
     */
    public String getIDofAllContracts() {
        String result = "";
        if (!isEmpty()) {
            for (int i = 0; i < size - 1; i++)
                result += repo[i].getID() + ", ";
            result += repo[size - 1].getID() + ".";
            return result;
        }
        else return "-";
    }

    /**
     * Overrided method toString()
     * @return repository data
     */
    @Override
    public String toString() {
        return "\tРепозиторий" +
                "\nЗаполнен на: " + this.size +
                "\nВсего места: " + this.capacity +
                "\nКонтракты (ID): " + this.getIDofAllContracts();
    }

    /**
     * Overrided method equals()
     * @param o object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repository that = (Repository) o;
        return size == that.size && capacity == that.capacity && Arrays.equals(repo, that.repo);
    }

    /**
     * Overrided method hashCode()
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(size, capacity);
        result = 31 * result + Arrays.hashCode(repo);
        return result;
    }

}
