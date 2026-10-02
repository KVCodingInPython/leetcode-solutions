class Solution {
    List s = new ArrayList<>();

    public void recursive(int open, int close, String output) {
        if (open == 0 && close == 0) {
            s.add(output);
            return;
        }

        if (open != 0) {
            String output1 = output + "(";
            recursive(open - 1, close, output1);
        }

        if (open < close) {
            String output2 = output + ")";
            recursive(open, close - 1, output2);
        }
        return;
    }
    public List<String> generateParenthesis(int n) {
        int open = n;
        int close = n;
        String output = "";
        recursive(open, close, output);
        return s;
    }
}
