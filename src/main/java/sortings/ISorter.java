package sortings;

import contracts.Contract;
import sortings.impl.BubbleSort;
import sortings.impl.InsertionSort;

import java.util.Comparator;

/**
 * Interface which is defining the sort method
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see BubbleSort
 * @see InsertionSort
 */
public interface ISorter {

    /**
     * Method for sorting by some criterion (criterion is determined by a comparator)
     * @param repo array of Contracts from repository
     * @param comp comparator
     */
    void sort(Contract[] repo, Comparator<Contract> comp);

}
