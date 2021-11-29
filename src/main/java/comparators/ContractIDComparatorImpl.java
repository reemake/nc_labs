package comparators;

import contracts.Contract;

import java.util.Comparator;

public class ContractIDComparatorImpl implements Comparator<Contract> {

    @Override
    public int compare(Contract o1, Contract o2) {
        if (o1.getID() > o2.getID())
            return 1;
        else if (o1.getID() < o2.getID())
            return -1;
        else return 0;
    }

}
