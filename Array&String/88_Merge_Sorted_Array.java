class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int point = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[point] = nums1[i];
                i--;
                point--;
            }else{
                nums1[point] = nums2[j];
                j--;
                point--;
            }
        }
        while(j >= 0){
            nums1[point] = nums2[j];
            point--;
            j--;
        }
    }
}