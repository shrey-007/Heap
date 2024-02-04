import java.util.PriorityQueue;

//given a array and k.har element array ka apni sahi position se either k unit left hai or k unit right hai.
//sahi position of an element is position of element jab array sorted ho.
public class SortNearlySortedArray {
    public static int[] func(int arr[],int k){
        //a pointer to store a element at its correct position
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
    //explaination= neeche vaale test ko example mai le rha hu
    //since minheap kuch esa banega [3,5,6] after 2 iterations
    //fir [2,3,5,6] hoga.Index points to the index jaha sahhi value place krni hai. index is currently at 0 and 0 pr jo
    //element aana chaiye vo 0,1,2,3 in mai se kisi ek index mai hoga. Also 0,1,2,3 index vaale elemennts minheap mai
    //hai.means 0th index pr jo bhi element hona chaiye vo abhi min heap ke under hai.and 0th index pr sabse chota element
    //aaega and minheap ko poll krege tab bhi sabse chota nikalega, isliye min heap use kra. toh 0th index pr 2 aa gya
    //fir index=1 ho gya which means ki 0th index pr sahi value dal gyi ab 1st index pr sahi value daalo and minheap
    //is [3,5,6,8] toh 1st index pr 3 aaega and so on

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
