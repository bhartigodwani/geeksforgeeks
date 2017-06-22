/*
Find number of Employees Under every Employee
Given a dictionary that contains mapping of employee and his manager as a number of (employee, manager) pairs like below.

{ "A", "C" },
{ "B", "C" },
{ "C", "F" },
{ "D", "E" },
{ "E", "F" },
{ "F", "F" } 

In this example C is manager of A, 
C is also manager of B, F is manager 
of C and so on.
*/
import java.util.*;
class Hash4{
    public static void main(String []args){
        HashMap<Character, Character> map = new HashMap<Character, Character>();//manager-->employee mapping
        map.put('A', 'C');
        map.put('B', 'C');
        map.put('C', 'F');
        map.put('D', 'E');
        map.put('E', 'F');
        map.put('F', 'F');
        
        HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
        for(Map.Entry<Character, Character> entry : map.entrySet()){
            countMap.put(entry.getValue(), ((countMap.containsKey(entry.getValue())) ? countMap.get(entry.getValue())+(( entry.getKey()==entry.getValue()) ? 0 : 1/*if An employee is not his own manager then the count of number of employees working under should not be increase by 1*/) : 1));   
        }
        
        for(Map.Entry<Character, Integer> entry : countMap.entrySet()){
            System.out.println(entry.getKey()+" -> "+entry.getValue());
        }
    }
}
