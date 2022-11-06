public class Mexam_skeleton_4Class implements Comparable <Mexam_skeleton_4Class> {
	int SerialNumber;
	String Name;
	
	public String swimingScore;
	public int swim;

	public String bikingScore;
	public int bike;

	public String runningScore;
	public int run;
	
	public String totalScoreStr;
	public int totalScore;

	public int ranked;

	public Mexam_skeleton_4Class() {
		swimingScore = "0";
		bikingScore = "0";
		runningScore = "0";
	}
	
	public Mexam_skeleton_4Class(int SerialNumber, String name, String swimingScore, String bikingScore, String runningScore) {
		// TODO: Add some code here
		this.SerialNumber = SerialNumber;
		this.Name = name;

		this.swimingScore = swimingScore;
		this.bikingScore = bikingScore;
		this.runningScore = runningScore;

		// swim score : hh:mm:ss
		String[] swimScore = swimingScore.split(":");
		swim = Integer.parseInt(swimScore[0]) * 3600 + Integer.parseInt(swimScore[1]) * 60 + Integer.parseInt(swimScore[2]);

		// bike score : hh:mm:ss
		String[] bikeScore = bikingScore.split(":");
		bike = Integer.parseInt(bikeScore[0]) * 3600 + Integer.parseInt(bikeScore[1]) * 60 + Integer.parseInt(bikeScore[2]);

		// run score : hh:mm:ss
		String[] runScore = runningScore.split(":");
		run = Integer.parseInt(runScore[0]) * 3600 + Integer.parseInt(runScore[1]) * 60 + Integer.parseInt(runScore[2]);

		this.totalScore = swim + bike + run;
		this.totalScoreStr = String.format("%02d:%02d:%02d", this.totalScore / 3600, (this.totalScore % 3600) / 60, this.totalScore % 60);
	}

	public void setRanked(int ranked) {
		this.ranked = ranked;
	}
	
	public int compareTo(Mexam_skeleton_4Class o)
	{
		// increasing order
		if(this.totalScore > o.totalScore) {
			return 1;
		} else if(this.totalScore < o.totalScore) {
			return -1;
		} else {
			if(this.SerialNumber > o.SerialNumber) {
				return 1;
			} else if(this.SerialNumber < o.SerialNumber) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}
