import java.util.PriorityQueue;

public class SortNearlySortedArray {
    public static int[] func(int arr[],int k){
        int index=0;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        for (int i = 0; i <arr.length; i++) {
            minHeap.add(arr[i]);
            if(minHeap.size()>k){
                arr[index]=minHeap.poll();
                index++;
            }
        }

        while (index< arr.length){
            arr[index]=minHeap.poll();
            index++;
        }

        return arr;
    }

    public static void print(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[]={6,5,3,2,8,10,9};
        print(func(arr,3));

    }
}
