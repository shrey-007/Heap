package implementation;

import java.util.Arrays;

public class Heap {
    private int[] heap;
    private int size;
    private int maxSize;

    // Constructor
    public Heap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[this.maxSize + 1];
        heap[0] = Integer.MAX_VALUE;
    }

    // Helper methods
    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return 2 * pos;
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        return pos >= (size / 2) && pos <= size;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    // Heapify(it is same as deletion so it will take logn)
    private void maxHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
                if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }

    // Insertion(logn)
    public void insert(int element) {
        if (size >= maxSize) {
            return;
        }
        heap[++size] = element;
        int currentIndex = size;

        while (heap[currentIndex] > heap[parent(currentIndex)]) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }

    }

    // Print the heap
    public void print() {
        // point is , you don't always need to create the function to print array just use Arrays.toString function(arr)
        // and print the string
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }

    // Remove and return the max element from the heap(logn)
    public int remove() {
        int popped = heap[1];
        heap[1] = heap[size--];
        //remove function is same as maxHeapify
        maxHeapify(1);
        return popped;
    }

    // Build a max heap from an array of elements

    //    O(n)
    public void buildHeap(int[] arr) {
        size = arr.length;

        //jo array paas kiya hai usko heap ke array ka attribute banana hai
        heap = Arrays.copyOf(arr, maxSize + 1);

        for (int i = size / 2; i >= 1; i--) {
            maxHeapify(i);
        }

    }

    public static void main(String[] args) {
        Heap maxHeap = new Heap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        System.out.println("Max-Heap:");
        maxHeap.print();

        System.out.println("The max val is " + maxHeap.remove());
    }
}

