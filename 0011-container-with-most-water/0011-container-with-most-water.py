class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        area = 0
        i = 0
        j = len(height) - 1
        while(i < j):
            if height[i] <= height[j]:
                result = height[i] * (j - i)
                i += 1
            else:
                result = height[j] * (j - i)
                j -= 1
            if result > area:
                area = result
        return area
            