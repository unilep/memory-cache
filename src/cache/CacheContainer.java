package cache;

import cache.util.ScoreStrategy;

public interface CacheContainer<K, V> {
	
	ScoreStrategy find(K key, V value);
	
	String getResourceInformation();
	
}
