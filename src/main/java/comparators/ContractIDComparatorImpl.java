package comparators;

import contracts.Contract;
import contracts.InternetConnectionContract;
import contracts.MobileConnectionContract;
import contracts.TelevisionContract;

import java.util.Comparator;

/**
 * Class that implements comparison by criterion: contract ID
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see Comparator
 * @see ContractNumberComparatorImpl
 */
public class ContractIDComparatorImpl implements Comparator<Contract> {

    /**
     * Overrided comparing method from Comparator class for objects of Contract class for comparing by contract ID
     * @param o1 contract1
     * @param o2 contract2
     * @return 1 if ID of contract1 more than ID of contract2, -1 if ID of contract1 less than ID of contract2, 0 if they equal
     */
    @Override
    public int compare(Contract o1, Contract o2) {
        if (o1.getID() > o2.getID())
            return 1;
        else if (o1.getID() < o2.getID())
            return -1;
        else return 0;
    }

}
