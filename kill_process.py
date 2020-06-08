
#Time Complexity: O(n+m), size of pid and ppid
#Space complexity: O(n+m)
'''
Construct tree with hashmap, BFS from root kill, O(n) solution
'''
class Solution:
    def killProcess(self, pid: List[int], ppid: List[int], kill: int) -> List[int]:
        if not pid:
            return []
        if kill==0:
            return pid
        res=[]
        graph={p:[] for p in pid}
        for i in range(len(pid)):
            if ppid[i] not in graph:
                graph[ppid[i]]=[pid[i]]
            else:
                graph[ppid[i]].append(pid[i])
        
        q=collections.deque()
        q.append(kill)
        while q:
            node=q.popleft()
            res.append(node)
            if node in graph:
                for c in graph[node]:
                    q.append(c)
        return res
        


#Binary search solution, could be done better with dfs.
#Time Complexity: O(nlogn)
#Space Complexity: 0(1)
'''
Find all the children of kill (add in a queue), until we can't find a parent. append to res.
To find , we will sort ppid first and permute pid as ppid to be able to perform binary search.
To make sure we find all children, we binary search for low and for high and return low:high+1
'''

class Solution:
    def killProcess(self, pid: List[int], ppid: List[int], kill: int) -> List[int]:
        if not pid:
            return []
        if kill==0:
            return pid
        
        def binary_search(ziped,killed_parent):
            lower=None
            upper=None
            
            low,high=0, len(ziped)-1
            #find lower target
            while high>=low:
                mid=low+(high-low)//2
                if ziped[mid][0]==killed_parent:
                    if mid==len(ziped)-1 or ziped[mid+1][0]>ziped[mid][0]:
                        upper=mid
                        break
                    low=mid+1
 
                elif ziped[mid][0]>killed_parent: high=mid-1
                else: low=mid+1
                
            low,high=0,len(ziped)-1  
            while high>=low:
                mid=low+(high-low)//2
                if ziped[mid][0]==killed_parent:
                    if mid==0 or ziped[mid-1][0]<ziped[mid][0]:
                        lower=mid
                        break
                    high=mid-1
                
                elif ziped[mid][0]>killed_parent: high=mid-1
                else: low=mid+1
            return lower,upper
                    

        ziped=[(x,y) for x,y in zip(ppid,pid)]
        ziped.sort()

        q=collections.deque()
        q.append(kill)
        res=[]
        
        while q:
            to_kill=q.popleft()
            res.append(to_kill)
            lower,upper=binary_search(ziped,to_kill)
            if lower and upper:
                for i in range(lower,upper+1):
                    q.append(ziped[i][1])
        return res
