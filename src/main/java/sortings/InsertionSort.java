package sortings;

import contracts.Contract;

import java.util.Comparator;

public class InsertionSort implements ISorter {

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
