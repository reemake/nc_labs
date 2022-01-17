package predicates;

import contracts.Contract;
import contracts.InternetConnectionContract;
import contracts.MobileConnectionContract;
import contracts.TelevisionContract;

import java.util.function.Predicate;

/**
 * Class which is listing various predicates
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see Contract
 * @see MobileConnectionContract
 * @see InternetConnectionContract
 * @see TelevisionContract
 */
public class RepoPredicates {

    public static Predicate<Contract> isContractIDLessThan(int id) {
        return p -> (p instanceof MobileConnectionContract && ((MobileConnectionContract) p).getID() < id) || (p instanceof InternetConnectionContract && ((InternetConnectionContract) p).getID() < id) || (p instanceof TelevisionContract && ((TelevisionContract) p).getID() < id);
    }

    public static Predicate<Contract> isContractIDMoreThan(int id) {
        return p -> (p instanceof MobileConnectionContract && ((MobileConnectionContract) p).getID() > id) || (p instanceof InternetConnectionContract && ((InternetConnectionContract) p).getID() > id) || (p instanceof TelevisionContract && ((TelevisionContract) p).getID() > id);
    }

    public static Predicate<Contract> isOwnerIsMale() {
        return p -> (p instanceof MobileConnectionContract && ((MobileConnectionContract) p).getOwner().getGender().equalsIgnoreCase("М")) || (p instanceof InternetConnectionContract && ((InternetConnectionContract) p).getOwner().getGender().equalsIgnoreCase("М")) || (p instanceof TelevisionContract && ((TelevisionContract) p).getOwner().getGender().equalsIgnoreCase("М"));
    }

    public static Predicate<Contract> isOwnerIsFemale() {
        return p -> (p instanceof MobileConnectionContract && ((MobileConnectionContract) p).getOwner().getGender().equalsIgnoreCase("Ж")) || (p instanceof InternetConnectionContract && ((InternetConnectionContract) p).getOwner().getGender().equalsIgnoreCase("Ж")) || (p instanceof TelevisionContract && ((TelevisionContract) p).getOwner().getGender().equalsIgnoreCase("Ж"));
    }

    public static Predicate<Contract> isOwnerAgeLessThan(int age) {
        return p -> (p instanceof MobileConnectionContract && ((MobileConnectionContract) p).getOwner().getAge() < age) || (p instanceof InternetConnectionContract && ((InternetConnectionContract) p).getOwner().getAge() < age) || (p instanceof TelevisionContract && ((TelevisionContract) p).getOwner().getAge() < age);
    }

    public static Predicate<Contract> isOwnerAgeMoreThan(int age) {
        return p -> (p instanceof MobileConnectionContract && ((MobileConnectionContract) p).getOwner().getAge() > age) || (p instanceof InternetConnectionContract && ((InternetConnectionContract) p).getOwner().getAge() > age) || (p instanceof TelevisionContract && ((TelevisionContract) p).getOwner().getAge() > age);
    }

}
