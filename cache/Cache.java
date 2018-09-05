package cache;

import java.util.Set;

import cache.algorithm.CacheAlgorithm;

public class Cache<V> implements CacheContainer<V> {

	private static final int DEFAULT_CACHE_SIZE = 10;
	
	private int cacheSize;
	private CacheAlgorithm<V> cacheAlgorithm;
	
	private Set<V> set;
	
	public Cache(CacheAlgorithm<V> cacheAlgorithm) {
		this(cacheAlgorithm, DEFAULT_CACHE_SIZE);
	}
	
	public Cache(CacheAlgorithm<V> cacheAlgorithm, int cacheSize) {
		this.cacheAlgorithm = cacheAlgorithm;
		this.cacheSize = cacheSize;
	}
	
	@Override
	public long find(V value) {
		boolean hit = set.contains(value);
		
		
		//cacheAlgorithm.setHitData(value);
		
		return hit ? ScoreStrategy.HIT : ScoreStrategy.MISS;
	}
	
	private abstract class ScoreStrategy {
		static private final int HIT = 5;
		static private final int MISS = 31;
	}
	
}
