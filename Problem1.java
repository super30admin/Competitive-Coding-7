class Solution {
    int result;
    public int countArrangement(int n) {
        result = 0;
        List<Integer> nums = new ArrayList<>();
        for(int i=1;i<=n;i++)
            nums.add(i);

        helper(nums,0);
        return result;

    }
    public void helper(List<Integer> nums, int size){
        if(nums.size()==0)
            result++;
        else{
            for(int i=0;i<nums.size();i++){
                int temp = nums.get(0);
                nums.remove(0);
                if(temp%(size+1) == 0 || (size + 1)%temp == 0)
                    helper(nums, size+1);
                nums.add(temp);
            }
        }
    }
}