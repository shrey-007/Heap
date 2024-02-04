import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//given a array. and a number k , and a number x which is present in array.
//return list of k numbers present in array which are closest to x.
//concept is very easy koi 32,34 mai se 7 ke jyaada close kon hai obviously 32.And ye pata krne ke liye apan dono mai se
//7 subtract kr do toh 25 and 27 banege. jo magnitude wise jitna chota hoga vo utna hi close hoga.
//example 5,6,8 toh 7 subtract kro toh -2,-1,1 banega ab inka modulus lo. 2,1,1 means ki 6,8 closest hai and fir 5 aaega
//but subtract krke mod loge toh tum uski original value kho doge toh ek class banai jo ki original value and differnce
//store krti hai and compare differce ke basis pr krti hai coz apan ne 5,6,8 ko compare nhi kra 2,1,1 ko kra and fir bataya
//ki kon close hai . toh compare differece ke basis pr hoge.
//toh k closest number= k smallest element in array of a[i]=arr[i]-x


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



//so overall this question is similar to k smallest elements in array
//bas isme elements of array arr[i] nhi hai arr[i]-x hai.
public class KClosestNumber {
    public static ArrayList<Integer> func(int arr[],int x, int k){
        //heap mai apan pair ko store krege. Toh apan ko comparator dena padega. By defaoult min heap bnti hai , max heap
        //ke liye reverse order dena pdta hai.

        PriorityQueue<Pair> maxHeap=new PriorityQueue<>(Comparator.reverseOrder());

        //traverse the whole array
        for (int i = 0; i < arr.length; i++) {
            //store current element with its differnce
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
