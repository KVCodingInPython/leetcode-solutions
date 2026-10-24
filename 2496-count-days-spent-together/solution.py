class Solution(object):
    def countDaysTogether(self, arriveAlice, leaveAlice, arriveBob, leaveBob):
        """
        :type arriveAlice: str
        :type leaveAlice: str
        :type arriveBob: str
        :type leaveBob: str
        :rtype: int
        """
        # Days in each month for a non-leap year
        days_in_months = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
        
        # Helper function to convert "MM-DD" to day of the year (1-365)
        def date_to_day_number(date_str):
            month = int(date_str[:2])
            day = int(date_str[3:])
            
            # Sum the days of all previous months, then add the current day
            total_days = sum(days_in_months[:month - 1]) + day
            return total_days

        # Convert all 4 dates to day numbers
        alice_start = date_to_day_number(arriveAlice)
        alice_end = date_to_day_number(leaveAlice)
        bob_start = date_to_day_number(arriveBob)
        bob_end = date_to_day_number(leaveBob)
        
        # Find the overlap bounds
        overlap_start = max(alice_start, bob_start)
        overlap_end = min(alice_end, bob_end)
        
        # Calculate days together if an overlap exists
        if overlap_start <= overlap_end:
            return (overlap_end - overlap_start) + 1
        
        return 0
        
