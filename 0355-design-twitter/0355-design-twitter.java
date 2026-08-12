class Twitter {
    private int time = 0;
    private Map<Integer,Set<Integer>> following; //users jisko vo follow krta haii 
    private Map<Integer,List<Tweet>> tweets ;

    class Tweet{
        int id;
        int time;

        Tweet(int id,int time){
            this.id =id;
            this.time = time;
        }
    } 
    class Node{
        int userId;
        int index;

        Node(int userId,int index){
            this.userId =userId;
            this.index = index;
        }
    }

    public Twitter() {
       following = new HashMap<>();
       tweets = new HashMap<>();
       time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        following.putIfAbsent(userId,new HashSet<>());
        following.get(userId).add(userId);

        tweets.putIfAbsent(userId,new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId,time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();

        if(!following.containsKey(userId)){
            return ans;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(
           (a,b) ->{
            
            Tweet t1 = tweets.get(a.userId).get(a.index);
            Tweet t2 = tweets.get(b.userId).get(b.index);

            return t2.time-t1.time;
           }
        );
        
        for (int followee : following.get(userId)) {
            if (tweets.containsKey(followee)) {
                int lastIndex = tweets.get(followee).size() - 1;
                pq.offer(
                    new Node(followee, lastIndex)
                );
            }
        }
        while (!pq.isEmpty() && ans.size() < 10) {

            Node current = pq.poll();

            Tweet currentTweet =
                tweets.get(current.userId).get(current.index);
            ans.add(currentTweet.id);
            if (current.index > 0) {

                pq.offer(
                    new Node(
                        current.userId,
                        current.index - 1
                    )
                );
            }
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId,new HashSet<>() );

        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
         if (followerId == followeeId) {
            return;
        }

        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */