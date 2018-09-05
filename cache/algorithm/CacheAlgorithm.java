package cache.algorithm;

public interface CacheAlgorithm<V> {

	void whenMiss(V obj);
	
	void whenHit(V obj);
	
}
