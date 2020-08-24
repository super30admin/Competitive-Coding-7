#Time complexity - O(nk log k)  where k is the number of lists and n is the avg length of lists
# Space complexity - O(k) where k is the number of lists
# Works on leetcode - yes 
# Approach - First we iterate through all lists and add the index with list node to a dictionary and first node of each list to the minheap.
#Then while the minheap lasts, we iterate through all nk nodes. We pop the min element from the minheap and add it to the result list and move
#it to next. We also move the start of this min list to next node in our dictionary. Now we add this next node along with it's index to the 
#minheap. In the end we return the result. 
import heapq
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        minheap = []
        listdict = {}
        if not lists:
            return None
        head = ListNode(-1)
        node = head
        for i,l in enumerate(lists):
            if l:
                heapq.heappush(minheap,(l.val, i))
                listdict[i]=l
        while minheap:
            cval, cid = heapq.heappop(minheap)
            node.next = listdict[cid]
            node = node.next
            listdict[cid]=listdict[cid].next
            if listdict[cid]:
                heapq.heappush(minheap, (listdict[cid].val, cid))
        return head.next