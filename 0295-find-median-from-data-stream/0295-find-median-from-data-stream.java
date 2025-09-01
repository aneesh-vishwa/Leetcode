class MedianFinder {
    private PriorityQueue<Integer> maxheap;
    private PriorityQueue<Integer> minheap;
    public MedianFinder() {
        maxheap = new PriorityQueue<>((a,b) -> b - a);
        minheap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Always add to maxHeap first
        maxheap.offer(num);
        
        // Move the largest element from maxHeap to minHeap
        minheap.offer(maxheap.poll());
        
        // Balance the heaps - maxHeap should have equal or one more element
        if (maxheap.size() < minheap.size()) {
            maxheap.offer(minheap.poll());
        }
    }
    
    public double findMedian() {
        if (maxheap.size() > minheap.size()) {
            // Odd number of elements - median is top of maxHeap
            return maxheap.peek();
        } else {
            // Even number of elements - median is average of both tops
            return (maxheap.peek() + minheap.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */