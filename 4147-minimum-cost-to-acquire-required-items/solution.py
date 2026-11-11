class Solution:
    def minimumCost(self, cost1: int, cost2: int, costBoth: int, need1: int, need2: int) -> int:
        min_cost = 0
        if cost1 + cost2 <= costBoth:
            min_cost = cost1 * need1 + cost2 * need2
        
        else:
            cnt_3 = min(need1, need2)
            min_cost = cnt_3 * costBoth

            need1 -= cnt_3
            need2 -= cnt_3

            if need1 > 0:
                min_cost += need1 * min(cost1, costBoth)
            
            elif need2 > 0:
                min_cost += need2 * min(cost2, costBoth)
        
        return min_cost

        
