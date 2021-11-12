package repository;

/**
 * Class which is describing a mobile connection contract structure
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see Repository
 * @see Contract
 * @see InternetConnectionContract
 * @see TelevisionContract
 */
public class MobileConnectionContract extends Contract {

    private int minutes;
    private int sms;
    private int traffic;

    /** Default constructor for an object of the MobileConnectionContract class */
    public MobileConnectionContract() {
        super();
        this.minutes = 0;
        this.sms = 0;
        this.traffic = 0;
    }

    /** Constructor with parameters for an object of the MobileConnectionContract class */
    public MobileConnectionContract(int ID, String StartDate, String ExpirationDate, int number, Human owner, int minutes, int sms, int traffic) {
        super(ID, StartDate, ExpirationDate, number, owner);
        this.minutes = minutes;
        this.sms = sms;
        this.traffic = traffic;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }

    public int getTraffic() {
        return traffic;
    }

    public void setTraffic(int traffic) {
        this.traffic = traffic;
    }

    @Override
    public String toString() {
        return "Контракт на мобильную связь № " + this.getNumber() +
                "\nID: " + this.getID() +
                "\nДата начала контракта: " + this.getStartDate() +
                "\nДата окончания контракта: " + this.getExpirationDate() +
                "\nКоличество минут: " + this.minutes +
                "\nКоличество смс: " + this.sms +
                "\nТраффик: " + this.traffic + " Гб" +
                "\n\nВладелец контракта: \n" + this.getOwner().toString();
    }

}
