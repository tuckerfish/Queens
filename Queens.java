//Queens.java
class Queens{
   public static void main(String[] args){
      int n = args.length;
      int t = 5;
      int count = 0;
      boolean vOption = true;
 
      if( t > -1){
         int f = factorial(t);
         int [] e = new int[t +1];
	 for(int i = 1; i < t+1; i++){
            e[i] = i;
         } 
         for(int i = 0; i < f; i++){
            if(isSolution(e) == true){
               count++;
               if(vOption = true){
                  printArray(e);
               }
            }
            nextPermutation(e);
         }
         System.out.print(t+"-Queens has " + count + "solutions");
      } 
 
   }



   // nextPermutation function
   static void nextPermutation(int[] n){
      int pivot = -1;
      int successor = -1;
      int i,j,s;
      for(i = n.length-2; i >0; i--){
         if(n[i] < n[i+1]){
            pivot = i;
            break;
         }
      }
      if(pivot == -1){
         reverse(n,1,n.length-1);
         return;
         
      }
      for(s = n.length-1; s >0; s--){
         if(n[s] > n[pivot]){
            successor = s;
            break;
         }
      }
      swap(n,pivot,successor);
      reverse(n,pivot+1,n.length-1);
      return;
      
   }

   // isSolution function
   static boolean isSolution(int[] A){
      int n = A.length-1;
      int k = n*(n-1)/2;
      int i, j;
      for(i=0; i<n; i++){
         for(j=i+1; j<=n; j++){
            //System.out.println("{"+(i+1)+","+j+"}");
            if(Math.abs(A[j]-A[i]) == Math.abs(j-i)){
               return false;
            } else{
               return true;
         }
      } 
      return true;
   }
    
   // factorial function
   static int factorial(int A){
      int sum = 1;
      for(int i = 1; i <= A; i++){
         sum = sum * i;
      }
      return sum;
   }
   
   // printArray function
   static void printArray(int[] A){
      System.out.print("(");
      for(int i =1; i< A.length-1; i++){
         System.out.print(A[i] + ", ");
      }
      System.out.println(A[A.length-1]+")");
   }

   // swap function
   static void swap(int[] A, int i, int j){
      int temp = A[i];
      A[i] = A[j];
      A[j] = temp;
   }

   // reverse function
   static void reverse(int[] A, int start, int end){
      int i = start, j = end;
      while(i<j){
         swap(A,i,j);
         i++;
         j--;
      }
      return;
   }
   
   // usage function
   static void usage(){
      System.out.println("YOU GOOFED UP, BRO!");
      System.exit(1); 
   }
}
         
