class MedianFinder {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a , b) -> {
        return b - a;
    });
    PriorityQueue<Integer> minHeap = new PriorityQueue();
    int size = 0;

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        size++;
        maxHeap.offer(num);
        while (!minHeap.isEmpty() && !maxHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.offer(maxHeap.poll());
        }
        while (Math.abs(maxHeap.size() - minHeap.size()) > 1 || maxHeap.size() < minHeap.size()) {
            if (maxHeap.size() < minHeap.size())
                maxHeap.offer(minHeap.poll());
            else
                minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (size % 2 == 0) {
            return (minHeap.peek() + maxHeap.peek())/2.0;
        }
        return maxHeap.peek();
    }
}
// [0,1,2,3] [6,5,4]