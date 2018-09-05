package cache.algorithm;

import java.util.HashMap;
import java.util.Map;

import cache.util.Node;
import cache.util.NodeUtility;

public class LRUAlgorithm<V> implements CacheAlgorithm<V> {

	private NodeUtility<V> nodeUtility;
	private int cacheSize;
	private Node<V> leastRecentlyUsed;
	private Node<V> mostRetenclyUsed;
	private Map<V, V> hashedNodes = new HashMap<>();
	
	public LRUAlgorithm() {
		nodeUtility = new NodeUtility<V>();
		this.cacheSize = cacheSize;
	}
	
	@Override
	public void whenMiss(V obj) {
		nodeUtility.pushFront(new Node<V>(obj));
	}

	@Override
	public void whenHit(V obj) {
		nodeUtility.pushFront(new Node<V>(obj));
		
	}

}
