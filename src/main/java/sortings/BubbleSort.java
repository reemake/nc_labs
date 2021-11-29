package sortings;

import contracts.Contract;

import java.util.Comparator;

public class BubbleSort implements ISorter {

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

