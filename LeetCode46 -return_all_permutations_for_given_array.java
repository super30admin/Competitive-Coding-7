//Competitive coding-7  question

public void helper(int[] arr, int index)
{
    //base case
    if(index == arr.length-1)
    {
        //we reached last index, can't recurse here and have to store the array into list.
        list.add(arr);
        return;
    }
    //logic
    //traverse through the array
    for(int i= index; i<arr.length-1; i++)
    {
        //swap values to get a new array going for recursion
        swap(arr, i, index);
        //recurse
        helper(arr, index+1);
        //back tracking - we had to come intial unswapped array, for further partitioning
        swap(arr, index, i);
    }
}
//TC - O(n!) - why? cause for 1st there are n-1 permutation, 2,n-2, 3rd index n-3 and so on. n(n-1)(n-2)(n-3) and so on
//sc -O(n!) = we have n! permutatuions - so it will generate that many recursive stack. 