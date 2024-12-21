# Time: O(m+n) for both strings
# Space: O(m) for hashmap

class Solution:
    def func1(self, s: str, t: str) -> str:
        m = len(s)

        hmap = {}

        for i in t:                     # frequencymap
            if i in hmap:
                hmap[i]+=1
            else:
                hmap[i]=1
        count = len(hmap)
        
        start = 0                           # reversed logic for 2 pointers
        mini = float('inf')             # size of widnow
        result = ''

        for end in range(m):
            c = s[end]
            # we want to find first occurance left and right which will determine the initial window size of output found
            if c in hmap:
                hmap[c] -=1
                if hmap[c] == 0:
                    count -=1

            # we found first window end at element 10, subsequent windows should be smaller. Lets find first occurance.
            while count == 0:
                windowsize = end - start +1
                if windowsize < mini:
                    mini = windowsize
                    result = s[start:end+1]                           # result
            # outgoing elements need to be added to the counter and hashmap. 9,8,7...
                out = s[start]
                if out in hmap:
                    hmap[out] +=1
                    if hmap[out] > 0:
                        count +=1               # out of loop now
                start +=1

        return result


s = 'no aca she he'
t = 'has'

s1='sdpfogihsdmMopdidsfighksdfghsdgfsdofgb'
t1='modi'
print(Solution().func1(s1,t1))