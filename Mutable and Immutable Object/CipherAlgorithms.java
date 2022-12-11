import java.util.Scanner;

public class CipherAlgorithms{
    public static void main(String[] args){
        String encodeBook = "ICOXDPBUQJARHKNGWYLEZSVFMT";
        String encode = "RZFEXP NCPFCQPG GCRTPGKMQFX ECL AHSA";

        char[] encodeArray = encode.toCharArray();
        String keyword;

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the keyword: ");
        keyword = sc.next();

        int key_length = keyword.length();
        String decode = "";

        int cnt = 0;
        boolean flag = true;

        for(int i=0; i<encode.length(); i++){
            if(encodeArray[i] == ' '){
                decode += ' ';
                flag = true;
                
                continue;
            }

            int start = encodeBook.indexOf(keyword.charAt(cnt % key_length));
            int end = encodeBook.indexOf(encode.charAt(i));

            int interval = (end - start > 0 ? end - start : 26 + (end - start));
            char alpha = (char)('a' + interval < 122 ? 'a' + interval : 'a' + interval - 26);

            decode += (flag ? Character.toUpperCase(alpha) : alpha);
            cnt++;

            flag = false;
        }

        System.out.println();
        System.out.println("keyword: " + keyword);
        System.out.println("Original Text: " + decode);
        System.out.println("Uppercase Text: " + decode.toUpperCase());
        System.out.println("Encoded Text: " + encode);
        System.out.println("Decoded Text: " + decode.toUpperCase());
    }
}