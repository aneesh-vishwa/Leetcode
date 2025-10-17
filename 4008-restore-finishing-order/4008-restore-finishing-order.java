class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        HashSet<Integer> friendSet = new HashSet<>();
        for (int i = 0; i < friends.length; i++) {
            friendSet.add(friends[i]);
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < order.length; i++) {
            if (friendSet.contains(order[i])) {
                resultList.add(order[i]);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}