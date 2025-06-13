# Competitive-Coding-7

Please submit the interview problems posted in slack channel here. The problems and statements are intentionally not shown here so that students are not able to see them in advance 

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

## Problem 2 - Flatten Binary Tree to Linked List

# Base case : when the root is NULL or the left and right child is NULL go to the root
# Logic : Iterate over the tree, if the left child is not NULL iterate over the leftmost child of the 
# tree and store the left child in temp variable and update the right child.
# Update the left child as NULL and while the right child is not NULL we update the root and change the 
# rightmost value with the temp variable
# Call the flatten function for the right child of the tree
# Return the binary tree

