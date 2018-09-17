package cache.algorithm;

import cache.util.Node;
import cache.util.NodeUtility;
import cache.util.ScoreStrategy;

public final class LRUAlgorithm extends CacheAlgorithm {

	public LRUAlgorithm() {
		nodeUtility = new NodeUtility();
	}
	
	@Override
	protected void isFull() {
		if(hashedNodes.size() == cacheSize) {
			Node garbage = nodeUtility.popTail();
			hashedNodes.put(garbage, null);
		}
	}
	
	@Override
	public ScoreStrategy find(Object key, Node value) {
		Node node = (Node) hashedNodes.get(key);
		if(node == null) {
			whenMiss(key, value);
		}
		
		isFull();
		nodeUtility.pushFront(value);
		
		return (node == null ? ScoreStrategy.MISS : ScoreStrategy.HIT);
	}
	
	@Override
	public void whenMiss(Object key, Node node) {
		hashedNodes.put(key, node);
	}

	@Override
	public String getCacheInformations() {
		return nodeUtility.retriveHeadToTail();
	}

}
