package mergesort;

import java.util.ArrayList;
import java.util.List;

public class SimpleMergeSort {
    List<Integer> nums;

    public SimpleMergeSort(List<Integer> nums) {
        this.nums = nums;
    }

    // Function returns sorted list of {nums}.
    List<Integer> call() {
        int size = nums.size();

        if (size <= 1) return nums;

        int mid = size/2;

        List<Integer> leftList = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            leftList.add(nums.get(i));
        }

        List<Integer> rightList = new ArrayList<>();
        for (int i = mid; i < size; i++) {
            rightList.add(nums.get(i));
        }

        List<Integer> sortedLeftList = new SimpleMergeSort(leftList).call();
        List<Integer> sortedRightList = new SimpleMergeSort(rightList).call();

        List<Integer> sortedList = new ArrayList<>();

        int i = 0, j = 0;
        while (i < sortedLeftList.size() && j < sortedRightList.size()) {
            if (sortedLeftList.get(i) < sortedRightList.get(j)) {
                sortedList.add(sortedLeftList.get(i));
                i++;
            } else {
                sortedList.add(sortedRightList.get(j));
                j++;
            }
        }
        while (i < sortedLeftList.size()) {
            sortedList.add(sortedLeftList.get(i));
            i++;
        }
        while (j < sortedRightList.size()) {
            sortedList.add(sortedRightList.get(j));
            j++;
        }

        return sortedList;
    }

}
