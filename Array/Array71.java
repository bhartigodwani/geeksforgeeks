/*

Find four elements that sum to a given value | Set 2 ( O(n^2Logn) Solution)

Given an array of integers, find all combination of four elements in the array whose sum is equal to a given value X.
For example, if the given array is {10, 2, 3, 4, 5, 9, 7, 8} and X = 23, then your function should print "3 5 7 8" 
(3 + 5 + 7 + 8 = 23).
*/
class Array{
    static class Aux{
        int first;
        int second;
        int sum;
        Aux(int f, int se, int s){
            first = f;
            second = se;
            sum = s;
        }
    }
    
    pubic static void main(String args[]){
        int a[] = {10, 20, 30, 40, 1, 2};
        int X = 23;
        int n = a.length;
        int size = (n*(n-1))/2;
        Aux aux[] = new Aux[size];
        createAuxArray(aux, a);
        findQuadruples(aux, a, X);
    }
    
    static void findQuadruples(Aux []aux, int []a, int X){
        int n = a.length;
        int size = aux.length;
        for(int i=0; i<n-3; i++){
            for(int j=i+1; j<n-2; j++){
                int result = binarySearchPair(i, j, a, aux, 0, size-1);
            }
        }
    }
    
    static int binarySearchPair(int i, int j, int []a, Aux[] aux, int l, int r){
        if(l<=r){
            int mid = (l+r)/2;
            if((X-(a[i]+a[j])) == aux[mid].sum && aux[mid].first != i && aux[mid].second != j)
                return aux[mid].sum;
            
            else if((X-(a[i]+a[j])) < aux[mid].sum)
                return binarySearchPair(i, j, []a, Aux[] aux, l, mid-1);
            
            else if((X-(a[i]+a[j])) > aux[mid].sum)
                return binarySearchPair(i, j, []a, Aux[] aux, mid+1, r);            
        }
        return -1;
    }
    
    static void createAuxArray(Aux []aux, int []a){
        int k = 0;
        int n = a.length;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                aux[k].sum = a[i] + a[j];
                aux[k].first = i;
                aux[k].second = j;
                k++;
            }
        }
    }
}
