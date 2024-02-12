class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;
        int [] ans = new int[2];
        while(start < end){
			int currTarget = numbers[start]+numbers[end];
            if(currTarget==target){
                ans[0]=start+1;
                ans[1]=end+1;
                return ans;
            }else if((currTarget>target)){
                end--;
            }else{
                start++;
            }
        }
        return ans;
    }
}