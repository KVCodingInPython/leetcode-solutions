class Solution {
public:
    int minAddToMakeValid(string s) {
        int min_moves = 0;
        int n = s.size();
        std::stack<char> stack;

        for (int i = 0; i < n; i++) {
            char ch = s.at(i);
            if (ch == '(') {
                stack.push(ch);
            }
            else {
                if (stack.size() != 0) {
                    stack.pop();
                }
                else {
                    min_moves += 1;
                }
            }
        }
        return min_moves + stack.size();
    }
};
