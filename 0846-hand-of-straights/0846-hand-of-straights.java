class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }

        HashMap<Integer,Integer> countMap = new HashMap<>();
        for(int card : hand){
            countMap.put(card,countMap.getOrDefault(card,0)+1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(countMap.keySet());

        while(!minHeap.isEmpty()){
            int current = minHeap.peek();

            if(countMap.get(current) == 0){
                minHeap.poll();
                continue;
            }

            int count = countMap.get(current);
            for(int i = 0;i<groupSize;i++){
                int nextCard = current+i;

                if(countMap.getOrDefault(nextCard,0) < count){
                    return false;
                }
                
                countMap.put(nextCard, countMap.get(nextCard) - count);
            }
        }
        return true;
    }
}