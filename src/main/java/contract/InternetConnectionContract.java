package contract;

import entity.Human;
import repository.Repository;

/**
 * Class which is describing an internet connection contract structure
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see Repository
 * @see Contract
 * @see MobileConnectionContract
 * @see TelevisionContract
 */
public class InternetConnectionContract extends Contract {

    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /** Default constructor for an object of the InternetConnectionContract class */
    public InternetConnectionContract() {
        super();
        this.speed = 0;
    }

    /** Constructor with parameters for an object of the InternetConnectionContract class */
    public InternetConnectionContract(int ID, String StartDate, String ExpirationDate, int number, Human owner, int speed) {
        super(ID, StartDate, ExpirationDate, number, owner);
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Контракт на проводной интернет № " + this.getNumber() +
                "\nID: " + this.getID() +
                "\nДата начала контракта: " + this.getStartDate() +
                "\nДата окончания контракта: " + this.getExpirationDate() +
                "\nСкорость интернета: " + this.getSpeed() + " Mbps" +
                "\n\nВладелец контракта: \n" + this.getOwner().toString();
    }

}
