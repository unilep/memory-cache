package cache;

import util.ScoreStrategy;

public interface CacheContainer<K> {
	
	ScoreStrategy find(K key);

	void put(K key);
	
}
