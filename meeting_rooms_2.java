// Online Java Compiler
// Use this editor to write, compile and run your Java code online

//Time complexity: O(nlogn) + O(nlogk)
//space complexity : O(logk)
import java.util.*;
import java.io.*;
class HelloWorld {
    public static void main(String[] args) {
        List<List<Integer>> input_array = new ArrayList<>();
        List<Integer> input = new ArrayList<>();
        input.add(0);
        input.add(30);
        List<Integer> input1 = new ArrayList<>();
        input1.add(5);
        input1.add(15);
        input_array.add(input);
        input_array.add(input1);
        Collections.sort(input_array, Comparator.comparingInt(a->a.get(0)));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(List<Integer>list : input_array) {
            pq.add(list.get(1));
            if(list.get(0) >= pq.peek()) {
                pq.poll();
            }
        }
        System.out.println(pq.size());
    }
}