bool isRectangleOverlap(int* rec1, int rec1Size, int* rec2, int rec2Size) {
    // rec1 poings to an int ()
    // check if 1st rectangle top right more left than 2nd rectangle bottom left: LEFT
    // check if 1st rectangle bottom left more right than 2nd rectangle top right: RIGHT
    // CHECK IF 1ST rectangle bottom left higher than 2nd rectangle top right: UP
    // CHECk if 1st rectangle top right lower than 2nd rectangle bottom left: DOWN

    // 1st rectangle bottom left -> top right
    // Variables for accessing indexes: rec1 array
    

    bool noOverlap = (*rec1 >= *(rec2 + 2) ||
                      *(rec1 + 1) >= *(rec2 + 3) ||
                      *(rec1 + 2) <= *(rec2) ||
                      *(rec1 + 3) <= *(rec2 + 1));
    
    if (!noOverlap) {
        return true;
    }
    return false;
}
