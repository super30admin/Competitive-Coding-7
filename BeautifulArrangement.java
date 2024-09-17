// Time Complexity : O(k) where k is the number of valid isBeuatiful combinations
// Space Complexity: O(N) array to maintain N elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Step1: form the array
Step2: Recursion and backtracking. when ever a valid combination (isbeautiful) is found only then continue RnBt
increase count whenever valid
*/
public class BeautifulArrangement {
    int count=0;
    public int countArrangement(int n) {
        if(n==0) return 0;
        int[] nums=new int[n];
        for(int i=1;i<=n;i++){
            nums[i-1]=i;
        }

        helper(nums, new ArrayList<>());

        return count;
    }

    private void helper(int nums[], ArrayList<Integer> path){
        if(path.size()==nums.length) count++;

        for(int i=0;i<nums.length;i++){
            if(path.contains(nums[i])) continue;
            path.add(nums[i]);
            if(isBeautiful(path)){
                helper(nums,path);
            }
            path.remove(path.size()-1);
        }
    }

    private boolean isBeautiful(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            if(!(path.get(i)%(i+1)==0 || (i+1)%path.get(i)==0)) return false;
        }
        return true;
    }
}
