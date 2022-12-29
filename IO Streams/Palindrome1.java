import java.util.Scanner;

public class Palindrome1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = "";

        while(true){
            System.out.print(">>> Enter a string: ");
            str = sc.nextLine();
            if(str.equals("000")) break;
            StringBuilder sb = new StringBuilder(str);
            String _str = sb.reverse().toString();

            if(str.equals(_str)){
                System.out.println("**** Yes, it is a palindrome.");
            }
            else{
                System.out.println("**** Not, it is not a palindrome.");
            }
            System.out.println("========================================");
        }
    }
}