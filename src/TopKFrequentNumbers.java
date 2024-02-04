import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//given an array and k
//return k elements who have maximum frequencies
class Pair2 implements Comparable<Pair2>{
    int value;
    int frequency;

    public Pair2(int value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Pair2 o) {
        return this.frequency-o.frequency;
    }
}
public class TopKFrequentNumbers {
    public static ArrayList<Integer> func(int arr[],int k){
        //create a hashmap to store frequency of each element
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(hashMap.containsKey(arr[i])){hashMap.put(arr[i], hashMap.get(arr[i])+1);}
            else{hashMap.put(arr[i],1);}
        }
        //hashmap contains
        //1->3
        //3->1
        //2->2
        //4->1


        //we have to remove elements with less frequency thats why we used minHeap
        PriorityQueue<Pair2> minHeap=new PriorityQueue<>();

        //now traverse the hashmap and do the same thing as earlier
        for (Map.Entry<Integer,Integer> entry: hashMap.entrySet()){
            Pair2 pair2=new Pair2(entry.getKey(),entry.getValue());
            minHeap.add(pair2);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        //so the elements in the hashmap are answers
        ArrayList<Integer> arrayList=new ArrayList<>();
        while(minHeap.size()>0){
            arrayList.add(minHeap.poll().value);
        }
        return arrayList;
    }
    public static void main(String[] args) {
        int arr[]={1,1,1,3,2,2,4};
        System.out.println(func(arr,3));

    }
}
