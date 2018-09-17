package cache.util;

public enum ScoreStrategy {
	HIT(5), MISS(19);
	int score;
	ScoreStrategy(int score) {
		this.score = score;
	}
}
