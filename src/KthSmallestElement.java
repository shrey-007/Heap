import java.util.Comparator;
import java.util.PriorityQueue;

//given an array and k. return kth smallest element
public class KthSmallestElement {
    //method1=you can simply sort an array in nlogn and return arr[k-1]

    //method2=use max heap
    static int func(int arr[],int k){

        //create max heap
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            //add current element
            maxHeap.add(arr[i]);

            //if size of heap exceeds k then remove element
            //basically the idea is ki suppose k=5.
            //toh jab tak maxheap ka size <=5 hai tab tak usme array ka max element store hoga top pr.
            //[3,3,4,67,76]
            //ab jab i=5 hoga toh 89 insert hoga
            //[3,3,4,67,76,89] and since apan 5th smallest element chaiye hai and abhi heap ko dekh kr lag rha hai ki 89
            // pakka 5th smallest element toh nhi hai, kiuki abhi poora array bhi iterate nhi hua still it is 6th smallest,
            //agar in future 3 se bhi chota element aaya toh 89 7th smallest bn jaaega toh 89 pakka answer nhi hai toh use
            //nikaal do.
            //[3,3,4,67,76]. ab iske hisaab se 76 is 5th smallest but abhi confirm nhi hai ki vahi ans hai, kiuki agar 76
            //se koi bada aaya toh voh ans pakka nhi hoga but agar 3 se koi chota aaya toh 76 6th smaalest bn jaaega
            if(maxHeap.size()>k){maxHeap.poll();}
        }
        return maxHeap.peek();

    }
    //method3=use quick select for most efficient algorithm
    public static void main(String[] args) {
        int arr[]={3,4,67,3,76,89,43,21,55,99,35,77};
        System.out.println(func(arr,5));

    }
}
