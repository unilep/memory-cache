package util;

public enum ScoreStrategy {
	HIT(19), MISS(5);
	int score;
	ScoreStrategy(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}
}
