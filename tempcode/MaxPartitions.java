import java.util.*;

public class MaxPartitions {
    public static List<Integer> maxPartition(int[] arr) {
        List<Integer> maxPartition = new ArrayList<>();
        maxPartitionHelper(arr, 0, new ArrayList<>(), maxPartition);
        return maxPartition;
    }

    private static void maxPartitionHelper(int[] arr, int index, List<Integer> currentPartition, List<Integer> maxPartition) {
        if (index >= arr.length) {
            
            return;
        }

        // Case 1: Include the current element in the current partition
        int ans = 0;
        ans = 1+
        maxPartitionHelper(arr, index + 1, maxPartition);
        currentPartition.remove(currentPartition.size() - 1);

        // Case 2: Start a new partition from the current element
        if (currentPartition.isEmpty() || arr[index] < currentPartition.get(currentPartition.size() - 1)) {
            maxPartitionHelper(arr, index + 1, new ArrayList<>(Arrays.asList(arr[index])), maxPartition);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,3,6,5,3,4,7,1};
        int maxPartition = maxPartition(arr);
        System.out.println("Max Partition:");
        System.out.println(maxPartition);
    }
}
