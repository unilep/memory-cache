
import algorithm.LFUAlgorithm;
import algorithm.LRUAlgorithm;
import cache.Cache;
import cache.CacheContainer;
import org.junit.Before;
import org.junit.Test;
import util.ScoreStrategy;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 알파벳 대문자가 Key
 * 알파벳 소문자가 Key에 해당하는 Value라고 정의한다.
 */
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

    private long testcode(CacheContainer cacheContainer) {
        return list.stream()
                .map(string -> {
                    ScoreStrategy scoreStrategy = cacheContainer.find(string);
                    return scoreStrategy.getScore();
                })
                .reduce(0, Integer::sum);
    }

    @Test
    public void lru() {
        CacheContainer<String> cacheContainer = new Cache<>(new LRUAlgorithm());
        long score = testcode(cacheContainer);
        System.out.println("LRU score : " + score);
    }

    @Test
    public void lfu() {
        CacheContainer<String> cacheContainer = new Cache<>(new LFUAlgorithm());
        long score = testcode(cacheContainer);
        System.out.println("LFU score : " + score);
    }

}
