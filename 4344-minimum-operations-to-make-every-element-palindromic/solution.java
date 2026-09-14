class Solution {
            private static final List<Integer> evenPalindromes = new ArrayList<>();
            private static final List<Integer> oddPalindromes = new ArrayList<>();
            // O(N) or O(N logN)
            static {
                for (int i = 0; i < 100000; i++) {
                    String s = Integer.toString(i);
                    StringBuilder rev = new StringBuilder(s).reverse();

                    // Case 1: Odd length palindrome (e.g., 123 -> 12321)
                    long pal1 = Long.parseLong(s + rev.substring(1));
                    if (pal1 > 0 && pal1 <= 2_000_000_000L) {
                        int p = (int) pal1;
                        if (p % 2 == 0)  {
                            evenPalindromes.add(p);
                        }
                        else {
                            oddPalindromes.add(p);
                        }
                    }

                    // Case 2: Even length palindrome (e.g., 123 -> 123321)
                    long pal2 = Long.parseLong(s + rev);
                    if (pal2 > 0 && pal2 <= 2_000_000_000L) {
                        int p = (int) pal2;
                        if (p % 2 == 0) {
                            evenPalindromes.add(p);
                        }
                        else {
                            oddPalindromes.add(p);
                        }
                    }
                }
                // Binary search so first sort even and odd palindrome sets
                Collections.sort(evenPalindromes);
                Collections.sort(oddPalindromes);
            }

        public long minOperations(int[] nums) {
            long operations = 0;
            for (int num : nums) {
                operations += toPalindrome(num);
            }
            return operations;
        }

        public long toPalindrome(int num) {
            List<Integer> targetList = (num % 2 == 0) ? evenPalindromes : oddPalindromes;

            int index = Collections.binarySearch(targetList, num);
            // Base case: Number is already a palindrome
            if (index >= 0) {
                return 0;
            }

            // Calculate insertion point if not found
            int insertionPoint = -index - 1;
            long minDiff = Long.MAX_VALUE;

            // Check the closest palindrome on the right side
            if (insertionPoint < targetList.size()) {
                minDiff = Math.min(minDiff, (long) targetList.get(insertionPoint) - num);
            }

            // Check the closest palindrome on the left side
            if (insertionPoint > 0) {
                minDiff = Math.min(minDiff, (long) num - targetList.get(insertionPoint - 1));
            }

            // Each operation changes the value by 2, so operations = difference / 2
            return minDiff / 2;
        }
    }

