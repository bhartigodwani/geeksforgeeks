/*
Remove all duplicates from a given string
*/

class String9{
    public static void main(String []args){
        String s[] = {"geeksforgeeks", "bhartiii", "yeeeee"};
        for(int i=0; i<s.length; i++){
            int chCount[] = new int[26];
            String str = s[i];
            System.out.println("String = "+str);
            /*constructing count array*/
            for(int j=0; j<str.length(); j++){
                int k = (int)str.charAt(j) - 97;
                chCount[k]++;                                        
            }
            /*newString for storing the string after removal of duplicates*/
            String newString = "";
            int t ;
            for(int x=0; x<str.length(); x++){
                t = (int)(str.charAt(x)) -97;
                if(chCount[t] == 1)
                    newString += (char)(t+97);
            }
            /*to print in the given string order */
            System.out.println("newString = "+newString+"\n");
         }
        
    }
}
