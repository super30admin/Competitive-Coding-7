# Time: O(n) 
# Space: O(n) for  tree

class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root : return

        st = []
        st.append(root)

        while st:
            curr = st.pop()             # top element

            if curr.right:              # push rigt to stack
                st.append(curr.right)
            
            if curr.left:               # push left to stack
                st.append(curr.left)

            if st:
                curr.right = st[-1]     # set right

            curr.left = None            # set left
