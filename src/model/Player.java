package model;


public class Player {
	
	private int ScoreRick;
	private int ScoreMorty;
	
	public Player(int scoreRick, int scoreMorty) {
		super();
		ScoreRick = scoreRick;
		ScoreMorty = scoreMorty;
	}
	public int getScoreRick() {
		return ScoreRick;
	}
	public void setScoreRick(int scoreRick) {
		ScoreRick = scoreRick;
	}
	public int getScoreMorty() {
		return ScoreMorty;
	}
	public void setScoreMorty(int scoreMorty) {
		ScoreMorty = scoreMorty;
	}
	
	

}
