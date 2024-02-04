import java.util.ArrayList;
import java.util.PriorityQueue;

//given an array and k. Return list of k largest element in array
public class KLargestElementsInArray {
    public static ArrayList<Integer> func(int arr[], int k){
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        //iterat over array
        for (int i = 0; i < arr.length; i++) {
            //add current element
            minHeap.add(arr[i]);

            //if heap size is increased by k then remove the minimum element
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        //minHeap mai jo bhi small elements aaege voh nikal jaaege coz min heap hai toh min elements nikalege
        //toh at the end k minHeap mai k largest elements hoge.

        ArrayList<Integer> ans=new ArrayList<>(minHeap);
        return ans;
    }


    public static void main(String[] args) {
        int arr[]={7,10,4,3,20,15};
        System.out.println(func(arr,3));
    }
}
