# Time complexity = o(m+n)
# space complexity = o(m)

class Solution:
    def kthSmallest(self, S: str, T: str) -> str:
        map = defaultdict(int)
        result = []
        for i in range(len(T)):
            map[T[i]] += 1
        
        for j in range(len(S)):
            count = map[S[j]]
            while count > 0:
                result.append(S[j])
                count -=1
            del map[S[j]]
        
        for ch in map:
            count = map[ch]
            while count > 0:
                result.append(map[ch])
                count -= 1

        return ''.join(result)