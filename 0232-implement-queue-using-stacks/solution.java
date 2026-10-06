class MyQueue {
    Deque<Integer> front;
    Deque<Integer> back;

    public MyQueue() {
        front = new ArrayDeque<>();
        back = new ArrayDeque<>();
    }
    
    public void push(int x) {
        back.push(x);
        return;
    }
    
    public int pop() {
        transfer();
        return front.pop();
        
    }
    
    public int peek() {
        transfer();
        return front.peek();
        
    }
    
    public boolean empty() {
        return front.isEmpty() && back.isEmpty();
        
    }

    private void transfer() {
        if (front.isEmpty()) {
            while (!(back.isEmpty())) {
                front.push(back.pop());
            }
        }
        return;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
