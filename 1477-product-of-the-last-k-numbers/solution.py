class ProductOfNumbers:

    def __init__(self):
        self.size = 0
        self.prod = [1]

    def add(self, num: int) -> None:
        if num == 0:
            self.size = 0
            self.prod = [1]
        else:
            self.prod.append(self.prod[self.size] * num)
            self.size += 1
        
            

        return None
    
    def getProduct(self, k: int) -> int:
        if k > self.size:
            return 0
        return self.prod[self.size] // self.prod[self.size - k]
        

        


# Your ProductOfNumbers object will be instantiated and called as such:
# obj = ProductOfNumbers()
# obj.add(num)
# param_2 = obj.getProduct(k)
