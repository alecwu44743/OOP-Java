import java.util.Scanner;
import java.io.*;

public class FileCopier {
    public static void main(String[] args){
        String[] str = {""};
        try{
            Scanner sc = new Scanner(System.in);
            System.out.print(">>>> ");
            String command = sc.nextLine();
            str = command.split(" ");
            InputStream FI = new FileInputStream(str[1]);
            OutputStream FO = new FileOutputStream(str[2]);
            
            byte[] bytes = new byte[FI.available()];
            int n = 0,m = 0;
            while((n = FI.read(bytes)) > 0){
                m = n;
                FO.write(bytes,0,n);
            }
            System.out.printf("The FileCopier is copied %d bytes successfully.\n",m);
            FI.close();
            FO.close();
        }   
        catch(Exception e){
            System.out.println("The " + str[1] + " does not exist.");
        }

        
    }
}