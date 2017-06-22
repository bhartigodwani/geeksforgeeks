/*
Find Itinerary from a given list of tickets
Given a list of tickets, find itinerary in order using the given list.

Example:
Input:
"Chennai" -> "Banglore"
"Bombay" -> "Delhi"
"Goa"    -> "Chennai"
"Delhi"  -> "Goa"

Output: 
Bombay->Delhi, Delhi->Goa, Goa->Chennai, Chennai->Banglore,

Solution:
1. using topological sorting
2. using hashing(below implementation)
*/

import java.util.*;
class Hash3{
    public static void main(String []args){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Chennai", "Banglore");
        map.put("Bombay", "Delhi");
        map.put("Goa", "Chennai");
        map.put("Delhi", "Goa");
        String start = "";
        for(Map.Entry<String,String> entry : map.entrySet()){
            if(!map.containsValue(entry.getKey())){
                start = entry.getKey();
                break;
            }
        }
        
        System.out.println("start "+start);
        while(true){
            System.out.println(start+" -> "+map.get(start));
            if(!map.containsKey(map.get(start)))
                break;
            start = map.get(start);
        }
    }
}
