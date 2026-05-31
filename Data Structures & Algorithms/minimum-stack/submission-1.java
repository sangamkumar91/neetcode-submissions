class MinStack {
    int currentMin = Integer.MAX_VALUE;
    ArrayDeque<int[]> stack = new ArrayDeque();

    public MinStack() {
        
    }
    
    public void push(int val) {
        currentMin = Math.min(val, currentMin);
        stack.offerFirst(new int[] {val, currentMin});
    }
    
    public void pop() {
        stack.pollFirst();
        currentMin = stack.isEmpty() ? Integer.MAX_VALUE : stack.peekFirst()[1];
    }
    
    public int top() {
        return stack.peekFirst()[0];        
    }
    
    public int getMin() {
        return currentMin;
    }
}
