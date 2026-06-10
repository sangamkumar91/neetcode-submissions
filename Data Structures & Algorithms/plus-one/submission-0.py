class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        carry = 1
        digits.reverse()
        for i,d in enumerate(digits):
            d = d + carry
            digits[i] = d%10
            carry = d//10
        if carry != 0:
            digits.append(carry)
        digits.reverse()
        return digits
        