import java.util.ArrayList;
import java.util.PriorityQueue;

//given an array and k. Return list of k largest element in array
public class KLargestElementsInArray {
    public static ArrayList<Integer> func(int arr[], int k){
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        ArrayList<Integer> ans=new ArrayList<>(minHeap);
        return ans;
    }


    public static void main(String[] args) {
        int arr[]={7,10,4,3,20,15};
        System.out.println(func(arr,3));
    }
}
