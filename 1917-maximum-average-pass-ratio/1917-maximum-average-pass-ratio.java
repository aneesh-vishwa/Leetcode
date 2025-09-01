class Pair{
    double gain;
    int pass;
    int total;
    Pair(int pass , int total){
        this.pass = pass;
        this.total = total;
        this.gain = calculate_gain(pass , total);
    }
    static double calculate_gain(int pass , int total){
        double before_gain = (double)pass/(double)total;
        double after_gain = (double)(pass + 1)/(double)(total + 1);
        return after_gain - before_gain;
    }
}
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a , b) -> Double.compare(b.gain, a.gain));
        for(int[] it : classes){
            // double perc = (double)it[0]/it[1];
            pq.add(new Pair(it[0] , it[1]));
        }
        while(!pq.isEmpty() && extraStudents > 0){
            Pair pair = pq.poll();
            int pass = pair.pass;
            int total = pair.total;

            int new_pass = pass + 1;
            int new_total = total + 1;
            // double new_prec = (double)(new_pass) / (double) (new_total);
            pq.add(new Pair(new_pass , new_total));
            extraStudents--;
        }
        double output = 0;
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            output += (double) pair.pass / pair.total; 
        }
        return output/classes.length;
    }
}