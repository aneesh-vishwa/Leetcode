// import java.util.*;

// class Solution {
//     public boolean isPrime(int num) {
//         if (num < 2) return false;
//         if (num == 2 || num == 3) return true;
//         if (num % 2 == 0 || num % 3 == 0) return false;

//         for (int i = 5; i * i <= num; i += 6) {
//             if (num % i == 0 || num % (i + 2) == 0) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     public int[] closestPrimes(int left, int right) {
//         int[] output = { -1, -1 };
//         ArrayList<Integer> primes = new ArrayList<>();

//         for (int num = left; num <= right; num++) {
//             if (isPrime(num)) {
//                 primes.add(num);
//             }
//         }

//         if (primes.size() <= 1) {
//             return output;
//         }

//         int minDiff = Integer.MAX_VALUE;
//         for (int i = 1; i < primes.size(); i++) {
//             int diff = primes.get(i) - primes.get(i - 1);
//             if (diff < minDiff) {
//                 minDiff = diff;
//                 output[0] = primes.get(i - 1);
//                 output[1] = primes.get(i);
//             }
//         }

//         return output;
//     }
// }
class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] prime =new boolean[right+1];
        ArrayList<Integer> list=new ArrayList<>();
        int[] ans=new int[2];
          Arrays.fill(prime,true);
        for(int i=2;i<=Math.sqrt(right);i++){
         if(prime[i]==true){
            for(int j=i*i;j<=right;j=j+i){
                prime[j]=false;
  }
         }
        }
        for(int i=Math.max(2,left);i<=right;i++){
            if(prime[i]){
                list.add(i);
            }
        }
 if(list.size()<2){
           ans[0]=-1;
           ans[1]=-1;
           return ans;
        }
        int diff=Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++) {
            int diff1= list.get(i)-list.get(i-1);
            if (diff1<diff) {
                diff=diff1;
                ans[0]=list.get(i - 1);
                ans[1]=list.get(i);
            }
        }     
  return ans;
    }
}