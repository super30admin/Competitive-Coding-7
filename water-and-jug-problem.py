# tc O(x * y), sc O(x * y).
# https://leetcode.com/problems/water-and-jug-problem/
# bfs
queue = deque([(0, 0)])
visited = set([(0, 0)])

def enqueue(a, b):
    queue.append((a, b))
    visited.add((a, b))

while queue:
    a, b = queue.popleft()
    if a == target or b == target or a + b == target:
        return True
    
    # fill jugs
    if a < x and (x, b) not in visited:
        enqueue(x, b)
    
    if b < y and (a, y) not in visited:
        enqueue(a, y)

    # empty jugs
    if a > 0 and (0, b) not in visited:
        enqueue(0, b)
        
    if b > 0 and (a, 0) not in visited:
        enqueue(a, 0)

    # tranfer
    # from a to b
    # until a is empty
    if y-b >= a and (0, b+a) not in visited:
        enqueue(0, b+a)
    
    # until b is full
    if y-b <= a and (a-y+b, y) not in visited:
        enqueue(a-y+b, y)
    
    # from b to a
    # until b is empty
    if x-a >= b and (a+b, 0) not in visited:
        enqueue(a+b, 0)
        
    # until a is full
    if x-a <= b and (x, b-x+a) not in visited:
        enqueue(x, b-x+a)

return False