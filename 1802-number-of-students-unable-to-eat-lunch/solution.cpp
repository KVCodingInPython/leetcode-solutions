class Solution {
public:
    int countStudents(vector<int>& students, vector<int>& sandwiches) {
        int count0 = 0;
        int count1 = 0;
        int sandwiches_size = sandwiches.size();

        for (int s : students) {
            if (s == 0) count0++;
            else count1++;
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0 && count0 > 0) {
                count0--;
            } else if (sandwich == 1 && count1 > 0) {
                count1--;
            } else {
                // Top sandwich cannot be consumed by any remaining student
                break;
            }
        }

        // Remaining students are those who couldn't eat
        return count0 + count1;
    }
};
