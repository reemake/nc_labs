package repository;

public class TelevisionContract extends Contract {

    private String channelsPackage;

    public String getChannelsPackage() {
        return channelsPackage;
    }

    public void setChannelsPackage(String channelsPackage) {
        this.channelsPackage = channelsPackage;
    }

    public TelevisionContract() {
        super(0, "", null, 0, null);
        this.channelsPackage = "";
    }

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
