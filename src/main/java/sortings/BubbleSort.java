package sortings;

import contracts.Contract;

import java.util.Comparator;

/**
 * Class that implements bubble sort
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see ISorter
 * @see InsertionSort
 */
public class BubbleSort implements ISorter {

    /**
     * @param repo array of Contracts from repository
     * @param comp comparator
     */
    @Override
    public void sort(Contract[] repo, Comparator<Contract> comp) {
        boolean swapped = true;
        for (int i = 1, len = repo.length; i < len && swapped; i++) {
            swapped = false;
            for (int j = 0; j < len - i; j++) {
                if (comp.compare(repo[j], repo[j+1]) > 0) {
                    Contract temp = repo[j];
                    repo[j] = repo[j+1];
                    repo[j+1] = temp;
                    swapped = true;
                }
            }
        }
    }

}

