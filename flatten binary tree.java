//Timecomplexity:- O(2^n).
//Spacecomplexity:-O(N);
//Did it run on leetcode?:- yes.
//What problems did you face while coding?:- got wrong answers initially.
//concept with code:- initially every element is preorderly traversed and stored in a list. from list constructing right tree.





class Solution {
    List<Integer> cache=new ArrayList<>();
    private void preorder(TreeNode root){
        if(root==null){
            return;
        }
        cache.add(root.val);
        preorder(root.left);
        preorder(root.right);
        
    }
    public void flatten(TreeNode root) {
        preorder(root);
        TreeNode temp=root;
        int index=1;
        while(index<cache.size()){
            temp.right=new TreeNode(cache.get(index));
            temp.left=null;
            temp=temp.right;
            
            index++;
           
        }
        
    
    }
}