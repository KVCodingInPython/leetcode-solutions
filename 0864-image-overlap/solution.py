import numpy as np
from scipy.signal import fftconvolve
class Solution(object):
    def largestOverlap(self, img1, img2):
        """
        :type img1: List[List[int]]
        :type img2: List[List[int]]
        :rtype: int
        """

        A = np.array(img1)
        B = np.array(img2)
        
        # 1. Reverse img2 (B[::-1, ::-1]) to turn cross-correlation into convolution
        # 2. fftconvolve auto-pads to size (2N-1, 2N-1)
        conv = fftconvolve(A, B[::-1, ::-1], mode='full')
        
        # 3. Round float outputs to nearest int and return global max
        return int(np.round(conv).max())
        
