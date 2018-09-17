import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cache.CacheContainer;

public class CacheTest {

	private PrintStream ps = System.out;
	
	private CacheContainer<Integer, String> cacheWithLru;
	private CacheContainer<Integer, String> cacheWithLfu;
	
	List<String> source = Arrays.asList(new String[]{
			"Lorem Ipsum is simply dummy text of the printing and typesetting industry.", 
			"Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
			"It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged",
			"It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
			"It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
			"The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.",
			"Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy.",
			"Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",
			"Contrary to popular belief, Lorem Ipsum is not simply random text.",
			"It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.",
			"Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage",
			"and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC.",
			"This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.",
			"The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.",
			"There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.",
			"If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text.",
			"All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet.",
			"It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable.",
			"The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc."	}); 
	
	List<String> list = new ArrayList<>();
	
	@Before
	public void before() throws UnsupportedEncodingException {
		byte[] a = new String("e7d7f5365cf403faaf39ffec4925bdaa").getBytes(Charset.forName("EUC-JP"));
		System.out.println(new String(a, "UTF-8"));
		for(int i=0; i<100; i++) { list.addAll(source); }
		
		//cacheWithLru = new Cache<Integer, String>(new LRUAlgorithm());
		//cacheWithLfu = new Cache<Integer, String>(new LFUAlgorithm());
	}
	
	@Test
	public void lru() {
		long score = 0L;
		
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			String string = iter.next();
			score += cacheWithLru.find(string.hashCode(), string).ordinal();
			ps.println(cacheWithLru.getResourceInformation());
			ps.println();
		}
		ps.printf("LRU score : %d\n", score);
	}
	
//	@Test
//	void lfu() {
//		long score = 0L;
//		
//		Iterator<String> iter = list.iterator();
//		while(iter.hasNext()) {
//			String string = iter.next();
//			score += cacheWithLfu.find(string.hashCode(), string);
//		}
//		ps.printf("LFU score : %lld\n", score);
//	}

}
