'''
// Time Complexity :
# Problem 1 - O(n) as we iterate over the whole array
# Problem 2 - O(n) as we traverse the entire tree recursively
// Space Complexity :
# Problem 1 - O(1) ~ constant for hashmap creation using the target string
# Problem 2 - O(1) ~ amoretized, no extra space as we change the input
// Did this code successfully run on Leetcode :
# Yes the code ran successfully.

// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
'''
## Problem 1 - Minimum Window Substring

# Iterate over the target array and store elements in a hashmap
# Initialize a match variable to track when the target string elements match the source and a minimum 
# length variable to get the min string from the source character array
# Initialize two pointers and until they cross each other or the second pointer is at the end of the 
# source string iterate the entire string
# If the match equals the map length update the temp variable with the min length value and result 
# string with the characters between the two pointers
# Increment the first pointer, if the character from the target is being removed update the map frequency
# by 1 and decrement the match.
# Decrement the second pointer, if the character from the target is being added decrement the map 
# frequency and increment the match.
# Return the result string

class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        if len(s) == 0 or len(t) == 0 or len(s) < len(t):
            return ""
        
        map_1 = {}
        for i in t:
            if i not in map_1:
                map_1[i] = 0
            map_1[i] += 1

        match1 = 0
        i = 0; j = 0
        temp = 999999
        result = ""

        while i <= j and i < len(s):
            if match1 == len(map_1):
                temp = min(temp, j-i)
                if temp == j-i:
                    result = s[i:j]
            if (i != j and match1 == len(map_1) ) or j == len(s):
                if s[i] in map_1:
                    if map_1[s[i]] == 0:
                        match1 -= 1
                    map_1[s[i]] += 1
                i += 1
            else:
                if s[j] in map_1:
                    if map_1[s[j]] == 1:
                        match1 += 1
                    map_1[s[j]] -= 1
                j += 1
        return result

## Problem 2 - Flatten Binary Tree to Linked List

# Base case : when the root is NULL or the left and right child is NULL go to the root
# Logic : Iterate over the tree, if the left child is not NULL iterate over the leftmost child of the 
# tree and store the left child in temp variable and update the right child.
# Update the left child as NULL and while the right child is not NULL we update the root and change the 
# rightmost value with the temp variable
# Call the flatten function for the right child of the tree
# Return the binary tree

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def flatten(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: None Do not return anything, modify root in-place instead.
        """
        ## base
        if root == None or root.left == None and root.right == None: 
            return

        ## recursive
        if root.left != None:
            self.flatten(root.left)
            temp = root.right
            root.right = root.left
            root.left = None
            while root.right != None: 
                root = root.right
            root.right = temp
            
        self.flatten(root.right)