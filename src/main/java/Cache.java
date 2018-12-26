import algorithm.CacheAlgorithm;
import util.Node;
import util.ScoreStrategy;

public class Cache<K, V> implements CacheContainer<K, V> {

	private static final int DEFAULT_CACHE_SIZE = 3;
	
	private CacheAlgorithm cacheAlgorithm;
	
	public Cache(CacheAlgorithm cacheAlgorithm) {
		this(cacheAlgorithm, DEFAULT_CACHE_SIZE);
	}
	
	public Cache(CacheAlgorithm cacheAlgorithm, int cacheSize) {

		if(cacheSize < DEFAULT_CACHE_SIZE) {
			throw new IllegalArgumentException("Cache size must be greater than " + DEFAULT_CACHE_SIZE);
		}
		
		cacheAlgorithm.setCacheSize(cacheSize);
		this.cacheAlgorithm = cacheAlgorithm;
	}
	
	@Override
	public ScoreStrategy find(K key) {
		return cacheAlgorithm.find(key);
	}

	@Override
	public void put(K key, V value) {
		cacheAlgorithm.put(key, value);
	}

	@Override
	public String getResourceInformation() {
		return cacheAlgorithm.getCacheInformations();
	}

	public int getCacheSize() {
		return cacheAlgorithm.getCacheSize();
	}

	public void setCacheSize(int cacheSize) {
		cacheAlgorithm.setCacheSize(cacheSize);
	}

	
	
}
