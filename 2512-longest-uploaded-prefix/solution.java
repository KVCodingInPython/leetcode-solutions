class LUPrefix {

    private boolean[] uploaded;
    private int longestPrefix;

    public LUPrefix(int n) {
        this.uploaded = new boolean[n + 1];
        this.longestPrefix = 0;

    }
    
    public void upload(int video) {
        uploaded[video] = true;

        while (longestPrefix + 1 < uploaded.length && uploaded[longestPrefix + 1]) {
            longestPrefix++;
        }
        return;
    }
    
    public int longest() {
        return longestPrefix;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */
