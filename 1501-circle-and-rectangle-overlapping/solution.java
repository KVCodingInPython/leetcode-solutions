class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {

        // d^2 <= r^2, where d is the distance between the minimum distance along x between a corner of the rectangle and y
        long dx = 0;
        long dy = 0;
        if (xCenter < x1 ) {
            dx = x1 - xCenter;
        }
        else if (xCenter > x2) {
            dx = xCenter - x2;
        }
        
        if (yCenter < y1) {
            dy = y1 - yCenter;
        } 
        else if (yCenter > y2) {
            dy = yCenter - y2;
        }

        if ((dx * dx) + (dy * dy) <= radius * radius) {
            return true;
        }
        return false;
    } 
}

