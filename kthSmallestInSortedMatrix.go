// Time Complexity : O(n2logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
set low as 1st and high as last element
while low<high set mid as middle value
get count using matrix and mid
if count < k set low to mid+1 else set high to mid
return low

in get count
set j to length of matrix -1
for each row check if particular column value is more than mid if so reduce j
once done with row add c+=j+1
return c
*/
package main

import "fmt"

func kthSmallest(matrix [][]int, k int) int {
	n := len(matrix)
	low := matrix[0][0]
	high := matrix[n-1][n-1]
	for low < high {
		mid := low + (high - low)/2
		c := getCount(matrix, mid)
		if c < k {
			low = mid + 1
		} else {
			high = mid
		}
	}
	return low
}

func getCount(m [][]int, mid int) int {
	c := 0
	j := len(m) - 1
	for i:=0;i<len(m);i++ {
		for j>=0 && m[i][j] > mid {
			j--
		}
		c += j + 1
	}
	return c
}

func MainKthSmallest() {
	fmt.Println(kthSmallest([][]int{{ 1,  5,  9}, {10, 11, 13}, {12, 13, 15}}, 8))
}
