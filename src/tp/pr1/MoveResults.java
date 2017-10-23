package tp.pr1;

public class MoveResults {
	private int score = 0;
	private int maxToken;
	private boolean moved;
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score + this.score;
	}
	public int getMaxToken() {
		return maxToken;
	}
	public void setMaxToken(int maxToken) {
		if(maxToken>this.maxToken)
			this.maxToken = maxToken;
	}
	public boolean isMoved() {
		return moved;
	}
	public void setMoved(boolean moved) {
		this.moved = moved;
	}
}
