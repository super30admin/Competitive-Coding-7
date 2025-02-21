class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) == 0 or len(t) == 0 or len(s) < len(t):
            return ""

        hashMap = {}

        for i in t:
            if i not in hashMap:
                hashMap[i] = 0
            hashMap[i] += 1
        
        match = 0
        temp = 99999999999
        i, j = 0, 0
        out = ""

        while i <= j  and i < len(s):
            if match == len(hashMap):
                temp = min(temp, j-i)
                if temp == j - i:
                    out = s[i:j]

            if (i != j and match == len(hashMap)) or j == len(s):
                if s[i] in hashMap:
                    if hashMap[s[i]] == 0:
                        match -= 1
                    hashMap[s[i]] += 1
                i += 1
            else:
                if s[j] in hashMap:
                    if hashMap[s[j]] == 1:
                        match += 1
                    hashMap[s[j]] -= 1
                j+= 1
        return out


        