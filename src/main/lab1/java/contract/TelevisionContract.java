package contract;

import entity.Human;
import repository.Repository;

/**
 * Class which is describing a television contract structure
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see Repository
 * @see Contract
 * @see MobileConnectionContract
 * @see InternetConnectionContract
 */
public class TelevisionContract extends Contract {

    private String channelsPackage;

    public String getChannelsPackage() {
        return channelsPackage;
    }

    public void setChannelsPackage(String channelsPackage) {
        this.channelsPackage = channelsPackage;
    }

    /** Default constructor for an object of the TelevisionContract class */
    public TelevisionContract() {
        super();
        this.channelsPackage = "";
    }

    /** Constructor with parameters for an object of the TelevisionContract class */
    public TelevisionContract(int ID, String StartDate, String ExpirationDate, int number, Human owner, String channelsPackage) {
        super(ID, StartDate, ExpirationDate, number, owner);
        this.channelsPackage = channelsPackage;
    }

    @Override
    public String toString() {
        return "Контракт на цифровое телевидение № " + this.getNumber() +
                "\nID: " + this.getID() +
                "\nДата начала контракта: " + this.getStartDate() +
                "\nДата окончания контракта: " + this.getExpirationDate() +
                "\nПакет каналов: " + this.getChannelsPackage() +
                "\n\nВладелец контракта: \n" + this.getOwner().toString();
    }

}
