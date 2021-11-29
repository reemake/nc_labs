package sortings;

import contracts.Contract;

import java.util.Comparator;

/**
 * Class that implements insertion sort
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see ISorter
 * @see BubbleSort
 */
public class InsertionSort implements ISorter {

    /**
     * @param repo array of Contracts from repository
     * @param comp comparator
     */
    @Override
    public void sort(Contract[] repo, Comparator<Contract> comp) {
        for (int i = 1; i < repo.length; i++) {
            Contract current = repo[i];
            int j = i - 1;
            while (j >= 0 && comp.compare(current, repo[j]) < 0) {
                repo[j+1] = repo[j];
                j--;
            }
            repo[j+1] = current;
        }
    }
}
