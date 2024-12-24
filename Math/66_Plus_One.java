class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        digits[n - 1]++;
        if(digits[n - 1] <= 9) return digits;
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; i--){
            int currValue = digits[i] + carry;
            if(currValue <= 9){
                digits[i] = currValue;
                carry = 0;
                break;
            }
            int val = currValue % 10;
            digits[i] = val;
            carry = 1;
        }
        if(carry == 1){
            int[] res = new int[n + 1];
            res[0] = carry;
            for(int i = 1; i < res.length; i++){
                res[i] = digits[i - 1];
            }
            return res;
        }
        return digits;
    }
}

