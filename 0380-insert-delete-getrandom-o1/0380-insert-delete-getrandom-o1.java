class RandomizedSet {
    HashSet<Integer> set = new HashSet<>();
    private Random rand;

    public RandomizedSet() {
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(set.isEmpty()){
            set.add(val);
            return true;
        }
        if(!set.isEmpty() && set.contains(val)){
            return false;
        }
        if(!set.isEmpty() && !set.contains(val)){
            set.add(val);
            return true;
        }
        return true;
    }
    
    public boolean remove(int val) {
        if(set.isEmpty()){
            return false;
        }
        if(!set.isEmpty() && set.contains(val)){
            set.remove(val);
            return true;
        }
        if(!set.isEmpty() && !set.contains(val)){
            return false;
        }
        return false;
    }
    
    public int getRandom() {
        ArrayList<Integer> list = new ArrayList<>(set);
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */