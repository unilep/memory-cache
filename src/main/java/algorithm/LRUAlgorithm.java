package algorithm;

import util.ScoreStrategy;

import java.util.*;

public final class LRUAlgorithm extends CacheAlgorithm {

	private Deque<Object> deque = new LinkedList<>();

	@Override
	public ScoreStrategy find(Object key) {
		Optional<Object> node = Optional.ofNullable(hashedNodes.get(key));
		final boolean isHit = node.isPresent();
		ScoreStrategy scoreStrategy = isHit ? ScoreStrategy.HIT : ScoreStrategy.MISS;

		if(!isHit) {
			if(isFull()) {
				Object last = deque.removeLast();
				hashedNodes.remove(last);
			}
		} else {
			deque.remove(hashedNodes.get(key));
		}

		put(key);

		return scoreStrategy;
	}

	@Override
	public void put(Object key) {
		deque.push(key);
		hashedNodes.put(key, String.valueOf(key).toLowerCase());
	}

}
