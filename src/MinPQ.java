import java.util.Arrays;

public class MinPQ {
    private int[] heap;
    private int size;
    private int capacity;

    public MinPQ() {
        capacity = 50;
        heap = new int[capacity];
        size = 0;
    }
    public MinPQ(int c) {
        capacity = c;
        heap = new int[capacity];
        size = 0;
    }

    private void resize(int capacity) {
        int[] newHeap = new int[capacity];
        System.arraycopy(heap, 0, newHeap, 0, size);
        heap = newHeap;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {
        return 2 * i;
    }

    private int right(int i) {
        return 2 * i + 1;
    }

    private void heapifyUP(int i) {
        if (i == 0) {
            return;
        }

        if (heap[i] > heap[parent(i)]) {
            return;
        }

        swap(i, parent(i));
        heapifyUP(parent(i));
    }

    private void heapifyDown(int i) {
        if (left(i) >= size) {
            return;
        }

        if (heap[i] < heap[left(i)] && heap[i] < heap[right(i)]) {
            return;
        }

        if (heap[left(i)] < heap[right(i)]) {
            swap(i, left(i));
            heapifyDown(left(i));
        } else {
            swap(i, right(i));
            heapifyDown(right(i));
        }
    }

    public int pop() {
        int res = heap[0];
        heap[0] = heap[size--];
        heapifyDown(0);
        return res;
    }

    public void insert(int item) {
        if (size == capacity) {
            resize(capacity * 2);
        }

        heap[size] = item;
        size++;
        heapifyUP(size - 1);
    }

    public int delMin() {
        int top = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return top;
    }

    public int min() {
        return heap[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }

    public static void main(String[] args) {
        MinPQ minPQ = new MinPQ();
        minPQ.insert(1);
        minPQ.insert(3);
        minPQ.insert(4);
        minPQ.insert(5);
        System.out.println(minPQ);
        minPQ.insert(2);
        System.out.println(minPQ);
    }
}
