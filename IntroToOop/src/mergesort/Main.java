package mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = new ArrayList<>(List.of(3, 4, 1, 6, 5, 2));

//        SimpleMergeSort simpleMergeSort = new SimpleMergeSort(list);
//
//        List<Integer> sorted = simpleMergeSort.call();
//
//        System.out.println(sorted);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        CallableMergeSort callableMergeSort = new CallableMergeSort(list, executorService);

        Future<List<Integer>> futureSorted = executorService.submit(callableMergeSort);

        System.out.println(futureSorted.get());

        executorService.shutdown();

    }
}
