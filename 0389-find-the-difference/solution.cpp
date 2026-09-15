#include <map>
class Solution {
public:
    char findTheDifference(string s, string t) {
        map<char, int> letters_in_s;
        for (char c : s) {
            letters_in_s[c]++;
        }

        for (char c: t) {
            if (letters_in_s.find(c) == letters_in_s.end() || letters_in_s[c] == 0) {
                return c;
            }
            else  {
                letters_in_s[c]--;
            }
        }
        return ' ';

    }

};
