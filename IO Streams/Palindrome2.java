import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Palindrome2 {
    public static void main(String[] args){
        
        StringBuffer sb = new StringBuffer();
        StringBuffer result = new StringBuffer();
        try{
            FileInputStream filein = new FileInputStream("longest_palindrome.txt");
            int c;
            int num = filein.available();
            while((c = filein.read()) != -1){
                sb.append((char)c);
            }
            int cnt = 0;
            System.out.println(">>> Text length : " + num);
            System.out.println("======================================");
            System.out.println(">>> File longest_palindrome.txt has been read.");
            for(int i = 0 ; i < sb.length() ; i++){
                char ch = sb.charAt(i);
                if((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)){
                    // System.out.print(Character.toUpperCase(ch));
                    result.append(Character.toUpperCase(ch));
                    cnt++;
                }
                else{
                    continue;
                }
            }
            System.out.println(">>> The number of English characters in longest_palindrome.txt : " + cnt);
            System.out.println(">>> The first 500 English characters: ");
        }
        catch(Exception e){
            System.out.println(e);
        }

        int clk = 0;
        for(int i = 0 ; i < 500 ; i++){
            System.out.print(result.charAt(i));
            clk++;
            if(clk % 80 == 0) System.out.println();
        }
        System.out.println();
        System.out.println("======================================");
        
        try{
            FileOutputStream fileout = new FileOutputStream("result.txt");
            fileout.write(result.toString().getBytes());
            fileout.close();
            
            System.out.println(">>> File result.txt has been written.");
            System.out.println("======================================");
            boolean wrong = false;
            int i = 0 , j = result.length() - 1;
            while(i != j || i+1 == j){
                if(result.charAt(i++) != result.charAt(j--)){
                    wrong = true;
                    break;
                }
            }
            if(!wrong) System.out.printf("**** Yes, it is a palindrome. Final indices: i=%d, j=%d\n",i,j);
            else System.out.printf("**** Not, it is not a palindrome. Final indices: i=%d, j=%d\n",i,j);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}