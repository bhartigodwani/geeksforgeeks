/*
The Stock Span Problem
The stock span problem is a financial problem where we have a series of n daily price quotes for 
a stock and we need to calculate span of stock’s price for all n days.
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive 
days just before the given day, for which the price of the stock on the current day is less than 
or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, 
then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}

Solution:
for each element find the first number to its left which is greater than the element.
To find span[i] = i - that greater number's index(if Stack is not empty)
else
span[i] = i+1;
*/

import java.util.Stack;
import java.util.Arrays;
class Stack8{
    public static void main (String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        int i;
        int n = 7;
        int price[] = {100, 80, 60, 70, 60, 75, 85};
                     //  0   1   2   3   4   5   6
        int span[] = new int[n];
        for (i=0; i<n; i++)
            span[i] = 1;
        
        stack.push(0);
        for(i=1 ; i<n; i++){
            while(price[i] > price[stack.peek()])
                stack.pop();
            if (stack.isEmpty())
                span[i] = i+1;
            else    
                span[i] = i - stack.peek();
            stack.push(i);
        }
        
        System.out.println("Given stock day prices : "+Arrays.toString(price));
        System.out.println("day : day price : span value");
        for (i=0; i<n; i++)
            System.out.println((i+1)+" : "+price[i]+" : "+span[i]);
    }
}
