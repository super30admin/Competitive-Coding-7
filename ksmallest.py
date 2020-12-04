#Brute force solution to find the kth smallest elementc
#Time Complexity: O(nlogn)
#Space complexity: O(n)
li = []
matrix = [[ 1,  5,  9],[10, 11, 13],[12, 13, 15]]
k = 8
for r in matrix:
    li.extend(r)
    print(li)
sorted(li)
print(li[k - 1])