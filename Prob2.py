from Queue import PriorityQueue
class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        #bin search
        def findMinEl(mid, matrix,smallNum,largeNum):
            noOfEl = 0
            r,c = 0, len(matrix[0])-1
            while r<len(matrix)  and c>=0:
                if matrix[r][c]>mid:
                    largeNum = min(largeNum,matrix[r][c])
                    c-=1
                else:
                    smallNum = max(smallNum,matrix[r][c])
                    noOfEl += c + 1
                    r+=1
            return noOfEl,smallNum,largeNum
        start = matrix[0][0]
        end = matrix[-1][-1]
        while start< end:
            mid = start+(end-start)/2
            smallNum, largeNum = matrix[0][0], matrix[-1][-1]
            noOfEl,smallNum,largeNum = findMinEl(mid,matrix,smallNum,largeNum)
            if noOfEl==k:
                return smallNum
            elif noOfEl <k:
                start = largeNum
            else:
                end = smallNum
        
        return start
            
        
        #priority queue
        # q = PriorityQueue()
        # for i in xrange(len(matrix)):
        #     for j in xrange(len(matrix[0])):
        #         q.put(-1*matrix[i][j])
        #         if q.qsize()>k:
        #             q.get()
        # return q.get()*-1
                
