class Solution:
    def evalRPN(self, tokens: list[str]) -> int:
        # Pre-allocate array to avoid reallocation/resizing overhead
        stack = [0] * len(tokens)
        top = -1

        for token in tokens:
            if token == "+":
                stack[top - 1] += stack[top]
                top -= 1
            elif token == "-":
                stack[top - 1] -= stack[top]
                top -= 1
            elif token == "*":
                stack[top - 1] *= stack[top]
                top -= 1
            elif token == "/":
                # Integer division truncating toward zero
                stack[top - 1] = int(stack[top - 1] / stack[top])
                top -= 1
            else:
                top += 1
                stack[top] = int(token)

        return stack[0]
