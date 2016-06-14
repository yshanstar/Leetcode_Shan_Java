package solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

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
public class Twitter {
	class Tweet {
		int timeStamp;
		int id;

		public Tweet(int id, int timeStamp) {
			this.id = id;
			this.timeStamp = timeStamp;
		}
	}

	private Map<Integer, Set<Integer>> followMap;
	private Map<Integer, List<Tweet>> tweets;
	private AtomicInteger time;

	/** Initialize your data structure here. */
	public Twitter() {
		this.followMap = new HashMap<Integer, Set<Integer>>();
		this.tweets = new HashMap<Integer, List<Tweet>>();
		this.time = new AtomicInteger(0);
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		if (!this.tweets.containsKey(userId)) {
			this.tweets.put(userId, new ArrayList<Tweet>());
		}
		List<Tweet> userTweets = this.tweets.get(userId);
		userTweets.add(new Tweet(tweetId, this.time.getAndIncrement()));
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
	 * in the news feed must be posted by users who the user followed or by the
	 * user herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> result = new ArrayList<Integer>(10);
		PriorityQueue<Tweet> tweetsQueue = new PriorityQueue<Tweet>(new Comparator<Tweet>() {

			@Override
			public int compare(Tweet o1, Tweet o2) {
				// TODO Auto-generated method stub
				return o2.timeStamp - o1.timeStamp;
			}
		});

		Set<Integer> followeeSet = new HashSet<Integer>();
		followeeSet.add(userId);
		if (followMap.containsKey(userId)) {
			followeeSet.addAll(followMap.get(userId));
		}

		for (Integer followee : followeeSet) {
			if (tweets.containsKey(followee)) {
				List<Tweet> tweetList = tweets.get(followee);
				for (Tweet t : tweetList) {
					tweetsQueue.offer(t);
				}
			}
		}

		while (result.size() < 10 && tweetsQueue.size() > 0) {
			Tweet t = tweetsQueue.poll();
			result.add(t.id);
		}

		return result;
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		Set<Integer> followSet = followMap.get(followerId);
		if (followSet == null) {
			followSet = new HashSet<Integer>();
			followMap.put(followerId, followSet);
		}

		followSet.add(followeeId);
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be
	 * a no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		Set<Integer> followSet = followMap.get(followerId);
		if (followSet == null) {
			followSet = new HashSet<Integer>();
			followMap.put(followerId, followSet);
		}

		followSet.remove(followeeId);
	}
}
