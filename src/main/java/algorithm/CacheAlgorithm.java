package algorithm;

import util.ScoreStrategy;

import java.util.HashMap;
import java.util.Map;


public abstract class CacheAlgorithm {

	private int cacheSize;
	protected final Map<Object, Object> hashedNodes = new HashMap<>();

	public abstract ScoreStrategy find(Object key);

	public abstract void put(Object key);

	public boolean isFull() {
		return hashedNodes.size() == cacheSize;
	}

	public final int getCacheSize() {
		return cacheSize;
	}

	public final void setCacheSize(int cacheSize) {
		this.cacheSize = cacheSize;
	}
	
}
