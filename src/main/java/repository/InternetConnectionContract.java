package repository;

public class InternetConnectionContract extends Contract {

    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public InternetConnectionContract() {
        super(0, "", null, 0, null);
        this.speed = 0;
    }

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
