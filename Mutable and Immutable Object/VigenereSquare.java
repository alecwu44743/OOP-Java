import java.util.Scanner;

public class VigenereSquare {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String encodebook = "ICOXDPBUQJARHKNGWYLEZSVFMT";
        String encode = "RZFEXP NCPFCQPG GCRTPGKMQFX ECL AHSA";
        char[] encodearr = encode.toCharArray();
        String keyword = sc.nextLine();
        int key_lenght = keyword.length();
        String decode = "";
        int cnt = 0;
        boolean up = true;
        for(int i = 0 ; i < encode.length() ; i++){
            if(encodearr[i] == ' '){
                decode += ' ';
                up = true; // next char is uppercase
            } 
            else{
                int start = encodebook.indexOf(keyword.charAt(cnt % key_lenght)); // start index
                int end = encodebook.indexOf(encode.charAt(i)); // end index
                int interval = (end - start > 0 ? end - start : 26 + (end - start));  // interval
                char alpha = (char)('a' + interval < 122 ? 'a' + interval : 'a' + interval - 26); // char of interval
                decode += ( up ? Character.toUpperCase(alpha) : alpha); // uppercase or lowercase
                cnt++; // next keyword
                up = false; // next char is lowercase
            }
        }
        System.out.println();
        System.out.println("keyword: " + keyword);
        System.out.println("Original Text: " + decode);
        System.out.println("Uppercase Text: " + decode.toUpperCase());
        System.out.println("Encoded Text: " + encode);
        System.out.println("Decoded Text: " + decode.toUpperCase());
    }
}