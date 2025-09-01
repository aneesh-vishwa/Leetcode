class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        set.add(n);

        while(!queue.isEmpty()){
            int num = queue.poll();
            int sum = 0;
            while(num > 9){
                int rem = num%10;
                sum += rem*rem;
                num = num/10;
            }
            sum += num*num;

            if(sum == 1){
                return true;
            }
            if(!set.contains(sum)){
                set.add(sum);
                queue.add(sum);
            }
        }
        return false;
    }
}