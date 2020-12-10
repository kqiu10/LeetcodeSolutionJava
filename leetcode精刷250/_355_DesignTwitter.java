/**
 * Date: 12/10/20
 * Question Description
 Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

 postTweet(userId, tweetId): Compose a new tweet.
 getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 follow(followerId, followeeId): Follower follows a followee.
 unfollow(followerId, followeeId): Follower unfollows a followee.
 Example:

 Twitter twitter = new Twitter();

 // User 1 posts a new tweet (id = 5).
 twitter.postTweet(1, 5);

 // User 1's news feed should return a list with 1 tweet id -> [5].
 twitter.getNewsFeed(1);

 // User 1 follows user 2.
 twitter.follow(1, 2);

 // User 2 posts a new tweet (id = 6).
 twitter.postTweet(2, 6);

 // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 twitter.getNewsFeed(1);

 // User 1 unfollows user 2.
 twitter.unfollow(1, 2);

 // User 1's news feed should return a list with 1 tweet id -> [5],
 // since user 1 is no longer following user 2.
 twitter.getNewsFeed(1);
 */

import graph.prim.Prim;

import java.util.*;

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class _355_DesignTwitter {
    private int timeStamp = 0;
    private HashMap<Integer, User> usermap;

    class Tweet {
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }
    class User {
        public int id;
        public HashSet<Integer> followed;
        public Tweet tweetHead;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id);
            tweetHead = null;
        }
        public void follow(int id) {
            followed.add(id);
        }
        public void unFollow(int id) {
            followed.remove(id);
        }
        public void post(int id) {
            Tweet tweet = new Tweet(id);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }
    }
    /** Initialize your data structure here. */
    public _355_DesignTwitter() {
        usermap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!usermap.containsKey(userId)) {
            User user = new User(userId);
            usermap.put(userId, user);
        }
        usermap.get(userId).post(tweetId);
    }
    /**
    * Description: TODO
    * Time complexity:O(nlogn);
    * Space complexity: O(n);
    */
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if (!usermap.containsKey(userId)) return res;
        HashSet<Integer> users = usermap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));
        for (int user : users) {
            Tweet tweet = usermap.get(user).tweetHead;
            if (tweet != null) {
                pq.offer(tweet);
            }
        }
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            Tweet tweet = pq.poll();
            res.add(tweet.id);
            count++;
            if (tweet.next != null) {
                pq.offer(tweet.next);
            }
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!usermap.containsKey(followerId)) {
            User follower = new User(followerId);
            usermap.put(followerId, follower);
        }
        if (!usermap.containsKey(followeeId)) {
            User followee = new User(followeeId);
            usermap.put(followeeId, followee);
        }
        usermap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!usermap.containsKey(followerId) || followerId == followeeId) return;
        usermap.get(followerId).unFollow(followeeId);
    }
}
