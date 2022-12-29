import java.util.Scanner;

public class ChiperAlgorithms{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String keyword = "FENGCHIA";
        char[] keyarr = keyword.toCharArray();
        String input = sc.nextLine();
        char[] inputarr = input.toUpperCase().toCharArray();
        int key_lenght = keyword.length();
        int cnt = 0;
        for(int i = 0 ; i < input.length() ; i++){
            if(inputarr[i] == ' ') continue;
            else{
                inputarr[i] += keyword.charAt(cnt % key_lenght) - 'A';
                if(inputarr[i] > 90) inputarr[i] -= 26;
                cnt++;
            }
        }
        System.out.println();
        System.out.println("keyword: " + keyword);
        System.out.println("Original Text: " + input);
        System.out.println("Uppercase Text: " + input.toUpperCase());
        System.out.print("Encoded Text: ");System.out.println(inputarr);
        System.out.println("Decoded Text: " + input.toUpperCase());
    }
}