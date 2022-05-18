#kth smallest in a sorted matrix
# // Time Complexity :  O(n log n) - n is the total elemts in the matrix
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

def kthSmallest( matrix, k: int) -> int:
    low=matrix[0][0]
    high=matrix[-1][-1]
    
    def smallestEqual(mid):         #find the number of elements that are smaller of equal to the current mid
        count=0
        r=0
        c=len(matrix[0])-1
        while(r<len(matrix) and c>=0):
            if(mid>=matrix[r][c]):
                count+=c+1
                r+=1
            else:
                c-=1
        return count
    
    while(high!=low):
        mid=(high+low)//2
        count = smallestEqual(mid)
        if(count<k ):                   #if the number of smaller or equal elements are less than k, then set low to mid+1
            low=mid+1
        else:
            high=mid                    #else, set high to mid
    return low
    