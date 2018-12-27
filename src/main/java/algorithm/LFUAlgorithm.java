package algorithm;

import util.ScoreStrategy;

import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

public class LFUAlgorithm extends CacheAlgorithm {

    private static class Node implements Comparable<Node> {
        private Object object;
        private int refCount;

        public Node(Object object) {
            this(object, 1);
        }

        public Node(Object object, int refCount) {
            this.object = object;
            this.refCount = refCount;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(refCount, o.refCount);
        }
    }

    private Queue<Node> queue = new PriorityQueue<>();

    @Override
    public ScoreStrategy find(Object key) {
        Optional<Object> node = Optional.ofNullable(hashedNodes.get(key));
        final boolean isHit = node.isPresent();
        ScoreStrategy scoreStrategy = isHit ? ScoreStrategy.HIT : ScoreStrategy.MISS;

        if(!isHit) {
            if(isFull()) {
                Node last = queue.remove();
                hashedNodes.remove(last.object);
            }
        } else {
            queue.remove(hashedNodes.get(key));
        }

        put(key);

        return scoreStrategy;
    }

    @Override
    public void put(Object key) {
        Node node = new Node(key);
        queue.add(node);
        hashedNodes.put(key, String.valueOf(key).toLowerCase());
    }
}
