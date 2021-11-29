package comparators;

import contracts.Contract;

import java.util.Comparator;

/**
 * Class that implements comparison by criterion: contract number
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see Comparator
 * @see ContractIDComparatorImpl
 */
public class ContractNumberComparatorImpl implements Comparator<Contract> {

    /**
     * Overrided comparing method from Comparator class for objects of Contract class for comparing by contract number
     * @param o1 contract1
     * @param o2 contract2
     * @return 1 if number of contract1 more than number of contract2, -1 if number of contract1 less than number of contract2, 0 if they equal
     */
    @Override
    public int compare(Contract o1, Contract o2) {
        if (o1.getNumber() > o2.getNumber())
            return 1;
        else if (o1.getNumber() < o2.getNumber())
            return -1;
        else return 0;
    }
}
