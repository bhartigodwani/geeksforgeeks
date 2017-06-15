/*
Divide a string in N equal parts
Write a program to print N equal parts of a given string.
*/
class String11{
    public static void main (String[] args) {
        String str = "abcdef_abcdef_abcdef_abcdef_abcdef_abcdef_abcdef_abcdef_";
        int n = 4;
        System.out.println("s.length = "+str.length());
        int num = str.length()/n;
        System.out.println("num = "+num);
        int i=0, count=0;
        while(i < str.length()){
            count = 0;
            while(count < num && i < str.length()){
                System.out.print(str.charAt(i));
                count++;
                i++;
            }
            System.out.println();
        }
    }
}
