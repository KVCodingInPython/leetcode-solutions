#include <string>
#include <iostream>
using std::cout;
using std::cin;
using std::endl;

class Solution {
public:
    bool isPalindrome(int x) {
        string y = to_string(x);
        int countLetterPairs = 0;
        int letterPairsNeeded = u_int(y.size() / 2);

        int mid = u_int(y.size() / 2);
        

        for (int i = 0; i < mid; i++ ) {

            if (y[i] == y[y.size() - 1 - i]) {
                countLetterPairs += 1;


            }

        }

        if (countLetterPairs == letterPairsNeeded) {
            return true;
        }

        return false;


        
    }
};
