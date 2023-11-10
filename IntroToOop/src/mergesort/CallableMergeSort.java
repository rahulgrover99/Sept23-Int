package mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class CallableMergeSort implements Callable<List<Integer>> {

    List<Integer> nums;
    ExecutorService executorService;

    public CallableMergeSort(List<Integer> nums, ExecutorService executorService) {
        this.nums = nums;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
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


        Future<List<Integer>> sortedLeftListFuture = executorService.submit(
                new CallableMergeSort(leftList, executorService));
        Future<List<Integer>> sortedRightListFuture = executorService.submit(
                new CallableMergeSort(rightList, executorService));

        // Sort both lists independently - on threads.
        List<Integer> sortedLeftList = sortedLeftListFuture.get();
        List<Integer> sortedRightList = sortedRightListFuture.get();

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
