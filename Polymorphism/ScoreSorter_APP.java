import java.util.Arrays;

public class ScoreSorter_APP{
    public static void main(String[] args){
        ScoreSorter[] data = new ScoreSorter[10];

        data[0] = new ScoreSorter(70, 70, 40);
        data[1] = new ScoreSorter(50, 80, 80);
        data[2] = new ScoreSorter(80, 100, 20);
        data[3] = new ScoreSorter(70, 90, 100);
        data[4] = new ScoreSorter(70, 60, 80);
        data[5] = new ScoreSorter(100, 30, 80);
        data[6] = new ScoreSorter(80, 80, 40);
        data[7] = new ScoreSorter(80, 40, 50);
        data[8] = new ScoreSorter(100, 90, 90);
        data[9] = new ScoreSorter(90, 80, 90);

        Arrays.sort(data);

        for(int i = 0; i < data.length; i++){
            System.out.println("Total : " + data[i].getTc() + " Chinese : " + data[i].getCh() + " English : " + data[i].getEn() + " Math : " + data[i].getMa());
        }
    }
}