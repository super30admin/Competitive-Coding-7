//Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class MedianFinder {
public:
    /** initialize your data structure here. */
    priority_queue<int> max_pq;
    priority_queue<int, vector<int>, greater<int>> min_pq;
    
    MedianFinder() {
        
    }
    
    void addNum(int num) {
        if(max_pq.size()==0){
            max_pq.push(num);
            return;
        }    
        
        //check if num is less than max_pq top 
        if(num <max_pq.top())   max_pq.push(num);
        else                    min_pq.push(num);
        
        //check if the queue sizes are balanced
        int diff = min_pq.size()-max_pq.size();
        if(abs(diff)>1){
            if(min_pq.size()>max_pq.size()){
                max_pq.push(min_pq.top());
                min_pq.pop();
            }
            else{
                min_pq.push(max_pq.top());
                max_pq.pop();
            }
        }

    }
    
    double findMedian() {
        if(min_pq.size()==0 && max_pq.size()==0) return 0;
        
        if(min_pq.size()==0) return max_pq.top();
        
        if(min_pq.size()==max_pq.size()){
            return double(min_pq.top()+max_pq.top())/2;
        }
        else{
            if(min_pq.size()>max_pq.size()) return min_pq.top();
            
            else                            return max_pq.top();
        }
        
    }
};