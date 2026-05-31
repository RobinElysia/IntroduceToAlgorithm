package day61_90.day77;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class MedianFinder {
    // 大根堆：存储较小的一半，堆顶为这部分的最大值
    private MaxHeap maxHeap;
    // 小根堆：存储较大的一半，堆顶为这部分的最小值
    private MinHeap minHeap;

    public MedianFinder() {
        maxHeap = new MaxHeap();
        minHeap = new MinHeap();
    }

    public void addNum(int num) {
        // 每次先放入大根堆，再取堆顶放入小根堆，保证顺序
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());

        // 调整平衡：大根堆的元素个数 >= 小根堆的元素个数
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();           // 奇数个，中位数在大根堆堆顶
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0; // 偶数个，取平均
        }
    }

    // ---------- 手写大根堆 ----------
    private class MaxHeap {
        private int[] heap;
        private int size;

        public MaxHeap() {
            heap = new int[16]; // 初始容量
            size = 0;
        }

        public void add(int val) {
            if (size == heap.length) {
                resize();
            }
            heap[size] = val;
            siftUp(size);
            size++;
        }

        public int poll() {
            if (size == 0) throw new RuntimeException("Heap is empty");
            int top = heap[0];
            heap[0] = heap[size - 1];
            size--;
            siftDown(0);
            return top;
        }

        public int peek() {
            if (size == 0) throw new RuntimeException("Heap is empty");
            return heap[0];
        }

        public int size() {
            return size;
        }

        private void siftUp(int index) {
            while (index > 0) {
                int parent = (index - 1) >>> 1;
                if (heap[index] <= heap[parent]) break;
                swap(index, parent);
                index = parent;
            }
        }

        private void siftDown(int index) {
            int half = size >>> 1;
            while (index < half) {
                int child = (index << 1) + 1;
                int right = child + 1;
                if (right < size && heap[right] > heap[child]) {
                    child = right; // 取左右孩子中较大的
                }
                if (heap[index] >= heap[child]) break;
                swap(index, child);
                index = child;
            }
        }

        private void swap(int i, int j) {
            int tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }

        private void resize() {
            int[] newHeap = new int[heap.length * 2];
            System.arraycopy(heap, 0, newHeap, 0, heap.length);
            heap = newHeap;
        }
    }

    // ---------- 手写小根堆 ----------
    private class MinHeap {
        private int[] heap;
        private int size;

        public MinHeap() {
            heap = new int[16];
            size = 0;
        }

        public void add(int val) {
            if (size == heap.length) {
                resize();
            }
            heap[size] = val;
            siftUp(size);
            size++;
        }

        public int poll() {
            if (size == 0) throw new RuntimeException("Heap is empty");
            int top = heap[0];
            heap[0] = heap[size - 1];
            size--;
            siftDown(0);
            return top;
        }

        public int peek() {
            if (size == 0) throw new RuntimeException("Heap is empty");
            return heap[0];
        }

        public int size() {
            return size;
        }

        private void siftUp(int index) {
            while (index > 0) {
                int parent = (index - 1) >>> 1;
                if (heap[index] >= heap[parent]) break;
                swap(index, parent);
                index = parent;
            }
        }

        private void siftDown(int index) {
            int half = size >>> 1;
            while (index < half) {
                int child = (index << 1) + 1;
                int right = child + 1;
                if (right < size && heap[right] < heap[child]) {
                    child = right; // 取左右孩子中较小的
                }
                if (heap[index] <= heap[child]) break;
                swap(index, child);
                index = child;
            }
        }

        private void swap(int i, int j) {
            int tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }

        private void resize() {
            int[] newHeap = new int[heap.length * 2];
            System.arraycopy(heap, 0, newHeap, 0, heap.length);
            heap = newHeap;
        }
    }
}