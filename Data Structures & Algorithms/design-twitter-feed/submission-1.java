class Twitter {
    HashMap<Integer, HashSet<Integer>> followedBy = new HashMap<>();
    List<int[]> feed = new ArrayList();

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        followedBy.putIfAbsent(userId, new HashSet<>());
        followedBy.get(userId).add(userId);
        feed.add(new int[] {userId, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        int size = 0;
        HashSet<Integer> following = followedBy.get(userId);
        for (int i = feed.size() - 1 ; i >= 0 ; i--) {
            int[] tweet = feed.get(i);
            if (!following.contains(tweet[0])) continue;
            result.add(tweet[1]);
            size++;
            if (size == 10) break;
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followedBy.putIfAbsent(followeeId, new HashSet());
        followedBy.putIfAbsent(followerId, new HashSet());
        followedBy.get(followeeId).add(followeeId);
        followedBy.get(followerId).add(followerId);
        followedBy.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followedBy.get(followerId).remove(followeeId);     
    }
}
