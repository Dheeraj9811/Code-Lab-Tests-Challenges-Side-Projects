import java.util.PriorityQueue;

public class ArrayReductionCost {
    public static double reduceArray(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int num : arr) {
            minHeap.add(num);
            maxHeap.add(num);
        }

        double totalCost = 0;
        int n = arr.length;
        int count = 0;
        while (count <n-1) {
            int min = minHeap.remove();
            int max = maxHeap.remove();

            double cost = Math.ceil((double) (min + max) / (max - min + 1));
            totalCost += cost;

            if (!minHeap.isEmpty()) {
                minHeap.add(min + max);
                maxHeap.add(min + max);
            }
            count++;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,2,1,9,6};
        System.out.println("Total cost: " + reduceArray(arr));
    }
}