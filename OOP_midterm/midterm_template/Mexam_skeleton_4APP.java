import java.util.Arrays;

public class Mexam_skeleton_4APP {

	public static void main(String [] args){
		
		// TODO: Add some code here for input testing data
		Mexam_skeleton_4Class[] scoreArray = new Mexam_skeleton_4Class[6];
		scoreArray[0] = new Mexam_skeleton_4Class(101, "Luka Chen", "00:23:17", "01:02:42", "00:48:36"); // a
		scoreArray[1] = new Mexam_skeleton_4Class(102, "Ben Tsai", "00:17:42", "00:58:33", "00:39:21");	// b
		scoreArray[2] = new Mexam_skeleton_4Class(103, "Eric Huang", "00:24:33", "01:06:18", "00:56:12");	// c
		scoreArray[3] = new Mexam_skeleton_4Class(104, "Charles Lin", "00:18:24", "00:59:11", "00:42:41");	// d
		scoreArray[4] = new Mexam_skeleton_4Class(105, "Jerry Wang", "00:21:16", "01:00:49", "00:52:30");	// e
		scoreArray[5] = new Mexam_skeleton_4Class(106, "Bruce Chang", "00:20:08", "00:58:52", "00:47:06");	// f
		
		// TODO: Add some code here for sorting the array
		Arrays.sort(scoreArray);
		
		int ranked = 1;
		for(int i=0; i<scoreArray.length; i++){
			// same total time
			if(i>0 && scoreArray[i].totalScore == scoreArray[i-1].totalScore){
				scoreArray[i].ranked = scoreArray[i-1].ranked;
			}
			else{
				scoreArray[i].ranked = ranked;
			}

			ranked++;
		}
		
		// TODO: Add some code here for output the result
		for(int i = 0; i < scoreArray.length; i++) {
			System.out.printf("%d\t%d\t%s\t%s\t%s\t%s\t%s", scoreArray[i].ranked, scoreArray[i].SerialNumber, scoreArray[i].Name, scoreArray[i].swimingScore, scoreArray[i].bikingScore, scoreArray[i].runningScore, scoreArray[i].totalScoreStr);
			System.out.println();
		}
	
	}
}
