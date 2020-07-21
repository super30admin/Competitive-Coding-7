class Solution:
    
    """
    
        Name : Shahreen Shahjahan Psyche
        Time : O(MNlog(MN-K)) [Where M and N is the dimension of the matrix]
        Space: O(MN - K) [The Heap Size]
    
    """
            
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        # edge case
        if not matrix:
            return float('inf')
        
        import heapq
        
        track = []
        N = len(matrix) * len(matrix[0])
        max_val = float('-inf')
        
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                heapq.heappush(track, matrix[i][j])
                if len(track) > N - k:
                    val = heapq.heappop(track)
                    max_val = max(val, max_val)
        return max_val
