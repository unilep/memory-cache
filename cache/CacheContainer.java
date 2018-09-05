package cache;

public interface CacheContainer<V> {
	
	long find(V value);
	
}
