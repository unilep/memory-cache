package algorithm;

import util.NodeUtility;
import util.ScoreStrategy;

import java.util.Optional;

public class LFUAlgorithm extends CacheAlgorithm {

    public LFUAlgorithm() {
        nodeUtility = new NodeUtility();
    }

    @Override
    public ScoreStrategy find(Object key) {
        Optional<Object> node = Optional.ofNullable(hashedNodes.get(key));
        return node.isPresent() ? ScoreStrategy.HIT : ScoreStrategy.MISS;
    }

    @Override
    public void put(Object key, Object value) {

    }
}
