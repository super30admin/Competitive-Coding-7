/*
    Time complexity : O(P). P refers to the count or total number of valid permutations.
    Space complexity : O(n). The depth of recursion tree can go upto n.
 */
class Solution {
    int count = 0;
    public int countArrangement(int n) {
        int[] nums = new int[n + 1];
        for(int i = 1; i < nums.length; i++)
            nums[i] = i;
        createPermutations(nums, 1);
        return count;
    }

    public void createPermutations(int[] nums, int pos) {
        if(pos >= nums.length){
            count++;
            return;
        }
        for(int i = pos; i < nums.length; i++) {
            swap(nums, i, pos);
            if(nums[pos] % pos == 0 || pos % nums[pos] == 0)
                createPermutations(nums, pos + 1);
            swap(nums, i, pos);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
