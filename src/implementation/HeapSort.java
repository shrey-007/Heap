package implementation;

//it uses build heap(O(n))

//it uses maxHeapify(O(logn)) but with slight updation, generally maxheapify mai apan i de dete hai ki i se poora neeche
//tak heap bana do, but yaha i and n denge jisme i(jo ki uper hai) se n tak(neeche h) heapify krdo



public class HeapSort {
    public void heapSort(int arr[]) {
        int n = arr.length;

        // Build maxHeap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);


        // One by one extract an element from heap
        //i points to the index jaha sahi element rakhna hai
        //since max heap mai first element sabse bada hoga toh use last mai rakhege toh isliye i last mai hai. and temp points to the peek of maxheap
        //fir jab max element last position pr rakh denge toh heap bigad jaaega toh heapify call krege but 0 to i mai kiuki i ke baad vaale sahi positions pr hai toh uske heapify mai kuch mt krna
        //fir i--
        //but temp will still point to 0. kikui current max element 0 pr hi milega but uski sahi place kya hai (i) vo change hoti rhegi
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To mxheapify a subtree rooted with node i which is an index in arr[].Isme n apan paas kr rhe hai.generally n
    //paas nhi krte coz n=arr.length hota hai coz apan i se poora neeche tak heapify krte hai lekin isme poora neeche
    //tak nhi krege n tak hi karege
    void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    // A utility function to print array of size n
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.heapSort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}

