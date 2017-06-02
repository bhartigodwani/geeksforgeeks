import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Arrays;

class String4{
    public static void main(String[] args){
        String str = "geeksforgeeks";
        System.out.println("string = "+str);
        
        /*---------------------------------approach 1---------------------------------*/
        /*---------------------------------by sorting---------------------------------*/
        char ch[] = str.toCharArray();
        Arrays.sort(ch);
        int c1=0, c2=0;
        for (int i=0; i<ch.length; i++){
            if()
        } 
        System.out.println("string  = "+String.valueOf(ch));
        
        HashMap<Character, Integer> map = new HashMap<Character,Integer>();
        
        for (int i=0; i<str.length(); i++){
            map.put(str.charAt(i), (map.containsKey(str.charAt(i)) == true ? map.get(str.charAt(i)) + 1 : 1));    
        } 
        
        Iterator it = map.entrySet().iterator();
        Integer max = Integer.MIN_VALUE;
        Character maxElement = null;
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            if(max < (Integer)pair.getValue() && max!=Integer.MIN_VALUE){
                max = (Integer)pair.getValue();
                maxElement = (Character)pair.getKey();
            }
        }
        
        System.out.println("maxElement = "+maxElement+"     maxCount = "+(maxElement == null ? 0 : max));
    }
}
