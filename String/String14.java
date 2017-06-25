/*
Reverse words in a given string
Example: Let the input string be “i like this program very much”. The function should change the string to “much very program 
this like i”
*/

import java.util.*;
class String14{
    public static void main(String []args){
        //String str = "geeks quiz practice code";
        String str = "getting good at coding needs a lot of practice";
        String starr[] = str.split(" ");
        System.out.println("original string = "+str);
        recurReverse(starr, 0);
        System.out.println("final string = "+Arrays.toString(starr));
    }
    
    static int recurReverse(String []starr, int i){
        if(i == starr.length)
            return 0;
        String tempstr = starr[i];
        int index = recurReverse(starr, i+1);
        starr[index] = tempstr;
        return ++index;
    }
}
