package comparators;

import contracts.Contract;

import java.util.Comparator;

public class ContractNumberComparatorImpl implements Comparator<Contract> {

    @Override
    public int compare(Contract o1, Contract o2) {
        if (o1.getNumber() > o2.getNumber())
            return 1;
        else if (o1.getNumber() < o2.getNumber())
            return -1;
        else return 0;
    }
}
