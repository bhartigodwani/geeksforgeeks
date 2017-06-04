/*
Print reverse of a string using recursion
Write a recursive function to print reverse of a given string.
*/
class String5{
    public static void main(String []args){
        String str = "bharti";
        System.out.println("String : "+str);
        System.out.print("method 1 Reversed string : ");
        reverse(str, 0);
        System.out.print("\nmethod 2 Reversed string : ");
        reverse2(str);
    }
    static void reverse(String str, int index){
        if(index >= str.length()){
            return;
        }
        char temp = str.charAt(index);
        reverse(str, index+1);
        System.out.print(temp);
    } 
    
    static void reverse2(String str)
    {
        if ((str==null)||(str.length() <= 1))
           System.out.println(str);
        else
        {
            System.out.print(str.charAt(str.length()-1));
            reverse2(str.substring(0,str.length()-1));
        }
    }
}
