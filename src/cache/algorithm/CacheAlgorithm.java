package cache.algorithm;

import java.util.HashMap;
import java.util.Map;

import cache.util.Node;
import cache.util.NodeUtility;
import cache.util.ScoreStrategy;

public abstract class CacheAlgorithm {

	protected NodeUtility nodeUtility;
	protected Map<Object, Object> hashedNodes = new HashMap<>();
	protected int cacheSize;
	
	protected abstract void isFull();
	
	public abstract ScoreStrategy find(Object key, Node value);
	
	public abstract void whenMiss(Object key, Node obj);

	public abstract String getCacheInformations();
	
	public int getCacheSize() {
		return cacheSize;
	}

	public void setCacheSize(int cacheSize) {
		this.cacheSize = cacheSize;
	}
	
}
