/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // Any linked list with length 2, cannot have any critical points
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1,-1};
        }
        // Loop through list to check for critical points, if critical point found add to critical points arr.
        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;
        int firstIndex = -1;
        int prevIndex = -1;
        int minDistance = Integer.MAX_VALUE;

        while (curr.next != null) {
            boolean localMaxima = curr.val > prev.val && curr.val > curr.next.val;
            boolean localMinima = curr.val < prev.val && curr.val < curr.next.val;

            if (localMaxima || localMinima) {
                if (firstIndex == -1) {
                    firstIndex = index; // Store first absolute critical point
                }
                else {
                    minDistance = Math.min(minDistance, index - prevIndex);
                }
                prevIndex = index;
            }
            prev = curr;
            curr = curr.next;
            index++;
        }

        if (prevIndex == firstIndex) {
            return new int[]{-1,-1};
        }
        
        int maxDistance = prevIndex - firstIndex;
        return new int[]{minDistance, maxDistance};
        
    }
}
