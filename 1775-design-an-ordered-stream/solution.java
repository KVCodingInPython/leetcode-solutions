class OrderedStream {

    private String[] stream;
    private int ptr;

    public OrderedStream(int n) {
        this.stream = new String[n + 1];
        this.ptr = 1;
        
    }
    
    public List<String> insert(int idKey, String value) {
        stream[idKey] = value;

        List<String> result = new ArrayList<>();

        // Collect contiguous strings starting from ptr as long as values exist
        while (ptr < stream.length && stream[ptr] != null) {
            result.add(stream[ptr]);
            ptr++;
        }
        return result;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
