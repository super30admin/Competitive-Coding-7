//Time Comp : O(NlogN), where n is the number of elements in the array.
//Space Comp: O(N), where n is the number of elements in the array.

#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

bool myComp(pair<int,int> a, pair<int,int> b){
    return a.first<b.first;
}
int func(vector<pair<int,int>> vec){
    sort(vec.begin(),vec.end(),myComp);
    
    priority_queue<int,vector<int>,greater<int>>pq;
    pq.push(vec.at(0).second);
    for(int i = 1; i<vec.size(); i++){
        if(vec.at(i).first < pq.top()){
            pq.push(vec.at(i).second);
        }
        else{
            pq.pop();
            pq.push(vec.at(i).second);
        }
    }
    return pq.size();
}


int main()
{
   cout << "Hello World" << endl; 
   vector<pair<int,int>> pr;
   auto p1 = make_pair(0, 30);
   auto p2 = make_pair(5,10);
   auto p3 = make_pair(15,20);
   pr.push_back(p1);
   pr.push_back(p2);
   pr.push_back(p3);
   cout<<func(pr)<<endl;
   return 0;
}