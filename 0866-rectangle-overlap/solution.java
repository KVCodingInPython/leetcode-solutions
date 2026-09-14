class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // Go through rect 2 pair coordinates and check if at least one pair matches condition return true else return false if none found or match

        // (rec2[0], rec2[1]) ; (rec2[2], rec2[3])
        // constraints for rec1:
        // x: either (rec1[0] < (rec2[0] | rec2[2]) < rec1[2]) || (rec1[2] < (rec2[0] | rec2[2]) < rec1[2])
        // && y: (rec1[1] < (rec))

        boolean noOverlap = (rec2[2] <= rec1[0] || 
                             rec1[2] <= rec2[0] ||
                             rec2[3] <= rec1[1] ||
                             rec2[1] >= rec1[3]);
        
        if (!noOverlap) {
            return true;
        }
        return false;
    }
}
