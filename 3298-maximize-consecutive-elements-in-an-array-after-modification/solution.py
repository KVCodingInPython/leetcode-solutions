class Solution:
    def maxSelectedElements(self, nums: List[int]) -> int:
        nums.sort()
        chain_lengths = {}
        longest = 0

        for x in nums:
            # Chain where x remains unchanged
            unchanged = chain_lengths.get(x - 1, 0) + 1

            # Chain where x is incremented to x + 1
            incremented = chain_lengths.get(x, 0) + 1

            chain_lengths[x] = max(chain_lengths.get(x, 0), unchanged)
            chain_lengths[x + 1] = max(chain_lengths.get(x + 1, 0), incremented)

            longest = max(longest, chain_lengths[x], chain_lengths[x + 1])

        return longest
