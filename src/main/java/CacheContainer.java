import util.ScoreStrategy;

public interface CacheContainer<K, V> {
	
	ScoreStrategy find(K key);

	void put(K key, V value);

	String getResourceInformation();
	
}
