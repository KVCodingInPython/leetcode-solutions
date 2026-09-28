class Solution:
    def exclusiveTime(self, n: int, logs: list[str]) -> list[int]:
        result = [0] * n
        prev_time = 0
        # Stack for pushing and popping function IDs
        functionID = []

        for log in logs:
            func_id, call_type, timestamp = log.split(":")
            func_id = int(func_id)
            timestamp = int(timestamp)

            if call_type == "start":
                if functionID:
                    result[functionID[-1]] += timestamp - prev_time
                
                functionID.append(func_id)
                prev_time = timestamp
            else:
                result[functionID.pop()] += timestamp - prev_time + 1
                prev_time = timestamp + 1
        return result
            



        
        
        
