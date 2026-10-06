class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int count0 = 0;
        int count1 = 0;
        int students_size = students.length;
        int sandwiches_size = sandwiches.length;

        for (int i = 0; i < students_size; i++) {
            if (students[i] == 0) {
                count0++;
            }
            else {
                count1++;
            }
        }

        for (int i = 0; i < sandwiches_size; i++) {
            if (sandwiches[i] == 0 && count0 > 0) {
                count0--;
            }
            else if (sandwiches[i] == 1 && count1 > 0) {
                count1--;
            }
            else {
                break;
            }
        }

        return count0 + count1;
    }
}
