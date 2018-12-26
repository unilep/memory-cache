package algorithm;

import util.Node;
import util.NodeUtility;
import util.ScoreStrategy;

import java.util.HashMap;
import java.util.Map;


public abstract class CacheAlgorithm {

	protected NodeUtility nodeUtility;
	protected final Map<Object, Object> hashedNodes = new HashMap<>();
	protected int cacheSize;
	
	protected boolean isFull() {
		return hashedNodes.size() == cacheSize;
	}
	
	public abstract ScoreStrategy find(Object key);

	public abstract void put(Object key, Object value);

	public String getCacheInformations() {
		return nodeUtility.retriveHeadToTail();
	}
	
	public final int getCacheSize() {
		return cacheSize;
	}

	public final void setCacheSize(int cacheSize) {
		this.cacheSize = cacheSize;
	}
	
}
