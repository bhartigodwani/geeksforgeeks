import java.util.Scanner;
class Stack{
    static int top1 = -1, top2, maxSize;
    static int stack[];
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the expression :");
        String str = sc.next();
        char ch[] = str.toCharArray();
        
        for (int i=0; i<ch.length; i++){
            if (ch[i] == '{' || ch[i] == '(' || ch[i] == '[')
                pushInStack(ch[i]);
            if (ch[i] == '}' || ch[i] == ')' || ch[i] == ']')
                checkBalance(ch[i]);
        } 
        
        System.out.println("stack 1 after all the operation :");
        for(int i=top1; i>=0; i--){
            System.out.println(twoStackArray[i]+ "  ");
        }
        
        
        System.out.println("\nstack 2 after all the operation :");
        for(int i=top2; i<size; i++){
            System.out.println(twoStackArray[i]+ "  ");
        }
        
    }
    
    public static void pushInStack1(int value){
        top1++;
        if (top1 == maxSize){
            System.out.println("twoStackArray is full");
        } 
        else{
            twoStackArray[top1] = value;            
        }

    }
    
    public static void pushInStack2(int value){
        top2--;
        if(top2 == top1){
            System.out.println("twoStackArray is full");
        }
        else{
            twoStackArray[top2] = value;            
        }
    }
    
    public static void popStack1(){
        if(top1 >= 0)
            top1--;
            System.out.println("twoStackArray is empty");
    }
    
    
    
}
