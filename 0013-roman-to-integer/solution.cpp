#include <iostream>
#include <string>
#include <stack>
using std::cout;
using std::endl;
using std::cin;
class Solution {
public:

    int NumeralLookUpTable(char Numeral) {
        const int NumeralSymbolTable[7] = {1, 5, 10, 50, 100, 500, 1000};

        for (int i = 0; i < 7; i++) {
            if (Numeral == 'I') {
                return 1;
            }
            else if (Numeral == 'V') {
                return 5;
            }
            else if (Numeral == 'X') {
                return 10;
            }
            else if (Numeral == 'L') {
                return 50;
            }
            else if (Numeral == 'C') {
                return 100;
            }
            else if (Numeral == 'D') {
                return 500;
            }
            else if (Numeral == 'M') {
                return 1000;
            }
        }


        return 1;
    } 
    int romanToInt(string s) {
        std::stack<char> NumeralSymbols;

        for (int i = 0; i < s.size(); i++) {
            NumeralSymbols.push(s[i]);
        }

        int sum = 0;

        while (!NumeralSymbols.empty()) {
            char NumeralSymbol_1 = NumeralSymbols.top();
            NumeralSymbols.pop();
            if (!NumeralSymbols.empty()) {
                char NumeralSymbol_2 = NumeralSymbols.top();

                if (NumeralLookUpTable(NumeralSymbol_1) > NumeralLookUpTable(NumeralSymbol_2)) {
                    sum = sum + (NumeralLookUpTable(NumeralSymbol_1) - NumeralLookUpTable(NumeralSymbol_2));
                    NumeralSymbols.pop();
                }
                else {
                    sum = sum + NumeralLookUpTable(NumeralSymbol_1);
                }
            }
            else {
                sum = sum + NumeralLookUpTable(NumeralSymbol_1);
            }

        }

        return sum;
        
    }
};
