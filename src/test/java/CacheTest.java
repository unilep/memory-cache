
import algorithm.LFUAlgorithm;
import algorithm.LRUAlgorithm;
import org.junit.Before;
import org.junit.Test;
import util.ScoreStrategy;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CacheTest {

    private PrintStream ps = System.out;
    private List<String> source = Arrays.asList(
            "A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N", "O", "P",
            "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
    private List<String> list = new ArrayList<>();

    @Before
    public void before() {
        final int sourceSize = source.size();
        for (int i = 0; i < 10; i++) {
            int randomIndex = (int) (Math.random() * sourceSize);
            list.add(source.get(randomIndex));
        }
        ps.println(list);
    }

    private void testcode(CacheContainer cacheContainer) {
        long score = list.stream()
                .map(string -> {
                    final int hashCode = string.hashCode();
                    ScoreStrategy scoreStrategy = cacheContainer.find(hashCode);
                    if (scoreStrategy == ScoreStrategy.MISS) {
                        cacheContainer.put(hashCode, string);
                    }
                    return scoreStrategy.getScore();
                })
                .reduce(0, Integer::sum);

        ps.printf("LRU score : %d\n", score);
    }

    @Test
    public void lru() {
        CacheContainer<Integer, String> cacheContainer = new Cache<Integer, String>(new LRUAlgorithm());
        testcode(cacheContainer);
    }

    @Test
    public void lfu() {
        CacheContainer<Integer, String> cacheContainer = new Cache<Integer, String>(new LFUAlgorithm());
        testcode(cacheContainer);
    }

}
