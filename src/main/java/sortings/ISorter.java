package sortings;

import contracts.Contract;

import java.util.Comparator;

public interface ISorter {

    void sort(Contract[] repo, Comparator<Contract> comp);

}
