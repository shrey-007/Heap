import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>{
    int differnce;
    int value;

    public Pair(int differnce, int value) {
        this.differnce = differnce;
        this.value = value;
    }

    @Override
    public int compareTo(Pair o) {
        return this.differnce-o.differnce;
    }
}


public class KClosestNumber {
    public static ArrayList<Integer> func(int arr[],int x, int k){
        PriorityQueue<Pair> maxHeap=new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(new Pair(Math.abs(arr[i]-x),arr[i]));
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        ArrayList<Integer> arrayList=new ArrayList<>();
        while (maxHeap.size()>0){
            arrayList.add(maxHeap.poll().value);
        }
        return arrayList;
    }
    public static void main(String[] args) {
        int arr[]={5,6,7,8,9};
        System.out.println(func(arr,7,3));
    }
}
