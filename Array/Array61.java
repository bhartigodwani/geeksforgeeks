/*
The Celebrity Problem
In a party of N people, only one person is known to everyone. Such a person may be present in the party, if yes, (s)he 
doesn’t know anyone in the party. We can only ask questions like “does A know B? “. Find the stranger (celebrity) in minimum 
number of questions.
*/
import java.util.Stack;
class Array{
    public static void main(String []args){
        System.out.println("given ralationships:(if a[1][2] == 0 means 1 doesnot know 2 or if a[1][2] == 1 means 1 knows 2)");
        int a[][] = {
            {0,0,0,1,0,1},
            {0,0,0,1,1,0},
            {0,1,0,1,0,0},
            {0,0,0,0,0,0},
            {1,1,1,1,0,0},
            {1,1,1,1,0,1}
        };
        
        /*int a[][] = {{0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0}
        };*/
        System.out.println("    0  1  2  3  4  5");
        System.out.println("    -----------------");
        for(int i=0; i<a.length; i++){
            System.out.print(i+"  | ");
            for(int j=0; j<a[0].length; j++){
                System.out.print(a[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println("\ncelebrity M1 = "+findCelebrityM1(a));//using stack
        System.out.println("celebrity M2 = "+findCelebrityM2(a));//using two pointers
    }
    
    static int findCelebrityM1(int [][]a){
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<a.length; i++)
            stack.push(i);//push all the party guests in stack
        
        while(true){//pop top 2 guests if a knows b then pop a, if vice versa then pop b if bth know each other pop both
            int A = stack.pop();
            int B = stack.pop();
            if(haveAcquaintance(a, A, B) == 1)//A knows B
                stack.push(B);
            else if(haveAcquaintance(a, B, A) == 1)//B knows A
                stack.push(A);
            if(stack.size() == 1)
                break;
        }
        return stack.peek();
    }
    
    static int findCelebrityM2(int [][]a){
        if(a.length == 1)//only one person is present at party
            return 0;
        
        int temp[] = new int[a.length];
        for(int i=0; i<a.length; i++)
            temp[i] = i;
        int lptr=0, rptr=1;
        while(lptr < a.length && rptr < a.length){
            if(haveAcquaintance(a, lptr, rptr) == 1){
                lptr = rptr;
                rptr += 1;
            }
            
            else if(haveAcquaintance(a, lptr, rptr) == -1)
                rptr += 1;
            
            else if(haveAcquaintance(a, lptr, rptr) == 0){
                lptr += 2;
                rptr += 2;
            }
        }
        return lptr;
    }
    
    
    static int haveAcquaintance(int a[][], int A, int B){
        if(a[A][B] == 1 && a[B][A] == 0)
            return 1;//when A know B
        
        else if(a[B][A] == 1 && a[A][B] == 0)
            return -1;//when B know A
        return 0;//when both know each other or both doesnot know each other
    }
}
